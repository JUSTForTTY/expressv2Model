package com.hundsun.jresplus.quickstart.action.goods;

import java.math.BigDecimal;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hundsun.jresplus.common.util.StringUtil;
import com.hundsun.jresplus.quickstart.biz.bo.TradeCartRecord;
import com.hundsun.jresplus.quickstart.biz.po.Goods;
import com.hundsun.jresplus.quickstart.biz.po.Order;
import com.hundsun.jresplus.quickstart.biz.po.OrderDetail;
import com.hundsun.jresplus.quickstart.biz.po.Orderinfo;
import com.hundsun.jresplus.quickstart.biz.po.Orderitem;
import com.hundsun.jresplus.quickstart.biz.po.Payment;
import com.hundsun.jresplus.quickstart.biz.po.PrepayLog;
import com.hundsun.jresplus.quickstart.biz.po.SubOrder;
import com.hundsun.jresplus.quickstart.biz.po.User;
import com.hundsun.jresplus.quickstart.biz.query.CommentQuery;
import com.hundsun.jresplus.quickstart.biz.query.NormalGoodsQuery;
import com.hundsun.jresplus.quickstart.biz.service.CommentService;
import com.hundsun.jresplus.quickstart.biz.service.GoodsService;
import com.hundsun.jresplus.quickstart.biz.service.LikeService;
import com.hundsun.jresplus.quickstart.biz.service.OrderDetailService;
import com.hundsun.jresplus.quickstart.biz.service.OrderService;
import com.hundsun.jresplus.quickstart.biz.service.OrderinfoService;
import com.hundsun.jresplus.quickstart.biz.service.OrderitemService;
import com.hundsun.jresplus.quickstart.biz.service.PrepayLogService;
import com.hundsun.jresplus.quickstart.biz.service.SequenceService;
import com.hundsun.jresplus.quickstart.biz.service.SubOrderService;
import com.hundsun.jresplus.quickstart.biz.service.UserService;
import com.hundsun.jresplus.quickstart.common.CommonDefine;
import com.hundsun.jresplus.quickstart.common.UserAgent;
import com.hundsun.jresplus.quickstart.enums.EnumGoodsType;

@Controller
public class CreditGoodsAction {

	private String val;

	@Autowired
	private GoodsService goodsService;

	@Autowired
	private CommentService commentService;
	@Autowired
	private OrderitemService orderitemService;
	@Autowired
	private LikeService likeService;
	@Autowired
	private OrderinfoService orderinfoService;
	@Autowired
	private UserService userService;
	@Autowired
	private SequenceService sequenceService;
	@Autowired
	private OrderService orderService;
	 @Autowired
	  private OrderDetailService orderDetailService;
	  
	  @Autowired
	  private SubOrderService subOrderService;
	  @Autowired
	  private PrepayLogService prepayLogService;

	@RequestMapping(value = "/goods/credit/list")
	public String showCurrentPoll(UserAgent user,
			@ModelAttribute("query") NormalGoodsQuery query, Model model) {
		  query.setPageSize(8);
		query.setType(EnumGoodsType.INTEGRAL.getCode());
		 List<String> types = new ArrayList();
		 types.add(EnumGoodsType.INTEGRAL.getCode());
		query.setTypes(types);
	    Long categoryId = query.getCategoryId();
        String name = query.getName();
        // 如果有name字段填写就清空类目
        if (StringUtil.isNotBlank(name)) {
            categoryId = null;
            query.setCategoryId(categoryId);
        }
        Long buildingId = 0L;
        if (user != null) {
            buildingId = user.getBuildingId();
        }
        query.setBuildingId(buildingId);
        goodsService.getPagination(query, model);
       
		return "/goods/credit/list";
	}

	@RequestMapping(value = "/goods/credit/detail")
	public String showView(UserAgent user, @RequestParam(value = "id") Long id,
			@ModelAttribute("query") CommentQuery query, Model model) {

		query.setGoodsId(id);
		commentService.getPagination(query, model);

		Goods goods = goodsService.getById(id);
		// view num +1
		likeService.addViewNum(goods);
		// +1 finish

		model.addAttribute("goods", goods);

		return "/goods/credit/detail";
	}

	@RequestMapping(value = "/goods/credit/exchange", method = RequestMethod.POST)
	public String exchange(UserAgent user, HttpServletRequest request,
			@ModelAttribute Goods goods,
			@RequestParam(value = "goodsid") Long goodsid,
			@RequestParam(value = "integral") Integer integral,
			@RequestParam(value = "goodsNum") Integer goodsNum,
			@RequestParam(value = "prepay") Double prepay,
			@ModelAttribute("query") CommentQuery query, Model model) {
		if (user == null) {
			model.addAttribute("errorMsg", "请先登录！");
			return showView(user, goodsid, query, model);
		} else {
			model.addAttribute("goodsid", goodsid);
			model.addAttribute("integral", integral);
			model.addAttribute("goodsNum", goodsNum);
			model.addAttribute("prepay", prepay);
			User userInfo = userService.selectUserByAccount(user.getUserName());
			model.addAttribute("user", userInfo);
			return "/goods/credit/result";
		}
	}

	@RequestMapping(value = "/goods/credit/pay", method = RequestMethod.POST)
	public String pay(UserAgent user, HttpServletRequest request,HttpSession session,
			@RequestParam(value = "goodsid") Long goodsid,
			@RequestParam(value = "integral") Double integral,
			@RequestParam(value = "goodsNum") Integer goodsNum,
			@RequestParam(value = "prepay") Double prepay,
			@ModelAttribute("query") CommentQuery query, Model model) {
		String receiveName = request.getParameter("receiveName");
		String receivephoneNum = request.getParameter("phoneNum");
		String email = request.getParameter("email");
		String receiveAddr = request.getParameter("receiveAddr");
		// 用户备注
		String mark = request.getParameter("userMark");
		// 支付方式(1,到付；4，预存款付款);
		String payType = request.getParameter("payType");

		// 收货人信息未写全，跳错误页
		if (receiveName == null || receivephoneNum == null
				|| receiveAddr == null) {
			return "error";
		}
		Payment paymentInfo = new Payment();
		 List<TradeCartRecord>  goodsList = new ArrayList();
		Goods goods = goodsService.getById(goodsid);
		goods.setOrdernum(goodsNum.longValue());
		if (Goods.isInSupply(goods, goodsNum)) {
			//
			paymentInfo.calculate(goods, goodsNum);
			 goodsList.add(new TradeCartRecord(goods, goodsNum));
		}else{
			model.addAttribute("errorMsg", "库存数量不足");
			return showView(user, goodsid, query, model);
		}
		// 判断积分是否足够,不够跳错误页
		User userModel = userService.getUserByID(user.getId());
		//System.out.println(userModel.getscore() + "---" + paymentInfo.getScore());
		if (userModel == null || userModel.getscore().intValue() < paymentInfo.getScore()) {
			model.addAttribute("errorMsg", "积分不足，请重新选择");
			return showView(user, goodsid, query, model);
		}
		
		//add tty  判断预付款金额是否足够，不够跳错误页 
		if (userModel == null || userModel.getPrepay() < prepay) {
			model.addAttribute("errorMsg", "预付款不足，请重新选择");
			return showView(user, goodsid, query, model);
		}
		
		
		// 生成订单orderinfo
//		Orderinfo orderinfoModel = new Orderinfo();
 		Date now = new Date();
 		//orderinfoModel.setOrdertime(now);
 		Format format = new SimpleDateFormat("yyyyMMdd");
 		String ordno = format.format(now);
 		Integer seqno = sequenceService.genValidSeqno("orderinfo");
 		ordno = ordno + String.format("%06d", seqno);
//		orderinfoModel.setOrderno(ordno);
//		orderinfoModel.setItemcount(1);
//		// 目前没有优惠券，直接将商品价格与总价格相加
//		orderinfoModel.setGoodssum(paymentInfo.getCash()); // ?
//		orderinfoModel.setServicesum((double) 0);
//		orderinfoModel.setOthersum((double) 0);
//		orderinfoModel.setTotalsum(paymentInfo.getCash()); // ?
//		orderinfoModel.setScore(paymentInfo.getScore());
//		orderinfoModel.setReceivername(receiveName);
//		orderinfoModel.setReceivermobile(receivephoneNum);
//		orderinfoModel.setReceiveremail(email);
//		orderinfoModel.setReceiveraddr(receiveAddr);
//		orderinfoModel.setUser_id(user.getId());
//		orderinfoModel.setUsername(userModel.getUsername());
//		orderinfoModel.setUserremark(mark);
//		orderinfoModel.setStatus(CommonDefine.ORDERINFO_STATUS_NEW);
//		orderinfoModel.setRequireinvoice(0);
//		orderinfoModel.setPaymenttype_id(CommonDefine.ORDERPAYTYPE_SCORE);
//
//		Long ordid = orderinfoService.addOrderinfo(orderinfoModel); // 添加新订单
//		orderinfoModel.setId(ordid);

		// //生成子订单
		// for (TradeCartRecord record : goodsList) {
//		Orderitem item = new Orderitem();
//		// Goods goods = record.getGoods();
//		item.setUnitprice(goods.getPrice());
//		item.setItemnum(goodsNum);
//		item.setGoods_id(goods.getId());
//		item.setGoods_name(goods.getName());
//		item.setPrivatecode(goods.getPrivatecode());
//		item.setUnit(goods.getUnit());
//		item.setUser_id(orderinfoModel.getUser_id());
//		item.setOrderinfo_id(ordid);
//		item.setItemno(CommonDefine.ORDERITEM_ITEMNO_HAVE);
//		item.setItemsum(integral);
//
//		orderitemService.addOrderitem(item);
//		// 更新商品销售量
//		goodsService.increaseSpecificNumById(item.getGoods_id(), "salenum",
//				item.getItemnum());
//		// 更新商品库存量
//		goodsService.increaseSpecificNumById(item.getGoods_id(), "stocknum",
//				item.getItemnum()*-1);
//		// }
		// 修改积分
		 userService.updateScoreById(user.getId(), integral);
		// if (orderinfoModel.getPaymenttype_id() ==
		// CommonDefine.ORDERPAYTYPE_PREPAY) {
//		 Prepaylog prepaylog = new Prepaylog();
//		 prepaylog.setUser_id(orderinfoModel.getUser_id());
//		 prepaylog.setPaysum(-orderinfoModel.getTotalsum());
//		 prepaylog.setPaytype(CommonDefine.PREPAYLOG_TYPE_PAYMENT);
//		 prepaylog.setCreator(orderinfoModel.getUser_id());
//		 prepaylog.setCreatetime(now);
//		 prepaylog.setPaytime(now);
//		 prepaylog.setOrderinfo_id(ordid);
//		 prepaylogService.addPrepaylog(prepaylog);
		//
		// //更新订单状态
		// orderinfoModel.setStatus(32);
		// orderinfoService.updateOrderinfo(orderinfoModel);
		// }

		// model.addAttribute("goodsid", goodsid);
		// model.addAttribute("integral",integral);
		// model.addAttribute("integral",integral);
		// User userInfo = userService.selectUserByAccount(user.getUserName());
		// model.addAttribute("user", userInfo);
		 
		 
		       Long newPrepay = 
			        Long.valueOf(new BigDecimal(Double.valueOf(
			        userModel.getPrepay() - prepay.doubleValue()).toString()).movePointRight(2)
			        .longValue());
			      Long newScore = Long.valueOf(userModel.getscore().longValue() - integral.longValue());
			      user.setScore(newScore);
			      user.setPrepay(newPrepay);
			      session.setAttribute("userAgent", user);

			      PrepayLog prepaylog = new PrepayLog();
			      prepaylog.setUser_id(userModel.getId());
			      prepaylog.setPaysum(prepay);
			      prepaylog.setPaytype("score");
			      prepaylog.setCreator(userModel.getId());
			      prepaylog.setCreatetime(now);
			      prepaylog.setPaytime(now);
			      prepaylog.setOrderinfo_id(Long.parseLong(ordno));
			      this.prepayLogService.addPrepayLog(prepaylog);

			      this.userService.updatePrepayById(userModel.getId(), -prepay.doubleValue());
		 /*
		  * 
		  * add tty 新下单方法
		  */
		 
		    Order order = new Order();
			order.setId(Long.parseLong(ordno));
			order.setGoodsCount(goodsNum);
			order.setPayType(String.valueOf(new CommonDefine().PAY_TYPE_SCORE));
			order.setReceiverAddress(receiveAddr);
			order.setReceiverMobile(receivephoneNum);
			order.setReceiverName(receiveName);
			order.setUser_remarks(mark);
			int totalPriceHandle=(int)(prepay*100);

			order.setTotalPrice(totalPriceHandle);
			order.setTotalScore(integral.intValue());
			order.setUserName(userModel.getUsername());
			order.setIsSplit("0");
			order.setStatus(CommonDefine.ORDERINFO_STATUS_CLOSED);
			System.out.println("order订单增加");
			Long orderId = orderService.add(order);
			//orderinfoModel.setId(ordid);
			Map<Long, SubOrder> subOrderMap = new HashMap<Long, SubOrder>();
			//生成子订单
		 	for (TradeCartRecord record : goodsList) {
			Orderitem item = new Orderitem();
			Goods goodsred = record.getGoods();
			System.out.println("会员单位id"+goodsred.getProviderId());
			double unitPrice = goodsred.getPrice() == null ? 0 : goodsred.getPrice();
			item.setUnitprice(unitPrice);
			item.setItemnum(record.getGoodsNum());
			item.setGoods_id(goods.getId());
			item.setGoods_name(goods.getName());
			item.setUnit(goods.getUnit());
			item.setUser_id(userModel.getId());
			item.setItemno(CommonDefine.ORDERITEM_ITEMNO_HAVE);
			item.setItemsum(unitPrice * record.getGoodsNum());
			//item.setStatus(enumStatus);
			item.setGoods_state(String.valueOf(CommonDefine.ORDERINFO_STATUS_NEW));
			// 拆分订单
			OrderDetail detail = new OrderDetail();
			detail.setOrderId(Long.parseLong(ordno));
			detail.setGoodsCount(record.getGoodsNum());
			detail.setGoodsId(goodsred.getId());
			detail.setGoodsName(goodsred.getName());
			Long memberId = goodsred.getProviderId();
			detail.setMemberId(memberId);
			detail.setMemberName(goodsred.getMemberName());
			detail.setMiniature(goodsred.getMiniature());
			 
			System.out.println("订单号"+orderId);
			System.out.println("member号"+memberId);
			if(null==goodsred.getRefprice()||"".equals(goodsred.getRefprice())){
				goodsred.setRefprice(0d);
			}
			
			int singlePriceHandle = (int) (goodsred.getRefprice() * record.getGoodsNum().intValue()*100);//处理成整数，单位分
			detail.setSinglePrice(singlePriceHandle);

			if(null==integral){
				detail.setSingleScore(0);
			}else{
				detail.setSingleScore(integral.intValue());
			}
			 
			detail.setUnitPrice((int)(goodsred.getRefprice()*100));
			if(null==goodsred.getPrice()){
				detail.setUnitScore(0);
			}else{
				detail.setUnitScore(goodsred.getPrice().intValue());
			}

			 

			if (subOrderMap.containsKey(memberId)) {
			SubOrder subOrder = subOrderMap.get(memberId);
			subOrder.setGoodsCount(subOrder.getGoodsCount() + record.getGoodsNum());
			subOrder.setGoodsTypeCount(subOrder.getGoodsTypeCount() + 1);
			subOrder.setSubtotalPrice(subOrder.getSubtotalPrice() + detail.getSinglePrice());
			subOrder.setMemberId(memberId);
			subOrder.setOrderId(Long.parseLong(ordno));
			subOrder.setStatus(CommonDefine.ORDERINFO_STATUS_CLOSED);
			 
			 
			subOrder.setSubtotalScore(subOrder.getSubtotalScore() + detail.getSingleScore());
			subOrder.getDetailList().add(detail);
			} else {
			SubOrder subOrder = new SubOrder();
			subOrder.setGoodsCount(record.getGoodsNum());
			subOrder.setGoodsTypeCount(1);
			subOrder.setMemberId(memberId);
			subOrder.setMemberName(detail.getMemberName());
			subOrder.setOrderId(Long.parseLong(ordno));
			subOrder.setStatus(CommonDefine.ORDERINFO_STATUS_CLOSED);
			subOrder.setSubtotalPrice(detail.getSinglePrice().longValue());
			subOrder.setSubtotalScore(detail.getSingleScore().longValue());
			subOrder.getDetailList().add(detail);
			subOrderMap.put(memberId, subOrder);
			}

			//orderitemService.addOrderitem(item);
			// 更新商品订购量
			goodsService
			.increaseSpecificNumById(item.getGoods_id(), "ordernum", item.getItemnum());
			}
			Iterator<Long> it = subOrderMap.keySet().iterator();
			while (it.hasNext()) {
			Long key = it.next();
			SubOrder subOrder = subOrderMap.get(key);
			System.out.println("suborder订单增加");

			 Date now2 = new Date();
				   
			 Format format2 = new SimpleDateFormat("yyyyMMdd");
			 String subordno = format.format(now2);
			 Integer seqno2 = this.sequenceService.genValidSeqno("orderinfo");
			 subordno = subordno + String.format("%06d", new Object[] { seqno2 });
			 subOrder.setId(Long.parseLong(subordno));

			Long subOrderId = subOrderService.add(subOrder);
			for (OrderDetail detail : subOrder.getDetailList()) {
				System.out.println("orderdetail订单增加");
			detail.setSubOrderId(Long.parseLong(subordno));
			orderDetailService.add(detail);
		 
		 
	 
			}
			}
			model.addAttribute("errorMsg", "换购成功");
			return showView(user, goodsid, query, model);
	}
	
	private Long addNewOrder(List<TradeCartRecord> goodsList, Orderinfo orderinfoModel,
	          String enumStatus) {
	//Long ordid = orderinfoService.addOrderinfo(orderinfoModel); // 添加新订单
		  
	Order order = new Order();
	order.setId(Long.parseLong(orderinfoModel.getOrderno()));
	order.setGoodsCount(orderinfoModel.getItemcount());
	order.setPayType(orderinfoModel.getPaymenttype_id().toString());
	order.setReceiverAddress(orderinfoModel.getReceiveraddr());
	order.setReceiverMobile(orderinfoModel.getReceivermobile());
	order.setReceiverName(orderinfoModel.getReceivername());
	order.setUser_remarks(orderinfoModel.getUserremark());
	int totalPriceHandle=(int)(orderinfoModel.getTotalsum()*100);

	order.setTotalPrice(totalPriceHandle);
	order.setTotalScore(orderinfoModel.getScore());
	order.setUserName(orderinfoModel.getUsername());
	order.setIsSplit("0");
	order.setStatus(CommonDefine.ORDERINFO_STATUS_NEW);
	System.out.println("order订单增加");
	Long orderId = orderService.add(order);
	//orderinfoModel.setId(ordid);
	Map<Long, SubOrder> subOrderMap = new HashMap<Long, SubOrder>();
	//生成子订单
	for (TradeCartRecord record : goodsList) {
	Orderitem item = new Orderitem();
	Goods goods = record.getGoods();
	double unitPrice = goods.getPrice() == null ? 0 : goods.getPrice();
	item.setUnitprice(unitPrice);
	item.setItemnum(record.getGoodsNum());
	item.setGoods_id(goods.getId());
	item.setGoods_name(goods.getName());
	item.setUnit(goods.getUnit());
	item.setUser_id(orderinfoModel.getUser_id());
	item.setItemno(CommonDefine.ORDERITEM_ITEMNO_HAVE);
	item.setItemsum(unitPrice * record.getGoodsNum());
	item.setStatus(enumStatus);
	item.setGoods_state(String.valueOf(CommonDefine.ORDERINFO_STATUS_NEW));
	// 拆分订单
	OrderDetail detail = new OrderDetail();
	detail.setOrderId(Long.parseLong(orderinfoModel.getOrderno()));
	detail.setGoodsCount(record.getGoodsNum());
	detail.setGoodsId(goods.getId());
	detail.setGoodsName(goods.getName());
	Long memberId = goods.getProviderId();
	detail.setMemberId(memberId);
	detail.setMemberName(goods.getMemberName());
	detail.setMiniature(goods.getMiniature());
	 
	System.out.println("订单号"+orderId);
	System.out.println("member号"+memberId);
	int singlePriceHandle = (int) (goods.getPrice() * record.getGoodsNum().intValue()*100);//处理成整数，单位分
	detail.setSinglePrice(singlePriceHandle);

	if(null==goods.getScore()){
		detail.setSingleScore(0);
	}else{
		detail.setSingleScore((int)(goods.getScore() * record.getGoodsNum()));
	}
	 
	detail.setUnitPrice((int)(goods.getPrice()*100));
	if(null==goods.getScore()){
		detail.setUnitScore(0);
	}else{
		detail.setUnitScore(goods.getScore().intValue());
	}

	 

	if (subOrderMap.containsKey(memberId)) {
	SubOrder subOrder = subOrderMap.get(memberId);
	subOrder.setGoodsCount(subOrder.getGoodsCount() + record.getGoodsNum());
	subOrder.setGoodsTypeCount(subOrder.getGoodsTypeCount() + 1);
	subOrder.setSubtotalPrice(subOrder.getSubtotalPrice() + detail.getSinglePrice());
	subOrder.setMemberId(memberId);
	subOrder.setOrderId(Long.parseLong(orderinfoModel.getOrderno()));
	 subOrder.setStatus(CommonDefine.ORDERINFO_STATUS_NEW);
	 
	 
	subOrder.setSubtotalScore(subOrder.getSubtotalScore() + detail.getSingleScore());
	subOrder.getDetailList().add(detail);
	} else {
	SubOrder subOrder = new SubOrder();
	subOrder.setGoodsCount(record.getGoodsNum());
	subOrder.setGoodsTypeCount(1);
	subOrder.setMemberId(memberId);
	subOrder.setMemberName(detail.getMemberName());
	subOrder.setOrderId(Long.parseLong(orderinfoModel.getOrderno()));
	subOrder.setStatus(CommonDefine.ORDERINFO_STATUS_NEW);
	subOrder.setSubtotalPrice(detail.getSinglePrice().longValue());
	subOrder.setSubtotalScore(detail.getSingleScore().longValue());
	subOrder.getDetailList().add(detail);
	subOrderMap.put(memberId, subOrder);
	}

	//orderitemService.addOrderitem(item);
	// 更新商品订购量
	goodsService
	.increaseSpecificNumById(item.getGoods_id(), "ordernum", item.getItemnum());
	}
	Iterator<Long> it = subOrderMap.keySet().iterator();
	while (it.hasNext()) {
	Long key = it.next();
	SubOrder subOrder = subOrderMap.get(key);
	System.out.println("suborder订单增加");

	 Date now = new Date();
		  
	 Format format = new SimpleDateFormat("yyyyMMdd");
	 String subordno = format.format(now);
	 Integer seqno = this.sequenceService.genValidSeqno("orderinfo");
	 subordno = subordno + String.format("%06d", new Object[] { seqno });
	 subOrder.setId(Long.parseLong(subordno));

	Long subOrderId = subOrderService.add(subOrder);
	for (OrderDetail detail : subOrder.getDetailList()) {
		System.out.println("orderdetail订单增加");
	detail.setSubOrderId(Long.parseLong(subordno));
	orderDetailService.add(detail);
	}
	}
	return Long.parseLong(orderinfoModel.getOrderno());
	}

	public void setVal(String val) {
		this.val = val;
	}

	public String getVal() {
		return val;
	}
}
