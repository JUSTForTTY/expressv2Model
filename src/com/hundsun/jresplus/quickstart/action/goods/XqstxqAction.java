package com.hundsun.jresplus.quickstart.action.goods;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.DailyRollingFileAppender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hundsun.jresplus.quickstart.biz.po.Activity;
import com.hundsun.jresplus.quickstart.biz.po.ActivityMember;
import com.hundsun.jresplus.quickstart.biz.po.ActivityProject;
import com.hundsun.jresplus.quickstart.biz.po.Club;
import com.hundsun.jresplus.quickstart.biz.po.ClubMember;
import com.hundsun.jresplus.quickstart.biz.po.Comment;
import com.hundsun.jresplus.quickstart.biz.po.Goods;
import com.hundsun.jresplus.quickstart.biz.po.Log;
import com.hundsun.jresplus.quickstart.biz.po.News;
import com.hundsun.jresplus.quickstart.biz.po.PayInfo;
import com.hundsun.jresplus.quickstart.biz.po.PrepayLog;
import com.hundsun.jresplus.quickstart.biz.po.Sequence;
import com.hundsun.jresplus.quickstart.biz.po.Settlement;
import com.hundsun.jresplus.quickstart.biz.po.User;
import com.hundsun.jresplus.quickstart.biz.po.UserCostItem;
import com.hundsun.jresplus.quickstart.biz.po.Users;
import com.hundsun.jresplus.quickstart.biz.query.ActivityCommentQuery;
import com.hundsun.jresplus.quickstart.biz.query.CommentQuery;
import com.hundsun.jresplus.quickstart.biz.query.GoodsQuery;
import com.hundsun.jresplus.quickstart.biz.query.NewsQuery;
import com.hundsun.jresplus.quickstart.biz.query.SocityActivityQuery;
import com.hundsun.jresplus.quickstart.biz.query.SocityClubMemberQuery;
import com.hundsun.jresplus.quickstart.biz.query.SocityClubQuery;
import com.hundsun.jresplus.quickstart.biz.service.CommentService;
import com.hundsun.jresplus.quickstart.biz.service.CommonService;
import com.hundsun.jresplus.quickstart.biz.service.GoodsService;
import com.hundsun.jresplus.quickstart.biz.service.NewsService;
import com.hundsun.jresplus.quickstart.biz.service.OutPayService;
import com.hundsun.jresplus.quickstart.biz.service.UserService;
import com.hundsun.jresplus.quickstart.common.CommonDefine;
import com.hundsun.jresplus.quickstart.common.UserAgent;
import com.hundsun.jresplus.quickstart.enums.EnumGoodsType;
import com.hundsun.jresplus.quickstart.enums.EnumOrderItemStatus;


@RequestMapping(value = "/goods/society")
@Controller
public class XqstxqAction {
	@Autowired
	private GoodsService goodsService;
	
	@Autowired
	  private UserService userService;
	
	@Autowired
	  private CommonService commonService;
	
	@Autowired
	  private NewsService newsService;
	
	@Autowired
	private OutPayService outPayServiceImpl;
	 
	private Comment comment;

	public Comment getComment() {
		return comment;
	}


	public void setComment(Comment comment) {
		this.comment = comment;
	}


	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value = "/xqstxq")
	public String showCurrentPoll(
			@RequestParam(value = "id") Long id,
			 
			@ModelAttribute("query") CommentQuery query, Model model) 
	        
	{
		        
		Goods goods = goodsService.getById(id);
		model.addAttribute("goods", goods)	;
		query.setPageSize(5);
		query.setGoodsId(id);
		commentService.getPagination(query, model);
         model.addAttribute("id", id);
       
		return "/goods/society/xqstxq";
	}
	
	@RequestMapping(value = "/detail")
	public String showCurrentPoll2(
			@RequestParam(value = "cid") String cid,
			 
			@ModelAttribute("query") SocityClubQuery socityQuery,@ModelAttribute("activityQuery")SocityActivityQuery socityActivityQuery,Model model) 
	        
	{
		socityActivityQuery.setPageSize(4);
		
		//查询社团信息
		System.out.println("社团详情方法");
	   Club club=	goodsService.getById(cid);
		model.addAttribute("club", club);
		// 查询社团成员信息
		
		socityQuery.setStatus(CommonDefine.STATUS_OPEN);
		 
		 socityQuery.setPageSize(3);
		  goodsService.getClubMemberPagination(socityQuery);
		 
		
		//查询社团活动信息
		socityActivityQuery.setStatus(CommonDefine.ACTIVITY_NORMAL);
		 
		 
		goodsService.getActivityPagination(socityActivityQuery,model);
		 
		        
		 
       
		return "/goods/society/detail";
	}
	
	
	
	@RequestMapping(value = "/clubMember")
	public String showclubMember(
			@RequestParam(value = "cid") String cid,
			 
			@ModelAttribute("query") SocityClubQuery socityQuery,Model model) 
	        
	{
		 
		// 查询社团成员信息
		
		socityQuery.setStatus(CommonDefine.STATUS_OPEN);
		 
		 socityQuery.setPageSize(4);
		  goodsService.getClubMemberPagination(socityQuery);
		 
		
		 
		 
       
		return "/goods/society/clubMember";
	}
	
	 
	@RequestMapping(value = "/joinClub")
	@ResponseBody
	public String joinClub(
			@RequestParam(value = "cid") String cid,
			UserAgent user,Model model)       
	{
		  System.out.println("kaishi");
		Settlement settle=new Settlement();
		SocityClubMemberQuery query=new SocityClubMemberQuery();
		
		if(null==user||"".equals(user)){
			
			
			settle.setResult("nologin");
		}
		else{
			
			//校验用户是否已经关注过社团
			query.setUid(user.getId().toString());
			query.setStatus(CommonDefine.STATUS_OPEN);
			query.setCid(cid);
			boolean flag=goodsService.checkClubMember(query);
			
			if(flag){
				
				settle.setResult("userrepeat");
				
				
			}
			
			else{
				//获取sequence
				Sequence squence=new Sequence();
				squence.setTablename("cmid");
				String cmid= goodsService.getSequence(squence);
				
				//增加成员
				 User userInfo = this.userService.getByUserName(user.getUserName());
				
				ClubMember clubmember=new ClubMember();
				clubmember.setCmid(cmid);
				clubmember.setCid(cid);
				clubmember.setUid(user.getId().toString());
				clubmember.setBid(5);
				clubmember.setName(user.getUserName());
				clubmember.setStatus(CommonDefine.STATUS_OPEN);
				clubmember.setNickname(user.getNickName());
				clubmember.setMobile(userInfo.getMobile());
				clubmember.setGender(userInfo.getGender());
				
				clubmember.setCreateUser(user.getId().toString());
				clubmember.setCreateTime(new Date());
				clubmember.setModifyUser(user.getId().toString());
				clubmember.setModifyTime(new Date());
				
				
				goodsService.saveClubMember(clubmember);
				settle.setResult("success");
				
			}
			
		}
		
		 
       
		return  commonService.toJson(settle);
	}
	
	
	
	
	@RequestMapping(value = "/checkUserJoinClub")
	@ResponseBody
	public String checkUserJoinClub(
			@RequestParam(value = "cid") String cid,
			UserAgent user,Model model)       
	{
		  
		Settlement settle=new Settlement();
		SocityClubMemberQuery query=new SocityClubMemberQuery();
		
		if(null==user||"".equals(user)){
			
			
			settle.setResult("nologin");
		}
		else{
			
			//校验用户是否已经关注过社团
			//查询用户社团信息
			ClubMember clubMember=new ClubMember();
			clubMember.setUid(user.getId().toString());
			clubMember.setCid(cid);
			ClubMember clubMemberbean=goodsService.selectClubMember(clubMember);
			
			if(null==clubMemberbean||"".equals(clubMemberbean)){
				
				settle.setResult("fail");
				
			}
			
			else{
				
				settle.setResult("success");
			}
			
			 
				 
				
			 
			
		}
		
		 
       
		return  commonService.toJson(settle);
	}
	
	
	
	@RequestMapping(value = "/activityDetail")
	public String Activitydetail(
			@RequestParam(value = "aid") String aid,
			 
			@ModelAttribute("query")SocityActivityQuery query,
			@ModelAttribute("activityProjectQuery")SocityActivityQuery socityActivityQuery,@ModelAttribute("commentQuery") CommentQuery commentQuery,
			@ModelAttribute("activityComment")ActivityCommentQuery activityCommentQuery,
			@ModelAttribute("newsQuery")NewsQuery newsQuery,
			Model model) 
	        
	{
		
		// 增加人气值
		
		goodsService.addActivityClickNum(aid);
		
		//查询活动信息
		 Activity activity=goodsService.getActivityById(aid);
		 model.addAttribute("activity", activity);
		// 查询活动成员信息
		 
		query.setPageSize(3);
		 goodsService.getActivityMemberPagination(query);
		 
		
		//查询活动项目信息
		 
		 socityActivityQuery.setStatus("0");
		 socityActivityQuery.setPageSize(4);
		 goodsService.getActivityProjectPagination(socityActivityQuery);
		 
		        
		 //查询帖子
		 commentQuery.setPageSize(2);
		 commentQuery.setGoodsId(Long.parseLong(aid));
		 commentService.getPagination(commentQuery, model);
		 
		 
		 
		 
	  
       
		return "/goods/society/activityDetail";
	}
	
	
	
	
	
	@RequestMapping(value = "/historyView")
	public String historyView(
			 
			@ModelAttribute("newsQuery")NewsQuery newsQuery,
			Model model) 
	        
	{
		
	 
		 
		 //查询历史回顾
		 newsQuery.setPageSize(4);
		 newsQuery.setProviderId(3854);
		 newsQuery.setType("10");
		 
	      newsService.getNewsList(newsQuery);
		 
	  
       
		return "/goods/society/historyView";
	}
	
	
	
	@RequestMapping(value = "/activityMember")
	public String activityMember(
			@RequestParam(value = "aid") String aid,
			 
			@ModelAttribute("query")SocityActivityQuery query,
			Model model) 
	        
	{
		
		 
		// 查询活动成员信息
		 
		query.setPageSize(4);
		 goodsService.getActivityMemberPagination(query);
		 
		
		 
		 
       
		return "/goods/society/activityMember";
	}
	
	
	
	@RequestMapping(value = "/payConfirm")
	public String doPayConfirm(
			Model  model,
			UserAgent user,
			@RequestParam(value = "apid", required = true) String apid,
			HttpServletRequest request) {

		// 查询活动项目
				ActivityProject activityProject =  goodsService.getActivityProjectById(apid);

		// 模拟用户

		 

		if (null==user||"".equals(user)) {

			 
			
			return "login/login";
		}
		// 查看用户是否存在于‘活动member’表，若存在读取报名信息
//		ActivityMember activityMember = activityBiz.getActivityMember(user
//				.getCmid());
//		if (null != activityMember && !"".equals(activityMember)) {
//			// 若存在，则传到前台
//			model.addAttribute("activityMember", activityMember);
//		}

		 
		model.addAttribute("activityProject", activityProject);

		// 查询活动
		Activity activityBean = goodsService.getActivityById(activityProject
				.getAid());

		model.addAttribute("activityBean", activityBean);

		return "goods/society/payConfirm";
	}
	
	
	
	@RequestMapping(value = "/doPay")
	public String doPayConfirm(Model model,
			ActivityMember activityMember, ActivityProject activityProject,
			@RequestParam(value = "payType", required = true) String payType,
			HttpServletRequest request,UserAgent user,HttpSession session) {

	 

		if (null == user || "".equals(user)) {

			return "login/login";
		}
		// 查询活动项目信息
		 
		ActivityProject activityProjectbean = goodsService.getActivityProjectById(activityProject.getApid());
				
		
		System.out.println("活动id"+activityProjectbean.getAid());
 
		Activity activity=goodsService.getActivityById(activityProjectbean.getAid());
		
		//查询用户社团信息
				ClubMember clubMember=new ClubMember();
				clubMember.setUid(user.getId().toString());
				clubMember.setCid(activity.getCid());
				ClubMember clubMemberbean=goodsService.selectClubMember(clubMember);
		// 判断用户是否有过报名信息
		// 查看用户是否存在于‘活动member’表，若存在读取报名信息
		//log.debug("查询活动成员信息");
				System.out.println("社团人员号"+clubMemberbean.getCmid());
		ActivityMember activityMemberbean = goodsService.getActivityMemberById(clubMemberbean.getCmid());

		 
		
		
		goodsService.saveOrUpdateActivityMember(activityMemberbean,
				activityMember, clubMemberbean, activityProjectbean);

		// 生成log订单表
		Log log=new Log();
		 String sql="CALL pro_getRunningNO('LID')";
		    Sequence squence=new Sequence();
			squence.setTablename("LID");
			String lid= goodsService.getSequence(squence);
		 log.setLid(lid);
		 log.setCmid(clubMemberbean.getCmid());
		 log.setBid(0);
		 log.setPayment(activityProjectbean.getPrice());
		 log.setAmount(activityProjectbean.getPrice());
		 log.setStatus(CommonDefine.STATUS_NOPAY);
		 log.setPayType(payType);
		 log.setPayFlag("");
		 log.setCreateUser(clubMemberbean.getUid());
		 log.setCreateTime(new Timestamp(new Date().getTime()));
		 log.setModifyUser(clubMemberbean.getUid());
		 log.setModifyTime(new Timestamp(new Date().getTime()));
	      goodsService.insertLog(log);
		//log.debug("订单lid：" + lid);
		// 生成user_cost_item

	      
	      UserCostItem userCostItem=new UserCostItem();
		 
			   Sequence squence2=new Sequence();
				squence2.setTablename("UC_ID");
				String ucid= goodsService.getSequence(squence2);
			
			userCostItem.setUcid(ucid);
			userCostItem.setCmid(clubMemberbean.getCmid());
			userCostItem.setBid(0);
			userCostItem.setApid(activityProjectbean.getApid());
			userCostItem.setLid(lid);
			userCostItem.setName(activityProjectbean.getName());
			userCostItem.setFlag("");
			userCostItem.setStatus(1);
			userCostItem.setCreateUser(clubMemberbean.getUid());
			userCostItem.setCreateTime(new Timestamp(new Date().getTime()));
			userCostItem.setModifyUser(clubMemberbean.getUid());
			userCostItem.setModifyTime(new Timestamp(new Date().getTime()));
	      
	       goodsService.insertUserCostItem(userCostItem); 

		// 查询订单log

		 Log logbean = goodsService.getLogById(lid);
		System.out.println(logbean);

		// 查询用户信息
		//User usercheck = goodsService.get(user.getId());
		
		 User userInfo = this.userService.getByUserName(user.getUserName());
		//Boolean flag = new Encryption().isEqual(usercheck);
		// 资金异常
		 
		// 支付宝支付流程
		if (payType.equals(String.valueOf(CommonDefine.ORDERPAYTYPE_ALIPAY))) {
			// 付钱
			PayInfo data = new PayInfo();
			data.setAmount((int) (logbean.getPayment() * 100.0D));
			data.setDesc("会员单位统一支付平台");
			data.setUserId(Long.parseLong(logbean.getCmid()));
			data.setRequestId(Long.parseLong(logbean.getLid()));
			data.setPayType(CommonDefine.ORDERPAYTYPE_ALIPAY);// web支付
			data.setNotify_url(CommonDefine.ALIPAY_NOTIFY_URL);
			data.setReturn_url(CommonDefine.ALIPAY_RETURN_URL);

			// this.outPayService 支付service

			
			model.addAttribute("content", this.outPayServiceImpl.recharge(data));
			return "/settle/empty";
		}
		// 预存款消费
		if (payType.equals(String.valueOf(CommonDefine.ORDERPAYTYPE_PREPAY))) {

			 if (userInfo.getPrepay() < logbean.getPayment()) {
			        model.addAttribute("message", "预存款不足");
			        return "error";
			      }
			     
			     
			      this.userService.updatePrepayById(user.getId(),  -logbean.getPayment().doubleValue());

			      Long newPrepay = 
			    	        Long.valueOf(new BigDecimal(Double.valueOf(
					    	        user.getPrepay() - logbean.getPayment()).toString()).movePointRight(2)
					    	        .longValue());
			      
			      //更新订单
			      logbean.setStatus(CommonDefine.LOG_PAY_STATUS_TRUE);
			      
			      
			      
			      goodsService.updateLog(logbean);
			      
			      UserCostItem userCostItem2=new UserCostItem();
			      userCostItem2.setUcid(ucid);
			      userCostItem2.setStatus(CommonDefine.LOG_PAY_STATUS_TRUE);
			      goodsService.updateUserCostItem(userCostItem2);
			      //this.orderinfoService.updateOrderinfoStatus(orderinfoModel.getId(), 32);

			      //this.orderitemService.updateStatusByOrderInfoId(ordid.longValue(), "32");
			      
			      user.setPrepay(newPrepay);
			      user.getTradeCart().clearCart();
			      session.setAttribute("userAgent", user);
			    
			      return "/settle/order3Finish";

		}

		return "error";
	}

	
	
	
 
//增加评论
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public String create(HttpServletRequest request,
			@ModelAttribute Comment comment,
		 
			 UserAgent user,
			@ModelAttribute("query") CommentQuery query, Model model          		
	){

		System.out.println("this is add comment method !!");
	     
		//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		Date date=new Date();
		  
		 comment.setCreatetime(date);
		 comment.setUsername(user.getUserName());//需获取当前用户
		commentService.create(comment);
		 
	 
		 model.addAttribute("aid", comment.getGoodsId());
		
         return "redirect:" + "/goods/society/activityDetail.htm";
	}
 
	
	
	
	@RequestMapping(value="/test")
	public String test(HttpServletRequest request,
			  
			@ModelAttribute("query") CommentQuery query, Model model          		
	){

	   
		 
		 
		
         return "/goods/society/xqstxq";
	}
	
}
