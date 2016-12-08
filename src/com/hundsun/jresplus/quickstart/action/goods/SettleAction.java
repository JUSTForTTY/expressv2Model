package com.hundsun.jresplus.quickstart.action.goods;

import com.alipaywap.config.AlipayConfig;
import com.hundsun.jresplus.common.util.StringUtil;
import com.hundsun.jresplus.quickstart.biz.bo.TradeCart;
import com.hundsun.jresplus.quickstart.biz.bo.TradeCartRecord;
import com.hundsun.jresplus.quickstart.biz.po.Goods;
import com.hundsun.jresplus.quickstart.biz.po.Order;
import com.hundsun.jresplus.quickstart.biz.po.OrderDetail;
import com.hundsun.jresplus.quickstart.biz.po.Orderinfo;
import com.hundsun.jresplus.quickstart.biz.po.Orderitem;
import com.hundsun.jresplus.quickstart.biz.po.PayInfo;
import com.hundsun.jresplus.quickstart.biz.po.Payment;
import com.hundsun.jresplus.quickstart.biz.po.PrepayLog;
import com.hundsun.jresplus.quickstart.biz.po.Response;
import com.hundsun.jresplus.quickstart.biz.po.Settlement;
import com.hundsun.jresplus.quickstart.biz.po.SettlementDetail;
import com.hundsun.jresplus.quickstart.biz.po.Stock_Detail_Log;
import com.hundsun.jresplus.quickstart.biz.po.Stock_Log;
import com.hundsun.jresplus.quickstart.biz.po.SubOrder;
import com.hundsun.jresplus.quickstart.biz.po.User;
import com.hundsun.jresplus.quickstart.biz.service.CommonService;
import com.hundsun.jresplus.quickstart.biz.service.GoodsService;
import com.hundsun.jresplus.quickstart.biz.service.OrderDetailService;
import com.hundsun.jresplus.quickstart.biz.service.OrderService;
import com.hundsun.jresplus.quickstart.biz.service.OrderinfoService;
import com.hundsun.jresplus.quickstart.biz.service.OrderitemService;
import com.hundsun.jresplus.quickstart.biz.service.OutPayService;
import com.hundsun.jresplus.quickstart.biz.service.PrepayLogService;
import com.hundsun.jresplus.quickstart.biz.service.SequenceService;
import com.hundsun.jresplus.quickstart.biz.service.StockDetailLogService;
import com.hundsun.jresplus.quickstart.biz.service.StockLogService;
import com.hundsun.jresplus.quickstart.biz.service.SubOrderService;
import com.hundsun.jresplus.quickstart.biz.service.UserService;
import com.hundsun.jresplus.quickstart.common.CommonDefine;
import com.hundsun.jresplus.quickstart.common.UserAgent;
import com.hundsun.jresplus.quickstart.enums.EnumOrderItemStatus;
import com.hundsun.jresplus.quickstart.enums.EnumPayType;
import com.hundsun.jresplus.quickstart.enums.ErrorCode;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/settle"})
public class SettleAction
{

  @Autowired
  private GoodsService goodsService;

  @Autowired
  private OrderitemService orderitemService;

  @Autowired
  private OrderinfoService orderinfoService;

  @Autowired
  private PrepayLogService prepayLogService;

  @Autowired
  private SequenceService sequenceService;

  @Autowired
  private UserService userService;

  @Autowired
  private CommonService commonService;

  @Autowired
  private OutPayService outPayService;
  
  @Autowired
  private OrderDetailService orderDetailService;
  
  @Autowired
  private SubOrderService subOrderService;
  @Autowired
  private StockLogService stockLogService;
  @Autowired
  private StockDetailLogService stockDetailLogService;
   
  
  @Autowired
  private OrderService orderService;
  private final Log logger = LogFactory.getLog(getClass());

  @RequestMapping({"/add2Cart"})
  @ResponseBody
  public String add2Cart(UserAgent user, HttpSession session, HttpServletRequest request) { long id = Long.parseLong(request.getParameter("id"));
    int num = Integer.parseInt(request.getParameter("goodsNum"));

    Response ret = new Response();
    if ((id <= 0L) || (num <= 0)) {
      ret.setErrCode(ErrorCode.PARAM_ERROR.getCode());
      ret.setBody("商品不存在或商品数量非法");
    } else {
      if (user == null) {
        user = new UserAgent();
      }

      user.getTradeCart().add2Cart(Long.valueOf(id), Integer.valueOf(num));
      session.setAttribute("userAgent", user);
      ret.setErrCode(ErrorCode.SUCCESS.getCode());
      ret.setBody("添加购物车成功！");
    }

    return this.commonService.toJson(ret);
  }

  @RequestMapping({"/addOne2Cart"})
  public String addOne2Cart(UserAgent user, HttpSession session, HttpServletRequest request, ModelMap model)
  {
    long id = Long.parseLong(request.getParameter("id"));
    if (id <= 0L) {
      model.addAttribute("message", "商品不存在");
      return "error";
    }
    if (user == null) {
      user = new UserAgent();
      session.setAttribute("userAgent", user);
    }
    user.getTradeCart().add2Cart(Long.valueOf(id), Integer.valueOf(1));
    session.setAttribute("userAgent", user);
    return "redirect:/settle/order1Cart.htm";
  }

  @RequestMapping({"/deleteOneFromCart"})
  public String deleteOneFromCart(UserAgent user, HttpSession session, HttpServletRequest request, ModelMap model)
  {
    long id = Long.parseLong(request.getParameter("id"));
    if (id <= 0L) {
      model.addAttribute("message", "商品不存在");
      return "error";
    }

    user.getTradeCart().deleteByGoodsId(Long.valueOf(id), Integer.valueOf(1));
    session.setAttribute("userAgent", user);
    return "redirect:/settle/order1Cart.htm";
  }

  @RequestMapping({"/deleteFromCart"})
  public String deleteFromCart(UserAgent user, HttpSession session, HttpServletRequest request)
  {
    long id = Long.parseLong(request.getParameter("id"));

    Response ret = new Response();
    if (id <= 0L) {
      ret.setErrCode(ErrorCode.PARAM_ERROR.getCode());
      ret.setBody("商品不存在");
    } else {
      user.getTradeCart().deleteByGoodsId(Long.valueOf(id));
      session.setAttribute("userAgent", user);
      return "redirect:/settle/order1Cart.htm";
    }

    return this.commonService.toJson(ret);
  }

  @RequestMapping({"/changeNumFromCart"})
  public String changeNumFromCart(UserAgent user, HttpSession session, HttpServletRequest request) {
    long id = Long.parseLong(request.getParameter("id"));
    int num = Integer.parseInt(request.getParameter("goodsNum"));
    Response ret = new Response();
    if (id <= 0L) {
      ret.setErrCode(ErrorCode.PARAM_ERROR.getCode());
      ret.setBody("商品不存在");
    } else {
      user.getTradeCart().deleteByGoodsId(Long.valueOf(id));
      user.getTradeCart().add2Cart(Long.valueOf(id), Integer.valueOf(num));
      session.setAttribute("userAgent", user);
      return "redirect:/settle/order1Cart.htm";
    }

    return "error";
  }

  @RequestMapping({"/clearCart"})
  public String clearCart(UserAgent user, HttpSession session) {
    user.getTradeCart().clearCart();
    session.setAttribute("userAgent", user);
    return "redirect:/settle/order1Cart.htm";
  }

  private Settlement cart2Settlement(TradeCart cart, boolean isLogin) {
    Settlement settlement = new Settlement();
    Double priceTotal = Double.valueOf(0.0D);
    Integer scoreTotal = Integer.valueOf(0);
    Iterator titer = cart.getCartDetail().entrySet().iterator();
    List detailList = new ArrayList();
    while (titer.hasNext()) {
      Map.Entry ent = (Map.Entry)titer.next();
      Long goodsId = (Long)ent.getKey();
      Integer goodsNum = (Integer)ent.getValue();
      Goods goods = this.goodsService.getById(goodsId);
      if (Goods.isInSupply(goods, goodsNum.intValue())) {
        SettlementDetail detail = new SettlementDetail();
        detail.setGoodsId(goodsId);
        detail.setGoodsName(goods.getName());
        detail.setGoodsNum(goodsNum);
        detail.setImage(goods.getMiniature());
        Double price = Double.valueOf(0.0D);
        if (isLogin)
          price = goods.getPrice();
        else {
          price = goods.getRefprice();
        }
        detail.setPrice(price);
        if ((price == null) || (price.doubleValue() < 0.0D)) {
          price = Double.valueOf(0.0D);
        }
        Double priceSum = 
          Double.valueOf(new BigDecimal(price.toString()).multiply(
          new BigDecimal(goodsNum.toString())).doubleValue());
        detail.setPriceSum(priceSum);
        detailList.add(detail);

        if (goods.isScoreGoods())
          scoreTotal = Integer.valueOf(scoreTotal.intValue() + priceSum.intValue());
        else {
          priceTotal = 
            Double.valueOf(new BigDecimal(priceTotal.toString()).add(
            new BigDecimal(priceSum.toString())).doubleValue());
        }
      }
    }
    settlement.setDetailList(detailList);
    settlement.setGoodskinds(cart.getGoodskinds());
    settlement.setItemcount(cart.getItemcount());
    settlement.setPriceSum(priceTotal);
    settlement.setScoreSum(scoreTotal);
    return settlement;
  }

  @RequestMapping({"/order1Cart"})
  public String cartList(UserAgent user, ModelMap model) {
	  if(null==user||"".equals(user)){
		  return "/settle/order1CartError";
	  } 
    TradeCart cart = user.getTradeCart();
    model.addAttribute("settlement", 
      cart2Settlement(cart, StringUtil.isNotBlank(user.getUserName())));
    return "/settle/order1Cart";
  }

  @RequestMapping({"/order2Pay"})
  public String generateOrder(UserAgent userAgent, HttpSession session, ModelMap model)
  {
    TradeCart cart = userAgent.getTradeCart();
    List records = new ArrayList();
    Iterator titer = cart.getCartDetail().entrySet().iterator();
    Payment paymentInfo = new Payment();
    while (titer.hasNext()) {
      Map.Entry ent = (Map.Entry)titer.next();
      Long goodsId = (Long)ent.getKey();
      Integer goodsNum = (Integer)ent.getValue();
      Goods goods = this.goodsService.getById(goodsId);
      if (Goods.isInSupply(goods, goodsNum.intValue()))
      {
        if (StringUtil.isBlank(userAgent.getUserName()))
          paymentInfo.calculateNoLogin(goods, goodsNum.intValue());
        else {
          paymentInfo.calculate(goods, goodsNum.intValue());
        }

        TradeCartRecord record = new TradeCartRecord(goods, goodsNum);

        records.add(record);
      }
    }

    model.addAttribute("paymentInfo", paymentInfo);
    model.addAttribute("records", records);

    User userInfo = this.userService.getByUserName(userAgent.getUserName());
    model.addAttribute("user", userInfo);
    return "/settle/order2Pay";
  }

  @RequestMapping({"/order3Finish"})
  public String generateOrder(UserAgent user, HttpSession session, ModelMap model, HttpServletRequest request)
  {
    String receiveName = request.getParameter("receiveName");
    String receivephoneNum = request.getParameter("phoneNum");
    String email = request.getParameter("email");
    String receiveAddr = request.getParameter("receiveAddr");

    String mark = request.getParameter("userMark");

    int payType = Integer.parseInt(request.getParameter("payType"));

    if ((receiveName == null) || (receivephoneNum == null) || (receiveAddr == null)) {
      return "error";
    }

    List goodsList = new ArrayList();
    TradeCart cart = user.getTradeCart();
    Iterator titer = cart.getCartDetail().entrySet().iterator();
    Payment paymentInfo = new Payment();
    while (titer.hasNext()) {
      Map.Entry ent = (Map.Entry)titer.next();
      Long goodsId = (Long)ent.getKey();
      Integer goodsNum = (Integer)ent.getValue();
      Goods goods = this.goodsService.getById(goodsId);
      if (Goods.isInSupply(goods, goodsNum.intValue()))
      {
        if (StringUtil.isBlank(user.getUserName()))
          paymentInfo.calculateNoLogin(goods, goodsNum.intValue());
        else {
          paymentInfo.calculate(goods, goodsNum.intValue());
        }
        goodsList.add(new TradeCartRecord(goods, goodsNum));
      }

    }

    Long id = user.getId();
    User userModel = this.userService.getById(id);
    if (userModel == null) {
      userModel = new User();
      userModel.setscore(Long.valueOf(0L));
      userModel.setPrepay(0.0D);
    }

    if (userModel.getscore().longValue() < paymentInfo.getScore()) {
      return "error";
    }

    Orderinfo orderinfoModel = new Orderinfo();
    Date now = new Date();
    orderinfoModel.setOrdertime(now);
    Format format = new SimpleDateFormat("yyyyMMdd");
    String ordno = format.format(now);
    Integer seqno = this.sequenceService.genValidSeqno("orderinfo");
    ordno = ordno + String.format("%06d", new Object[] { seqno });
    orderinfoModel.setOrderno(ordno);
    orderinfoModel.setItemcount(Integer.valueOf(goodsList.size()));
    orderinfoModel.setGoodssum(paymentInfo.getCash());
    orderinfoModel.setServicesum(Double.valueOf(0.0D));
    orderinfoModel.setOthersum(Double.valueOf(0.0D));
    orderinfoModel.setTotalsum(paymentInfo.getCash());
    orderinfoModel.setScore(Integer.valueOf(paymentInfo.getScore()));
    orderinfoModel.setReceivername(receiveName);
    orderinfoModel.setReceivermobile(receivephoneNum);
    orderinfoModel.setReceiveremail(email);
    orderinfoModel.setReceiveraddr(receiveAddr);
    orderinfoModel.setUser_id(user.getId());
    orderinfoModel.setUsername(userModel.getUsername());
    orderinfoModel.setUserremark(mark);
    orderinfoModel.setStatus(Integer.valueOf(11));
    orderinfoModel.setRequireinvoice(Integer.valueOf(0));
    orderinfoModel.setPaymenttype_id(Integer.valueOf(payType));

    if (EnumPayType.PAY_TYPE_PREPAY.getCode().equals(
      orderinfoModel.getPaymenttype_id().toString()))
    {
      if (userModel.getPrepay() < paymentInfo.getCash().doubleValue()) {
        model.addAttribute("message", "预存款不足");
        return "error";
      }
      Long ordid = addNewOrder(goodsList, orderinfoModel, EnumOrderItemStatus.PAID.getCode());

      Long newPrepay = 
        Long.valueOf(new BigDecimal(Double.valueOf(
        userModel.getPrepay() - paymentInfo.getCash().doubleValue()).toString()).movePointRight(2)
        .longValue());
      Long newScore = Long.valueOf(userModel.getscore().longValue() - paymentInfo.getScore());
      user.setScore(newScore);
      user.setPrepay(newPrepay);
      session.setAttribute("userAgent", user);

      PrepayLog prepaylog = new PrepayLog();
      prepaylog.setUser_id(orderinfoModel.getUser_id());
      prepaylog.setPaysum(orderinfoModel.getTotalsum());
      prepaylog.setPaytype("payment");
      prepaylog.setCreator(orderinfoModel.getUser_id());
      prepaylog.setCreatetime(now);
      prepaylog.setPaytime(now);
      prepaylog.setOrderinfo_id(ordid);
      this.prepayLogService.addPrepayLog(prepaylog);

      this.userService.updatePrepayById(user.getId(), -paymentInfo.getCash().doubleValue());

      orderService.updateOrderInfo(ordid);
      subOrderService.updateSubOrderInfo(ordid);
      
      //this.orderinfoService.updateOrderinfoStatus(orderinfoModel.getId(), 32);

      //this.orderitemService.updateStatusByOrderInfoId(ordid.longValue(), "32");

      user.getTradeCart().clearCart();
      session.setAttribute("userAgent", user);
      return "/settle/order3Finish";
    }if (EnumPayType.PAY_TYPE_AFTERPAY.getCode().equals(
      orderinfoModel.getPaymenttype_id().toString())) {
      Long ordid = addNewOrder(goodsList, orderinfoModel, EnumOrderItemStatus.INIT.getCode());

      orderinfoModel.setStatus(Integer.valueOf(32));
      
      orderService.updateAfterOrderInfo(ordid);
      subOrderService.updateAfterSubOrderInfo(ordid);
      
      //this.orderinfoService.updateOrderinfoStatus(orderinfoModel.getId(), 32);

      user.getTradeCart().clearCart();
      session.setAttribute("userAgent", user);
      return "/settle/order3Finish";
      
      
    }
    
//    if("8".equals(
//    		orderinfoModel.getPaymenttype_id().toString())) {
//    	Stock_Log log  = new Stock_Log();
//		log.setImportBillID(ordno);
//		log.setUser_name(user.getUserName());
//		log.setGoodkinds(goodsList.size());
//		log.setCreate_user(user.getUserName());
//		log.setCreate_time(now);
//		log.setUpdate_user(user.getUserName());
//		log.setUpdate_time(now);
//		log.setStatus(CommonDefine.ORDERINFO_STATUS_NEW);
//     
//     	 String importBillID=addStockLog(goodsList,orderinfoModel ,log,EnumOrderItemStatus.INIT.getCode());
//    		 
//     	 
//     	   PayInfo data = new PayInfo();
//           data.setAmount(Integer.valueOf((int)(paymentInfo.getCash().doubleValue() * 100.0D)));
//           data.setDesc("上海云河信息商品");
//           data.setUserId(user.getId());
//           data.setRequestId(Long.parseLong(importBillID));
//           data.setPayType(orderinfoModel.getPaymenttype_id());
//           data.setNotify_url("http://trade.wuyeok.com/settle/callback/alipayStockNotify.htm");
//           data.setReturn_url("http://trade.wuyeok.com/settle/callback/alipayStockNotify.htm");
//           model.addAttribute("content", this.outPayService.recharge(data));
//           user.getTradeCart().clearCart();
//           System.out.println("新版支付宝支付");
//           session.setAttribute("userAgent", user);
//           return "/settle/empty";
//         }
//        
//   				 
    				 
    
    if (EnumPayType.PAY_TYPE_ALIPAY.getCode().equals(
    		 
      orderinfoModel.getPaymenttype_id().toString())) {
      Long ordid = addNewOrder(goodsList, orderinfoModel, EnumOrderItemStatus.INIT.getCode());
      PayInfo data = new PayInfo();
      data.setAmount(Integer.valueOf((int)(paymentInfo.getCash().doubleValue() * 100.0D)));
      data.setDesc("上海云河信息商品");
      data.setUserId(user.getId());
      data.setRequestId(ordid);
      data.setPayType(orderinfoModel.getPaymenttype_id());
      data.setNotify_url(CommonDefine.ALIPAY_NOTIFY_URL);
      data.setReturn_url(CommonDefine.ALIPAY_RETURN_URL);
      model.addAttribute("content", this.outPayService.recharge(data));
      user.getTradeCart().clearCart();
      System.out.println("新版支付宝支付");
      session.setAttribute("userAgent", user);
      return "/settle/empty";
    }
    return "error";
  }

  private Long addOrder(List<TradeCartRecord> goodsList, Orderinfo orderinfoModel, String enumStatus)
  {
	 
    Long ordid = this.orderinfoService.addOrderinfo(orderinfoModel);
    orderinfoModel.setId(ordid);

    for (TradeCartRecord record : goodsList) {
      Orderitem item = new Orderitem();
      Goods goods = record.getGoods();
      double unitPrice = goods.getPrice() == null ? 0.0D : goods.getPrice().doubleValue();
      item.setUnitprice(Double.valueOf(unitPrice));
      item.setItemnum(record.getGoodsNum());
      item.setGoods_id(goods.getId());
      item.setGoods_name(goods.getName());
      item.setPrivatecode(goods.getPrivatecode());
      item.setUnit(goods.getUnit());
      item.setUser_id(orderinfoModel.getUser_id());
      item.setOrderinfo_id(ordid);
      item.setItemno(Integer.valueOf(1));
      item.setItemsum(Double.valueOf(unitPrice * record.getGoodsNum().intValue()));
      item.setStatus(enumStatus);
      item.setGoods_state(String.valueOf(11));

      this.orderitemService.addOrderitem(item);

      this.goodsService.increaseSpecificNumById(item.getGoods_id(), "ordernum", item.getItemnum());
    }
    return ordid;
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
if(null==orderinfoModel.getUsername()||"".equals(orderinfoModel.getUsername())){
	//用户为空，则使用市场价
	
	singlePriceHandle=(int) (goods.getRefprice() * record.getGoodsNum().intValue()*100);
}


detail.setSinglePrice(singlePriceHandle);

if(null==goods.getScore()){
	detail.setSingleScore(0);
}else{
	detail.setSingleScore((int)(goods.getScore() * record.getGoodsNum()));
}
 
if(null==orderinfoModel.getUsername()||"".equals(orderinfoModel.getUsername())){
	//用户为空，则使用市场价
	detail.setUnitPrice((int)(goods.getRefprice()*100));
	 
}
else{
	detail.setUnitPrice((int)(goods.getPrice()*100));
}


 




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
  
//大订单日志
	private String addStockLog(List<TradeCartRecord> goodsList, Orderinfo orderinfoModel,Stock_Log log,String enumStatus) {
	//	Long ordid = orderinfoService.addOrderinfo(orderinfoModel); // 添加新订单

		String importBillID=stockLogService.addStockLog(log);//添加大日志
		//log.setImportBillID(importBillID);//进货单号
	    //	orderinfoModel.setId(ordid);
 
		for (TradeCartRecord record : goodsList) {
		 	Goods goods = record.getGoods();
		 	Stock_Detail_Log sdl=new Stock_Detail_Log();	
			sdl.setId(sdl.getId());
			sdl.setImportBillID(log.getImportBillID());
			sdl.setGoods_id(goods.getId().intValue());
			sdl.setGoods_name(goods.getName());
			sdl.setUser_name(log.getUser_name());
			sdl.setMiniature(goods.getMiniature());
			int importPricehandle=(int) (goods.getPrice()*100);
			sdl.setImportPrice(importPricehandle);
			sdl.setQuantity(record.getGoodsNum());
			sdl.setSinglePrice(record.getGoodsNum()*importPricehandle);
			sdl.setCreate_user(log.getCreate_user());
			sdl.setCreate_time(log.getCreate_time());
			sdl.setUpdate_user(log.getUpdate_user());
			sdl.setUpdate_time(log.getUpdate_time());
			stockDetailLogService.addDetaillog(sdl);
			 
		 
			goodsService.increaseSpecificNumById(goods.getId(), "ordernum", record.getGoodsNum());
		}
		return importBillID;
	}

  @RequestMapping({"/alipayWap"})
  @ResponseBody
  public String alipayGatewayPay(HttpServletRequest request) {
    String orderId = request.getParameter("orderId");
    String returnUrl = request.getParameter("returnUrl");
    String notifyUrl = request.getParameter("notifyUrl");
    if (orderId == null) {
      return "";
    }
    long requestId = Long.parseLong(orderId);
    Orderinfo orderInfo = this.orderinfoService.getOrderinfoById(Long.valueOf(requestId));
    if (orderInfo == null) {
      return "";
    }
    PayInfo data = new PayInfo();
    data.setAmount(Integer.valueOf((int)(orderInfo.getTotalsum().doubleValue() * 100.0D)));
    data.setUserId(orderInfo.getUser_id());
    data.setRequestId(Long.valueOf(requestId));
    data.setDesc("上海云河信息商品");
    data.setPayType(Integer.valueOf(16));
    if (returnUrl == null)
      data.setReturn_url("http://trade.wuyeok.com/settle/callback/alipayWapReturn.htm");
    else {
      data.setReturn_url(returnUrl);
    }

    if (notifyUrl == null)
      data.setNotify_url("http://trade.wuyeok.com/settle/callback/alipayWapNotify.htm");
    else {
      data.setNotify_url(notifyUrl);
    }
    return this.outPayService.recharge(data);
  }

  @RequestMapping({"/callback/alipayNotify"})
  @ResponseBody
  public String alipayNotify(HttpServletRequest request, ModelMap model)
    throws UnsupportedEncodingException
  {
	  System.out.println("支付宝回调开始");
	  
    Map params = new HashMap();
    Map requestParams = request.getParameterMap();
    this.logger.debug(requestParams);
    for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
      String name = (String)iter.next();
      String[] values = (String[])requestParams.get(name);
      String valueStr = "";
      for (int i = 0; i < values.length; i++) {
    	  valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i]
                  + ",";
      }

      params.put(name, valueStr);
    }
    this.logger.info(params);

    String out_trade_no = new String(request.getParameter("out_trade_no")
      .getBytes("ISO-8859-1"), "UTF-8");

    String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), 
      "UTF-8");
   
    String trade_status = new String(request.getParameter("trade_status")
      .getBytes("ISO-8859-1"), "UTF-8");
    System.out.println("支付宝回调开始trade_status-"+trade_status);

    if (com.alipay.util.AlipayNotify.verify(params))
    {
      if ((trade_status.equals("TRADE_FINISHED")) || (trade_status.equals("TRADE_SUCCESS"))) {
    	  
    	  System.out.println("支付宝回调开始-更新订单");
        //this.outPayService.notify(Integer.parseInt(out_trade_no), trade_status, trade_no);
        
        //更新订单状态
          orderService.updateOrderInfo(Long.parseLong(out_trade_no));
          subOrderService.updateSubOrderInfo(Long.parseLong(out_trade_no));
        
      }

      return "success";
    }

    return "fail";
  }

  
//  @RequestMapping({"/callback/alipayStockNotify"})
//  @ResponseBody
//  public String alipayStockNotify(HttpServletRequest request, ModelMap model)
//    throws UnsupportedEncodingException
//  {
//	  System.out.println("进货支付宝回调开始");
//	  
//    Map params = new HashMap();
//    Map requestParams = request.getParameterMap();
//    this.logger.debug(requestParams);
//    for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
//      String name = (String)iter.next();
//      String[] values = (String[])requestParams.get(name);
//      String valueStr = "";
//      for (int i = 0; i < values.length; i++) {
//    	  valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i]
//                  + ",";
//      }
//
//      params.put(name, valueStr);
//    }
//    this.logger.info(params);
//
//    String out_trade_no = new String(request.getParameter("out_trade_no")
//      .getBytes("ISO-8859-1"), "UTF-8");
//
//    String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), 
//      "UTF-8");
//   
//    String trade_status = new String(request.getParameter("trade_status")
//      .getBytes("ISO-8859-1"), "UTF-8");
//    System.out.println("支付宝回调开始trade_status-"+trade_status);
//
//    if (com.alipay.util.AlipayNotify.verify(params))
//    {
//      if ((trade_status.equals("TRADE_FINISHED")) || (trade_status.equals("TRADE_SUCCESS"))) {
//    	  
//    	  System.out.println("支付宝回调开始-更新订单");
//        //this.outPayService.notify(Integer.parseInt(out_trade_no), trade_status, trade_no);
//        
//        //更新订单状态
//          orderService.updateOrderInfo(Long.parseLong(out_trade_no));
//          subOrderService.updateSubOrderInfo(Long.parseLong(out_trade_no));
//        
//      }
//
//      return "success";
//    }
//
//    return "fail";
//  }
//  
  
  @RequestMapping({"/callback/alipayReturn"})
  public String alipayReturn(HttpServletRequest request, ModelMap model)
    throws UnsupportedEncodingException
  {
    Map params = new HashMap();
    request.setCharacterEncoding("utf-8");
    Map requestParams = request.getParameterMap();
    for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
      String name = (String)iter.next();
      String[] values = (String[])requestParams.get(name);
      String valueStr = "";
      for (int i = 0; i < values.length; i++) {
        valueStr = valueStr + values[i] + 
          ",";
      }

      valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
      params.put(name, valueStr);
    }
    this.logger.info(params);

    String out_trade_no = new String(request.getParameter("out_trade_no")
      .getBytes("ISO-8859-1"), "UTF-8");

    String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), 
      "UTF-8");

    String trade_status = new String(request.getParameter("trade_status")
      .getBytes("ISO-8859-1"), "UTF-8");

    boolean verify_result = com.alipay.util.AlipayNotify.verify(params);

    if (verify_result)
    {
      if ((trade_status.equals("TRADE_FINISHED")) || (trade_status.equals("TRADE_SUCCESS")))
      {
        this.outPayService.notify(Integer.parseInt(out_trade_no), trade_status, trade_no);
      }

      return "/settle/order3Finish";
    }

    return "/settle/order3Finish";
  }

  @RequestMapping({"/callback/alipayWapReturn"})
  public String alipayWapReturn(HttpServletRequest request, ModelMap model)
    throws UnsupportedEncodingException
  {
    Map params = new HashMap();
    Map requestParams = request.getParameterMap();
    for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
      String name = (String)iter.next();
      String[] values = (String[])requestParams.get(name);
      String valueStr = "";
      for (int i = 0; i < values.length; i++) {
        valueStr = valueStr + values[i] + 
          ",";
      }

      valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
      params.put(name, valueStr);
    }

    String out_trade_no = new String(request.getParameter("out_trade_no")
      .getBytes("ISO-8859-1"), "UTF-8");

    String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), 
      "UTF-8");

    String result = new String(request.getParameter("result").getBytes("ISO-8859-1"), "UTF-8");

    boolean verify_result = com.alipaywap.util.AlipayNotify.verifyReturn(params);

    if (verify_result)
    {
      if (result.equals("success"))
      {
        this.outPayService.notify(Integer.parseInt(out_trade_no), result, trade_no);
      }

      return "/settle/order3Finish";
    }

    return "/settle/order3Finish";
  }

  @RequestMapping({"/callback/alipayWapNotify"})
  @ResponseBody
  public String alipayWapNotify(HttpServletRequest request, ModelMap model) {
    Map params = new HashMap();
    Map requestParams = request.getParameterMap();
    for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
      String name = (String)iter.next();
      String[] values = (String[])requestParams.get(name);
      String valueStr = "";
      for (int i = 0; i < values.length; i++) {
        valueStr = valueStr + values[i] + 
          ",";
      }

      params.put(name, valueStr);
    }

    if (AlipayConfig.sign_type.equals("0001")) {
      try {
        params = com.alipaywap.util.AlipayNotify.decrypt(params);
      }
      catch (Exception e) {
        e.printStackTrace();
      }

    }

    String trade_no = "";
    String out_trade_no = "";
    String trade_status = "fail";
    try {
      Document doc_notify_data = DocumentHelper.parseText((String)params.get("notify_data"));

      out_trade_no = doc_notify_data.selectSingleNode("//notify/out_trade_no").getText();

      trade_no = doc_notify_data.selectSingleNode("//notify/trade_no").getText();

      trade_status = doc_notify_data.selectSingleNode("//notify/trade_status").getText();
    }
    catch (Exception e) {
      e.printStackTrace();
    }

    try
    {
      if (com.alipaywap.util.AlipayNotify.verifyNotify(params))
      {
        if ((trade_status.equals("TRADE_FINISHED")) || (trade_status.equals("TRADE_SUCCESS")))
        {
          this.outPayService.notify(Integer.parseInt(out_trade_no), trade_status, trade_no);

          return "success";
        }

      }
      else
      {
        return "fail";
      }
    }
    catch (Exception e) {
      return "fail";
    }
    return "fail";
  }
  @RequestMapping({"/orderReceive"})
  @ResponseBody
  public String orderReceive(UserAgent user, HttpSession session, HttpServletRequest request) {
    Response ret = new Response();
    long orderItemId = 0L;
    try {
      orderItemId = Long.parseLong(request.getParameter("orderitemId"));
    } catch (Exception e) {
      ret.setErrCode(ErrorCode.PARAM_ERROR.getCode());
      ret.setBody("订单号有误！");
      return this.commonService.toJson(ret);
    }

    if (user == null) {
      ret.setErrCode(ErrorCode.PARAM_ERROR.getCode());
      ret.setBody("用户未登录！");
      return this.commonService.toJson(ret);
    }

    Orderitem orderitem = this.orderitemService.getOrderitemById(Long.valueOf(orderItemId));
    if (!orderitem.getUser_id().equals(user.getId())) {
      ret.setErrCode(ErrorCode.PARAM_ERROR.getCode());
      ret.setBody("您不能操作别人的订单！");
      return this.commonService.toJson(ret);
    }

    this.orderitemService.updateStatusById(orderItemId, 
      String.valueOf(34));
    ret.setErrCode(ErrorCode.SUCCESS.getCode());

    ret.setBody("您已经确认收货，记得评价哦！");

    return this.commonService.toJson(ret);
  }
  @RequestMapping({"/orderCanRate"})
  @ResponseBody
  public String orderCanRate(UserAgent user, HttpSession session, HttpServletRequest request) {
    Response ret = new Response();
    long orderItemId = 0L;
    try {
      orderItemId = Long.parseLong(request.getParameter("orderitemId"));
    } catch (Exception e) {
      ret.setErrCode(ErrorCode.PARAM_ERROR.getCode());
      ret.setBody("订单号有误！");
      return this.commonService.toJson(ret);
    }

    if (user == null) {
      ret.setErrCode(ErrorCode.PARAM_ERROR.getCode());
      ret.setBody("用户未登录！");
      return this.commonService.toJson(ret);
    }

    Orderitem orderitem = this.orderitemService.getOrderitemById(Long.valueOf(orderItemId));
    if (!orderitem.getUser_id().equals(user.getId())) {
      ret.setErrCode(ErrorCode.PARAM_ERROR.getCode());
      ret.setBody("您不能操作别人的订单！");
      return this.commonService.toJson(ret);
    }

    if (!orderitem.getGoods_state().equals(
      String.valueOf(34))) {
      ret.setErrCode(ErrorCode.PARAM_ERROR.getCode());
      ret.setBody("你还未确认收货，不能评价");
      return this.commonService.toJson(ret);
    }

    this.orderitemService.updateStatusByOrderInfoId(orderItemId, 
      String.valueOf(34));
    ret.setErrCode(ErrorCode.SUCCESS.getCode());

    ret.setBody("您可以评价");

    return this.commonService.toJson(ret);
  }
  @RequestMapping({"/buyquick"})
  @ResponseBody
  public String buyquick(UserAgent user, HttpSession session, HttpServletRequest request) {
    long id = Long.parseLong(request.getParameter("id"));
    int num = Integer.parseInt(request.getParameter("goodsNum"));
    Response ret = new Response();
    if ((id <= 0L) || (num <= 0)) {
      ret.setErrCode(ErrorCode.PARAM_ERROR.getCode());
      ret.setBody("商品不存在或商品数量非法");
    } else {
      if (user == null) {
        user = new UserAgent();
      }
      else {
        user.getTradeCart().clearCart();
      }

      user.getTradeCart().add2Cart(Long.valueOf(id), Integer.valueOf(num));
      session.setAttribute("userAgent", user);
      ret.setErrCode(ErrorCode.SUCCESS.getCode());
      ret.setBody("添加购物车成功！");
    }
    return this.commonService.toJson(ret);
  }
}