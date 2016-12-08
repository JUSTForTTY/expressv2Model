package com.hundsun.jresplus.quickstart.action.goods;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hundsun.jresplus.quickstart.biz.po.Category;
import com.hundsun.jresplus.quickstart.biz.po.Goods;
import com.hundsun.jresplus.quickstart.biz.query.CategoryQuery;
import com.hundsun.jresplus.quickstart.biz.query.GoodsQuery;
import com.hundsun.jresplus.quickstart.biz.service.CategoryService;
import com.hundsun.jresplus.quickstart.biz.service.GoodsService;
import com.hundsun.jresplus.quickstart.enums.EnumGoodsType;

/**
 * 竞价
 * 
 * @author tangty
 *
 */

@Controller
public class AuctionGoodsAction {
	@Autowired
	private GoodsService goodsService;

	@RequestMapping(value = "/goods/auction/list")
	public String showCurrentPoll(
			@ModelAttribute("query") GoodsQuery query, 
			Model model) {
		
		//query.setCategoryId(681L);
		query.setBuildingId(2L);
		query.setType(EnumGoodsType.AUCTION.getCode());
		goodsService.getPagination(query, model);
		return "/goods/auction/jjpt";
	}
}
