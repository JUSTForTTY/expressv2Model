 package com.hundsun.jresplus.quickstart.action.goods;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hundsun.jresplus.common.util.StringUtil;
import com.hundsun.jresplus.quickstart.biz.po.Category;
import com.hundsun.jresplus.quickstart.biz.po.Comment;
import com.hundsun.jresplus.quickstart.biz.po.Goods;
import com.hundsun.jresplus.quickstart.biz.po.Provider;
import com.hundsun.jresplus.quickstart.biz.query.CategoryQuery;
import com.hundsun.jresplus.quickstart.biz.query.CommentQuery;
import com.hundsun.jresplus.quickstart.biz.query.GoodsQuery;
import com.hundsun.jresplus.quickstart.biz.query.ProviderQuery;
import com.hundsun.jresplus.quickstart.biz.service.CategoryService;
import com.hundsun.jresplus.quickstart.biz.service.CommentService;
import com.hundsun.jresplus.quickstart.biz.service.GoodsCollectService;
import com.hundsun.jresplus.quickstart.biz.service.GoodsService;
import com.hundsun.jresplus.quickstart.biz.service.ProviderService;
import com.hundsun.jresplus.quickstart.common.UserAgent;
import com.hundsun.jresplus.quickstart.enums.EnumGoodsType;

/**
 * 企业
 * 
 * @author zhouc
 *
 */
@RequestMapping(value = "/goods/provider")
@Controller
public class ProviderGoodsAction {

	@Autowired
	private CategoryService cateService;
	@Autowired
	private GoodsService goodsService;
	
	@Autowired
	private ProviderService providerService;
	@Autowired
	private CommentService commentService;
	
	@Autowired
	 private GoodsCollectService goodsCollectService;
//	@RequestMapping(value = "/list")
//	public String showCurrentPoll(
//			@ModelAttribute("query") GoodsQuery query, 
//			@ModelAttribute("cateQuery") CategoryQuery cateQuery,
//			Model model) {
//		cateQuery.setType(EnumGoodsType.PROVIDER.getCode());
//		List<Category> lst = cateService.getParentCategory(cateQuery);
//		model.addAttribute("parentList", lst);
//		
//		cateQuery.setParentId(684L);
//		List<Category> lst1 = cateService.getChildCategoryById(cateQuery);
//		model.addAttribute("categoryList", lst1);
//		
//		//query.setCategoryId(681L);
//		query.setBuildingId(2L);
//		query.setType(EnumGoodsType.PROVIDER.getCode());
//		goodsService.getPagination(query, model);
//		return "/goods/provider/index";
//	}
	@RequestMapping(value = "/listCategory")
	public String getCategory(@RequestParam(value="id", required=false) String id,
			@ModelAttribute("query") GoodsQuery query, 
			@ModelAttribute("cateQuery") CategoryQuery cateQuery,
			Model model) {
		
		cateQuery.setType(EnumGoodsType.PROVIDER.getCode());
		List<Category> lst = cateService.getParentCategory(cateQuery);
		model.addAttribute("parentList", lst);
		
		cateQuery.setParentId(Long.parseLong(id));
		List<Category> lst1 = cateService.getChildCategoryById(cateQuery);
		model.addAttribute("categoryList", lst1);
		
		if(lst1.size()>0){
			query.setCategoryId(lst1.get(0).getId());
		} else query.setCategoryId(681L);
		query.setType(EnumGoodsType.PROVIDER.getCode());
		query.setBuildingId(2L);
		goodsService.getPagination(query);
		return "/goods/provider/index";
	}
	@RequestMapping(value = "/listProvider")
	public String getListProvider( 
			@ModelAttribute("query") ProviderQuery query, 
		 
			Model model) {
		System.out.println(query.getCurrentPageCount());
		System.out.println(query.getTotalPageCount());
		if(query.getCurrentPageCount()<=0){
			 System.out.println("tty");
			query.setCurrentPage(query.getTotalPageCount());
		}
		
		else if(query.getCurrentPageCount()>=query.getTotalPageCount()){
			
			query.setCurrentPage(1);
		}
		
		else{
			
			
			query.setCurrentPage(query.getCurrentPageCount());
		}
		
		System.out.println(query.getCurrentPage());
		System.out.println(query.getTotalPage());
		
		
		 query.setPageSize(1);
	
	 providerService.getPagination(query, model);
	 
	 
	 List<?> lst=query.getItems();
	 Provider provider=(Provider) lst.get(0);
	 System.out.println(provider.getId());
	 int  i=    goodsCollectService.collectPeople(provider.getId().longValue());
	   
	 System.out.println("粉丝人数"+i);
	 
	 model.addAttribute("collectPeople", i);
	 
	 
		return "/goods/provider/providerView";
	}

	@RequestMapping(value = "/view")
	public String showCurrentPoll(@RequestParam("id") Long id, Model model) {

//		Goods goods = service.getById(id);
//		model.addAttribute("goods", goods);
		return "/goods/provider/view";
	}

	@RequestMapping(value = "/iframeList")
	public String showSaleList(UserAgent user,
			@ModelAttribute("query") GoodsQuery query, 
			@ModelAttribute("cateQuery") CategoryQuery cateQuery,
			Model model) {
		query.setPageSize(8);		

		if( user != null){
			query.setBuildingId(user.getBuildingId());
		}else{
			query.setBuildingId(0L);
		}
		query.setType(EnumGoodsType.PROVIDER.getCode());
		goodsService.getPagination(query, model);
		return "/goods/provider/iframeList2";
	}
	
	@RequestMapping(value = "/list")
	public String showProviderList(UserAgent user,
			@ModelAttribute("query") GoodsQuery query, 
			@ModelAttribute("cateQuery") CategoryQuery cateQuery,
			Model model) { 
		query.setPageSize(12);		
		   String name = query.getName();
	        // 如果有name字段填写就清空类目
		   Long categoryId = query.getCategoryId();
		   if (StringUtil.isNotBlank(name)) {
	            categoryId = null;
	            query.setCategoryId(categoryId);
	        }
		if( user != null){
			query.setBuildingId(user.getBuildingId());
		}else{
			query.setBuildingId(0L);
		}
		query.setType(EnumGoodsType.PROVIDER.getCode());
		goodsService.getPagination(query, model);
		return "/goods/provider/list";
	}
	
	
	@RequestMapping(value = "/detail")
	public String showCurrentPoll2(UserAgent user,
			@RequestParam(value="id")Long id,
			@ModelAttribute("query") GoodsQuery query,  
			@ModelAttribute("query2") CommentQuery query2, 
			@ModelAttribute("cateQuery") CategoryQuery cateQuery,
			Model model)
	{
		if( user != null){
			query.setBuildingId(user.getBuildingId());
		}else{
			query.setBuildingId(0L);
		}
		//query.setType(EnumGoodsType.HOUSE.getCode());
		query.setPageSize(8);
		query.setProviderId(id);
		goodsService.getProviderList(query,model);
		
	     Goods goods = goodsService.getById(id);
		 model.addAttribute("goods", goods);
		   
		//huoqu粉丝人数
		int  i=    goodsCollectService.collectPeople(id);
		   
		 System.out.println("粉丝人数"+i);
		 
		 model.addAttribute("collectPeople", i);
		 
		 //公司产品
	  
	    query2.setGoodsId(id);
	    
	    System.out.println("商品id"+id);
	    query2.setPageSize(4);
		commentService.getPagination(query2, model);
		   
		return "/goods/provider/detail";
	}	
	
	
	  
	@RequestMapping(value = "/delete")
	public String deleteComment(UserAgent user,
			@RequestParam(value="id")Long id,
			@RequestParam(value="goodsid")int goodsid,
			 
			Model model)
	{
		   commentService.delete(id);
		
	    
	    model.addAttribute("id", goodsid);
		
		return "redirect:" + "/goods/provider/detail.htm";
	}	
	//更新日志
	@RequestMapping(value = "/update",method=RequestMethod.GET)
	public String updateComment(UserAgent user,
			@RequestParam(value="id")Long id,
			@RequestParam(value="goodsid")int goodsid,
			 
			Model model)
	{
		Comment comment=  commentService.update(id);
		model.addAttribute("comment", comment);
	    
	    model.addAttribute("goodsid", goodsid);
		
		return "/goods/provider/updateComment";
	}	
	
	
	//更新日志
	@RequestMapping(value = "/update",method=RequestMethod.POST)
	public String doupdateComment(UserAgent user,Comment comment,
	 
			@RequestParam(value="goodsid")int goodsid,
			 
			Model model)
	{
		
		int i=  commentService.update(comment);
		  
	    
	    model.addAttribute("id", goodsid);
		
	    return "redirect:" + "/goods/provider/detail.htm";
	}	
	

	//增加日志
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public String create(UserAgent user,
			HttpServletRequest request,
			@ModelAttribute Comment comment,
			@RequestParam(value = "id") Long id,
			 
			@ModelAttribute("query") CommentQuery query, Model model          		
	){

		System.out.println("this is add comment method !!");
	     
		//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		Date date=new Date();
		  
		 comment.setCreatetime(date);
		 comment.setUsername(user.getUserName());//需获取当前用户
		commentService.create(comment);
		Goods goods = goodsService.getById(id);
		model.addAttribute("goods", goods)	;
		query.setPageSize(5);
		query.setGoodsId(id);
		commentService.getPagination(query, model);
         model.addAttribute("id", id);
		
		
         return "redirect:" + "/goods/provider/detail.htm";
	}
 
	

	
	
	
//	@RequestMapping(value = "/list")
//	public String showCurrentPoll(
//			@ModelAttribute("query") GoodsQuery query, 
//			@ModelAttribute("cateQuery") CategoryQuery cateQuery,
//			Model model,UserAgent user) {
//		cateQuery.setParentId(684L);
//		cateQuery.setType(EnumGoodsType.PROVIDER.getCode());
//		List<Category> lst = cateService.getParentCategory(cateQuery);
//		model.addAttribute("parentList", lst);
//		
//		 
//		List<Category> lst1 = cateService.getChildCategoryById(cateQuery);
//		model.addAttribute("categoryList", lst1);
//		
//		//query.setCategoryId(681L);
//		query.setBuildingId(5L);
//		query.setType(EnumGoodsType.PROVIDER.getCode());
//		query.setPageSize(8);
//		goodsService.getPagination(query, model);
//		return "/goods/provider/list";
//	}
	
	
}
