package com.hundsun.jresplus.quickstart.action.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;







import com.hundsun.jresplus.quickstart.biz.po.Category;
import com.hundsun.jresplus.quickstart.biz.po.Goods;
import com.hundsun.jresplus.quickstart.biz.query.CategoryQuery;
import com.hundsun.jresplus.quickstart.biz.query.CommentQuery;
import com.hundsun.jresplus.quickstart.biz.query.GoodsQuery;
import com.hundsun.jresplus.quickstart.biz.service.CategoryService;
import com.hundsun.jresplus.quickstart.biz.service.CommentService;
import com.hundsun.jresplus.quickstart.biz.service.GoodsService;
import com.hundsun.jresplus.quickstart.common.UserAgent;
import com.hundsun.jresplus.quickstart.enums.EnumGoodsType;

/**
 * 企业
 * 
 * @author zhouc
 *
 */
@RequestMapping(value = "/goods/house")
@Controller
public class HouseGoodsAction {

	@Autowired
	private CategoryService cateService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private CommentService commentService;

//	@RequestMapping(value = "/goods/house/list")
//	public String showCurrentPoll(
//			@ModelAttribute("query") GoodsQuery query, 
//			@ModelAttribute("cateQuery") CategoryQuery cateQuery,
//			Model model) {
//
//		query.setBuildingId(2L);
//		query.setType(EnumGoodsType.HOUSE.getCode());
//		goodsService.getPagination(query, model);
//		return "/goods/house/kcxx";
//	}

	@RequestMapping(value = "/goods/house/kcxxq")
	public String showView(@RequestParam(value = "id") Long id,
			 Model model) {

		Goods goods = goodsService.getById(id);
		model.addAttribute("goods", goods);
		
	
		return "/goods/house/kcxxq";
	}
	
	@RequestMapping(value = "/iframeList")
	public String showSaleList(UserAgent user,
			@ModelAttribute("query") GoodsQuery query, 
			@ModelAttribute("cateQuery") CategoryQuery cateQuery,
			Model model) {
		query.setPageSize(6);		

		if( user != null){
			query.setBuildingId(user.getBuildingId());
		}else{
			query.setBuildingId(0L);
		}
		query.setType(EnumGoodsType.HOUSE.getCode());
		goodsService.getPagination(query, model);
		return "/goods/house/iframeList";
	}
	
	
	@RequestMapping(value = "/list")
	public String showHouseList(UserAgent user,
			@ModelAttribute("query") GoodsQuery query, 
			@ModelAttribute("cateQuery") CategoryQuery cateQuery,
			Model model) {
		query.setPageSize(12);		

		if( user != null){
			query.setBuildingId(user.getBuildingId());
		}else{
			query.setBuildingId(0L);
		}
		query.setType(EnumGoodsType.HOUSE.getCode());
		goodsService.getPagination(query, model);
		return "/goods/house/list";
	}
	
	
	@RequestMapping(value = "/detail")
	public String showCurrentPoll(
			@RequestParam(value = "id") Long id,
			@ModelAttribute("query") CommentQuery query, Model model) 
	{
		Goods goods = goodsService.getById(id);
		model.addAttribute("goods", goods)	;
		
		query.setGoodsId(id);
		commentService.getPagination(query, model);
         model.addAttribute("id", id);
       
		return "/goods/house/detail";
	}
	
//	@RequestMapping(value = "/list")
//	public String showCurrentPoll(
//			@ModelAttribute("query") GoodsQuery query, 
//			@ModelAttribute("cateQuery") CategoryQuery cateQuery,
//			Model model,UserAgent user) {
//		cateQuery.setParentId(684L);
//		cateQuery.setType(EnumGoodsType.HOUSE.getCode());
//		List<Category> lst = cateService.getParentCategory(cateQuery);
//		model.addAttribute("parentList", lst);
//		
//		 
//		List<Category> lst1 = cateService.getChildCategoryById(cateQuery);
//		model.addAttribute("categoryList", lst1);
//		
//		//query.setCategoryId(681L);
//		query.setBuildingId(5L);
//		query.setType(EnumGoodsType.HOUSE.getCode());
//		query.setPageSize(6);
//		goodsService.getPagination(query, model);
//		return "/goods/house/list";
//	}
	

}


