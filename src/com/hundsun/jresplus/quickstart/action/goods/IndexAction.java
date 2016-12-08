package com.hundsun.jresplus.quickstart.action.goods;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;








import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hundsun.jresplus.quickstart.biz.po.Building;
import com.hundsun.jresplus.quickstart.biz.po.Category;
import com.hundsun.jresplus.quickstart.biz.po.Goods;
import com.hundsun.jresplus.quickstart.biz.po.News;
import com.hundsun.jresplus.quickstart.biz.po.Users;
import com.hundsun.jresplus.quickstart.biz.query.CategoryQuery;
import com.hundsun.jresplus.quickstart.biz.query.GoodsQuery;
import com.hundsun.jresplus.quickstart.biz.service.BuildingService;
import com.hundsun.jresplus.quickstart.biz.service.CategoryService;
import com.hundsun.jresplus.quickstart.biz.service.GoodsService;
import com.hundsun.jresplus.quickstart.biz.service.NewsService;
import com.hundsun.jresplus.quickstart.common.UserAgent;
import com.hundsun.jresplus.quickstart.enums.EnumGoodsType;
import com.hundsun.jresplus.quickstart.utils.CommonUtility;

/**
 * index页面
 * 
 * @author zhouc
 *
 */

@Controller
public class IndexAction {

	@Autowired
	private CategoryService cateService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private NewsService newsService;
	@Autowired
	private BuildingService buildingService;

	@RequestMapping(value = "/goods/index")
	public String showCurrentPoll(UserAgent user,
			@ModelAttribute("sale") GoodsQuery sale, 
			@ModelAttribute("provider") GoodsQuery provider, 
			@ModelAttribute("house") GoodsQuery house,
			Model model) {
		//UserAgent user = (UserAgent) session.getAttribute(UserAgent.AGENT);
		if( user !=null){
			sale.setBuildingId(user.getBuildingId());
			provider.setBuildingId(user.getBuildingId());
			house.setBuildingId(user.getBuildingId());
		}else{
			sale.setBuildingId(1L);
			provider.setBuildingId(1L);
			house.setBuildingId(1L);
		}
		sale.setType(EnumGoodsType.SALE.getCode());
		sale.setPageSize(8);
		goodsService.getPagination(sale, model);
		
		provider.setType(EnumGoodsType.PROVIDER.getCode());
		provider.setPageSize(8);
		goodsService.getPagination(provider, model);

		house.setType(EnumGoodsType.HOUSE.getCode());
		house.setPageSize(6);
		goodsService.getPagination(house, model);
		
		return "/goods/index";
	}
	

	
	// 前台滚动新闻NEW
	@RequestMapping(value = "/goods/picturess")
	public String getpicturesNews2(UserAgent user ,HttpServletRequest request,ModelMap model) {
		Long buildingId = 0L;
		StringBuffer url = request.getRequestURL();  
		String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append("/").toString();  
		String  status="0";
		List<Building>  lst= buildingService.getBuildingListByYuming(tempContextUrl);
		if(lst.size()>0){
			
			buildingId=lst.get(0).getId();
		}
		if (user != null && user.getBuildingId() != null) {
			// 楼宇
			buildingId = user.getBuildingId();
			status="1";
		} 
		List<News> newsList= newsService.getpicturesNewsList(buildingId,status);
		model.addAttribute("newsList", newsList);
		return "/block/picture";
	}
	
	
	
	
}
