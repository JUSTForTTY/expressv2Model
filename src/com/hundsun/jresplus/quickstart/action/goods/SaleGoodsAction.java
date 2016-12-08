package com.hundsun.jresplus.quickstart.action.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hundsun.jresplus.quickstart.biz.po.Response;
import com.hundsun.jresplus.quickstart.biz.query.CategoryQuery;
import com.hundsun.jresplus.quickstart.biz.query.GoodsQuery;
import com.hundsun.jresplus.quickstart.biz.service.CategoryService;
import com.hundsun.jresplus.quickstart.biz.service.CommentService;
import com.hundsun.jresplus.quickstart.biz.service.GoodsService;
import com.hundsun.jresplus.quickstart.biz.service.LikeService;
import com.hundsun.jresplus.quickstart.common.UserAgent;
import com.hundsun.jresplus.quickstart.enums.EnumGoodsType;
import com.hundsun.jresplus.quickstart.enums.ErrorCode;

@RequestMapping(value = "/goods/sale")
@Controller
public class SaleGoodsAction {
	@Autowired
	private CategoryService cateService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private CommentService commentService;
    @Autowired
    private LikeService     likeService;

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
		query.setType(EnumGoodsType.SALE.getCode());
		goodsService.getPagination(query, model);
		return "/goods/sale/iframeList";
	}
	
    @RequestMapping("/ajax/getCount.htm")
    public @ResponseBody String getLoginStatus(UserAgent user) {
        GoodsQuery query = new GoodsQuery();
        if (user != null) {
            query.setBuildingId(user.getBuildingId());
        } else {
            query.setBuildingId(0L);
        }
        query.setType(EnumGoodsType.SALE.getCode());
        Integer goodsCount = goodsService.getGoodsCountByQuery(query);
        return "jsonpcallbackForSale(" + goodsCount + ")";
    }
    
	@RequestMapping(value = "/list")
	public String showCurrentPoll(UserAgent user,
			@ModelAttribute("query") GoodsQuery query, 
			@ModelAttribute("cateQuery") CategoryQuery cateQuery,
			Model model) {
		query.setPageSize(12);		

		//query.setCategoryId(681L);
		if( user != null){
			query.setBuildingId(user.getBuildingId());
		}else{
			query.setBuildingId(0L);
		}
		query.setType(EnumGoodsType. SALE.getCode());
		goodsService.getPagination(query, model);
		return "/goods/sale/list";
	}
//	@RequestMapping(value = "/listCategory")
//	public String getCategory(@RequestParam(value="id", required=false) String id,
//			@ModelAttribute("query") GoodsQuery query, 
//			@ModelAttribute("cateQuery") CategoryQuery cateQuery,
//			Model model) {
//		
//		cateQuery.setType(EnumGoodsType. SALE.getCode());
//		List<Category> lst = cateService.getParentCategory(cateQuery);
//		model.addAttribute("parentList", lst);
//		
//		cateQuery.setParentId(Long.parseLong(id));
//		List<Category> lst1 = cateService.getChildCategoryById(cateQuery);
//		model.addAttribute("categoryList", lst1);
//		
//		if(lst1.size()>0){
//			query.setCategoryId(lst1.get(0).getId());
//		} else query.setCategoryId(681L);
//		query.setType(EnumGoodsType. SALE.getCode());
//		query.setBuildingId(0L);
//		goodsService.getPagination(query);
//		return "/goods/provider/mrcx";
//	}
//	@RequestMapping(value = "/listProvider")
//	public String getListProvider(@RequestParam(value="id", required=false) String id,
//			@RequestParam(value="parentId", required=false) String parentId,
//			@ModelAttribute("query") GoodsQuery query, 
//			@ModelAttribute("cateQuery") CategoryQuery cateQuery,
//			Model model) {
//		
////		cateQuery.setType(EnumGoodsType. SALE.getCode());
////		List<Category> lst = cateService.getParentCategory(cateQuery);
////		model.addAttribute("parentList", lst);
////		
////		//String parentId = (String) request.getParameter("parentId");
////		cateQuery.setParentId(Long.parseLong(parentId));
////		List<Category> lst1 = cateService.getChildCategoryById(cateQuery);
////		model.addAttribute("categoryList", lst1);
//		
//		//String id = (String) request.getParameter("id");
//		query.setCategoryId(Long.parseLong(id));
//		query.setType(EnumGoodsType. SALE.getCode());
//		query.setBuildingId(0L);
//		goodsService.getPagination(query);
//		return "/goods/sale/mrcx";
//	}
//	@RequestMapping(value = "xpxxxq")
////	public String showView(@RequestParam(value = "id") Long id,
////			@ModelAttribute("query") CommentQuery query, Model model) {
//    public String showView(@RequestParam(value = "id") Long id,
//            @ModelAttribute("query") CommentQuery query,
//            @ModelAttribute("goodsQuery") NormalGoodsQuery goodsQuery, Model model) {
//		 
////		Goods goods = goodsService.getById(id);
////		model.addAttribute("goods", goods);
////		
////		query.setGoodsId(id);
////		commentService.getPagination(query, model);
//		//return "/goods/sale/xpxxxq";
//        query.setGoodsId(id);
//        commentService.getPagination(query, model);
//
//        Goods goods = goodsService.getById(id);
//        // view num +1
//        likeService.addViewNum(goods);
//        // +1 finish
//
//        model.addAttribute("goods", goods);
//        return "/goods/normal/detail";
//	}
//
//
//	@RequestMapping(value = "/view")
//	public String showCurrentPoll(@RequestParam("id") Long id, Model model) {
//
////		Goods goods = service.getById(id);
////		model.addAttribute("goods", goods);
//		return "/goods/sale/view";
//	}


}
