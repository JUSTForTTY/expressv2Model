package com.hundsun.jresplus.quickstart.action.goods;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hundsun.jresplus.quickstart.biz.po.Goods;
import com.hundsun.jresplus.quickstart.biz.po.Goods_Num;
import com.hundsun.jresplus.quickstart.biz.query.GoodsQuery;
import com.hundsun.jresplus.quickstart.biz.service.GoodsService;
import com.hundsun.jresplus.quickstart.common.UserAgent;


@Controller
public class ShoppingCarAction {

	@Autowired
	private GoodsService goodsService;
	

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/goods/gwlc/gwlc")
	public String showGoods(UserAgent user,
			@ModelAttribute("id") Long id, 
			@ModelAttribute("goodsNum") Integer goodsNum) {
		
		user.getTradeCart().add2Cart(id, goodsNum);
//		String id = request.getParameter("id");
//		String num = request.getParameter("goodsNum");
//		String address = request.getParameter("address");
//		
//		//去cookies
//		Cookie[] cookies = request.getCookies();
//		//记入
//		int size = cookies.length==0?0:cookies.length+1;
//		String s1 = String.valueOf(size);
//		String s2 = String.valueOf(size+1);
//		Cookie cookieId = new Cookie("goods"+s1, id);
//		Cookie cookieNum = new Cookie("goods"+s2,num);
//		
//		response.addCookie(cookieId);
//		response.addCookie(cookieNum);
//		
//		
//		
//		Goods goods = goodsService.getById(Long.parseLong(id));
//		List<Goods_Num> list = new ArrayList<Goods_Num>();
//		Goods_Num gn = new Goods_Num();
//		gn.setGoods(goods);
//		gn.setNumber(Long.parseLong(num));
//		list.add(gn);
//
//		for(int i=0;i<cookies.length;i=i+2)
//		{	
//			boolean flag = cookies[i].getName().startsWith("goods");
//			if(flag)
//			{
//				Long goodsId = Long.parseLong(cookies[i].getValue());
//				Long number =  Long.parseLong(cookies[i+1].getValue());
//				Goods good = goodsService.getById(goodsId);
//				Goods_Num gn2 = new Goods_Num();
//				gn2.setGoods(good);
//				gn2.setNumber(number);
//				list.add(gn2);
//			}
//		}
//		
//		model.addAttribute("goodsList", list);
//		
//		model.addAttribute("address", address);
		return "/goods/gwlc/gwlc";
	}
	
	@RequestMapping(value="/goods/gwlc/gwlcdd")
	public String jiesuan( Model model)
	{
		return "/goods/gwlc/gwlcdd";
	}

}
