package com.hundsun.jresplus.quickstart.action.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hundsun.jresplus.quickstart.biz.query.GoodsQuery;
import com.hundsun.jresplus.quickstart.biz.service.GoodsService;
import com.hundsun.jresplus.quickstart.enums.EnumGoodsType;

@Controller
public class WdkjAction {

	@Autowired
	private GoodsService goodsService;

	@RequestMapping(value = "/goods/auction/wdkj")
	public String showCurrentPoll(
			@ModelAttribute("query") GoodsQuery query,
			Model model) {

		// query.setCategoryId(681L);
		query.setBuildingId(2L);
		query.setType(EnumGoodsType.AUCTION.getCode());
		goodsService.getAuctionPagination(query, model);
		return "/goods/auction/wdkj";
	}
}
