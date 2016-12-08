package com.hundsun.jresplus.quickstart.action.goods;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.hundsun.jresplus.common.util.StringUtil;
import com.hundsun.jresplus.quickstart.biz.bo.TradeCartRecord;
import com.hundsun.jresplus.quickstart.biz.po.Category;
import com.hundsun.jresplus.quickstart.biz.po.Comment;
import com.hundsun.jresplus.quickstart.biz.po.Goods;
import com.hundsun.jresplus.quickstart.biz.po.Order;
import com.hundsun.jresplus.quickstart.biz.po.OrderDetail;
import com.hundsun.jresplus.quickstart.biz.po.Orderinfo;
import com.hundsun.jresplus.quickstart.biz.po.Orderitem;
import com.hundsun.jresplus.quickstart.biz.po.Response;
import com.hundsun.jresplus.quickstart.biz.po.Stock_Inventory;
import com.hundsun.jresplus.quickstart.biz.po.SubOrder;
import com.hundsun.jresplus.quickstart.biz.po.User;
import com.hundsun.jresplus.quickstart.biz.query.CategoryQuery;
import com.hundsun.jresplus.quickstart.biz.query.CommentQuery;
import com.hundsun.jresplus.quickstart.biz.query.GoodsQuery;
import com.hundsun.jresplus.quickstart.biz.query.OrderInfoQuery;
import com.hundsun.jresplus.quickstart.biz.query.StockQuery;
import com.hundsun.jresplus.quickstart.biz.service.CategoryService;
import com.hundsun.jresplus.quickstart.biz.service.CommentService;
import com.hundsun.jresplus.quickstart.biz.service.CommonService;
import com.hundsun.jresplus.quickstart.biz.service.GoodsCollectService;
import com.hundsun.jresplus.quickstart.biz.service.GoodsService;
import com.hundsun.jresplus.quickstart.biz.service.OrderDetailService;
import com.hundsun.jresplus.quickstart.biz.service.OrderService;
import com.hundsun.jresplus.quickstart.biz.service.OrderinfoService;
import com.hundsun.jresplus.quickstart.biz.service.OrderitemService;
import com.hundsun.jresplus.quickstart.biz.service.SequenceService;
import com.hundsun.jresplus.quickstart.biz.service.StockService;
import com.hundsun.jresplus.quickstart.biz.service.SubOrderService;
import com.hundsun.jresplus.quickstart.biz.service.UserService;
import com.hundsun.jresplus.quickstart.common.CommonDefine;
import com.hundsun.jresplus.quickstart.common.UserAgent;
import com.hundsun.jresplus.quickstart.enums.EnumGoodsType;
import com.hundsun.jresplus.quickstart.enums.EnumOrderInfoStatus;
import com.hundsun.jresplus.quickstart.enums.EnumPayType;

/**
 * 企业
 * 
 * @author zhouc
 *
 */
@RequestMapping(value = "/goods/stock")
@Controller
public class StockGoodsAction {

	@Autowired
	private StockService stockService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private SubOrderService subOrderService;
	@Autowired
	private OrderDetailService orderDetailService;
	@Autowired
	private SequenceService sequenceService;
	@Autowired
	private CommonService commonService;
	@Autowired
	private UserService userService;
	@Autowired
	OrderinfoService orderinfoService;
	@Autowired
	OrderitemService orderitemService;
	@Autowired
	CommentService commentService;

	@RequestMapping(value = "/list")
	public String showCurrentPoll(@ModelAttribute("query") StockQuery query,UserAgent user,

	Model model) throws ParseException {
		System.out.println(query.getGoods_name());
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// Date startdate = sdf.parse(query.getStartDate());
		// Date enddate = sdf.parse(query.getEndDate());
		// query.setStartDate(startdate.toString());
		// query.setEndDate(enddate.toString());

		query.setUsername(user.getUserName());
		stockService.getList(query);

		return "center/stock/stockList";
	}

	@RequestMapping(value = "/historyList")
	public String orderList(UserAgent user, HttpSession session, HttpServletRequest request,
			@ModelAttribute("query") OrderInfoQuery query, Model model) {

		query.setPayType(CommonDefine.PAY_TYPE_YUNKUNCUN);
		query.setUsername(user.getUserName());
		orderinfoService.getPagination(query);
		model.addAttribute("payTypeMap", EnumPayType.toMap());
		model.addAttribute("orderInfoStatusMap", EnumOrderInfoStatus.toMap());
		return "center/stock/historyList";
	}

	@RequestMapping(value = "/addStock")
	@ResponseBody
	public String addStock2(UserAgent user, Order order, SubOrder subOrder, OrderDetail orderDetail, Model model,
			HttpServletRequest request) throws ParseException {

		Integer goodsId = Integer.parseInt(request.getParameter("id"));
		Integer goodsNum = Integer.parseInt(request.getParameter("goodsNum"));
  
		// 判断选择数量是否符合
		Stock_Inventory stockInventory = new Stock_Inventory();
		stockInventory.setGoods_id(goodsId);
		if (null == user.getUserName() || "".equals(user.getUserName())) {
			Response ret = new Response();
			ret.setErrCode(500);
			return this.commonService.toJson(ret);

		}
		stockInventory.setUser_name(user.getUserName());

		Stock_Inventory checkbean = stockService.getById(stockInventory);

		if (null == checkbean || "".equals(checkbean) || goodsNum > checkbean.getQuantity()) {
			Response ret = new Response();
			ret.setErrCode(400);
			return this.commonService.toJson(ret);

		} else {
			Stock_Inventory doStockInventory = new Stock_Inventory();

			doStockInventory.setGoods_id(goodsId);
			doStockInventory.setQuantity(goodsNum);
			Response ret = new Response();
			ret.setBody(doStockInventory);
			ret.setErrCode(1001);
			return this.commonService.toJson(ret);

		}

	}

	@RequestMapping(value = "/preOrderStock")

	public String preOrderStock(UserAgent user, Order order, SubOrder subOrder, OrderDetail orderDetail, Model model,
			HttpServletRequest request) throws ParseException {

		Integer goodsId = Integer.parseInt(request.getParameter("id"));
		Integer quantity = Integer.parseInt(request.getParameter("quantity"));
		Goods goods = goodsService.getById(goodsId.longValue());
		model.addAttribute("goodsId", goods.getId());
		model.addAttribute("goodsName", goods.getName());
		model.addAttribute("quantity", quantity);
		User userdata = userService.getById(user.getId());

		System.out.println(goodsId);
		System.out.println(quantity);

		model.addAttribute("user", userdata);
		return "center/order/orderStock";
	}

	@RequestMapping(value = "/orderStock")
	public String orderStock(UserAgent user, Order order, SubOrder subOrder, OrderDetail orderDetail,

	Model model, HttpServletRequest request) throws ParseException {

		String receiveName = request.getParameter("receiveName");
		String receiverAddress = request.getParameter("receiverAddress");
		String receiverMobile = request.getParameter("receiverMobile");
		String mark = request.getParameter("userMark");
		Date now = new Date();
		Format format = new SimpleDateFormat("yyyyMMdd");
		String ordno = format.format(now);
		Integer seqno = this.sequenceService.genValidSeqno("orderinfo");

		String ordnocast = ordno + String.format("%06d", new Object[] { seqno });

		//
		Goods goods = goodsService.getById(orderDetail.getGoodsId());

		// 提货，下单进新订单表
		Order orderinfo = new Order();
		orderinfo.setId(Long.parseLong(ordnocast));
		orderinfo.setOrderTime(now);
		int PriceSumHandle = (int) (goods.getPrice() * orderDetail.getGoodsCount() * 100);
		long PriceSumHandle2 = (long) (goods.getPrice() * orderDetail.getGoodsCount() * 100);
		orderinfo.setTotalPrice(PriceSumHandle);
		// orderinfo.setTotalScore(totalScore);
		orderinfo.setGoodsTypeCount(1);
		orderinfo.setGoodsCount(orderDetail.getGoodsCount());
		orderinfo.setReceiverName(receiveName);
		orderinfo.setReceiverAddress(receiverAddress);
		orderinfo.setReceiverMobile(receiverMobile);
		orderinfo.setUser_remarks(mark);
		orderinfo.setUserName(user.getUserName());
		orderinfo.setPayType(CommonDefine.PAY_TYPE_YUNKUNCUN);
		orderinfo.setIsSplit("0");
		orderinfo.setStatus(33);
		orderinfo.setGmtCreate(now);
		orderinfo.setGmtModify(now);

		Long newOrdid = this.orderService.add(orderinfo);

		Integer suborderseqno = this.sequenceService.genValidSeqno("suborderinfo");
		String suborderno = ordno + String.format("%06d", new Object[] { suborderseqno });

		System.out.println(suborderno);
		SubOrder suborder = new SubOrder();

		suborder.setId(Long.parseLong(suborderno));

		System.out.println(suborder.getId());
		suborder.setOrderId(Long.parseLong(ordnocast));

		suborder.setMemberId(goods.getMemberId());

		// suborder.setMemberName(memberName);
		suborder.setSubtotalPrice(PriceSumHandle2);
		// suborder.setSubtotalScore(subtotalScore);
		suborder.setGoodsTypeCount(1);
		suborder.setGoodsCount(orderDetail.getGoodsCount());
		suborder.setStatus(33);
		suborder.setGmtCreate(now);
		suborder.setGmtModify(now);

		Long subOrderId = subOrderService.add(suborder);

		OrderDetail orderdetail = new OrderDetail();

		orderdetail.setOrderId(Long.parseLong(ordnocast));
		orderdetail.setSubOrderId(Long.parseLong(suborderno));
		orderdetail.setGoodsId(goods.getId());
		orderdetail.setGoodsName(goods.getName());
		orderdetail.setMiniature(goods.getMiniature());
		orderdetail.setMemberId(goods.getMemberId());
		// orderdetail.setMemberName(memberName);
		int unitPriceHandle = (int) (goods.getPrice() * 100);
		orderdetail.setUnitPrice(unitPriceHandle);
		// orderdetail.setUnitScore(unitScore);
		orderdetail.setGoodsCount(orderDetail.getGoodsCount());
		orderdetail.setSinglePrice(unitPriceHandle * orderDetail.getGoodsCount());
		// orderdetail.setTotalScore(totalScore);
		orderdetail.setGmtCreate(now);
		orderdetail.setGmtModify(now);

		orderDetailService.add(orderdetail);

		// 更新库存量

		stockService.updateStock(orderdetail);

		return "redirect:" + "/goods/stock/list.htm";
	}

	private Long addNewOrder(List<TradeCartRecord> goodsList, Orderinfo orderinfoModel, String enumStatus) {
		// Long ordid = orderinfoService.addOrderinfo(orderinfoModel); // 添加新订单

		Order order = new Order();
		order.setId(Long.parseLong(orderinfoModel.getOrderno()));
		order.setGoodsCount(orderinfoModel.getItemcount());
		order.setPayType(orderinfoModel.getPaymenttype_id().toString());
		order.setReceiverAddress(orderinfoModel.getReceiveraddr());
		order.setReceiverMobile(orderinfoModel.getReceivermobile());
		order.setReceiverName(orderinfoModel.getReceivername());
		int totalPriceHandle = (int) (orderinfoModel.getTotalsum() * 100);

		order.setTotalPrice(totalPriceHandle);
		order.setTotalScore(orderinfoModel.getScore());
		order.setUserName(orderinfoModel.getUsername());
		order.setIsSplit("0");
		order.setStatus(CommonDefine.ORDERINFO_STATUS_NEW);
		System.out.println("order订单增加");
		Long orderId = orderService.add(order);
		// orderinfoModel.setId(ordid);
		Map<Long, SubOrder> subOrderMap = new HashMap<Long, SubOrder>();
		// 生成子订单
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

			System.out.println("订单号" + orderId);
			System.out.println("member号" + memberId);
			int singlePriceHandle = (int) (goods.getPrice() * record.getGoodsNum().intValue() * 100);// 处理成整数，单位分
			detail.setSinglePrice(singlePriceHandle);

			if (null == goods.getScore()) {
				detail.setSingleScore(0);
			} else {
				detail.setSingleScore((int) (goods.getScore() * record.getGoodsNum()));
			}

			detail.setUnitPrice((int) (goods.getPrice() * 100));
			if (null == goods.getScore()) {
				detail.setUnitScore(0);
			} else {
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

			// orderitemService.addOrderitem(item);
			// 更新商品订购量
			goodsService.increaseSpecificNumById(item.getGoods_id(), "ordernum", item.getItemnum());
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

}
