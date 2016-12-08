package com.hundsun.jresplus.quickstart.action.goods;

import java.util.List;

import javax.crypto.EncryptedPrivateKeyInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hundsun.jresplus.quickstart.biz.po.Category;
import com.hundsun.jresplus.quickstart.biz.po.User;
import com.hundsun.jresplus.quickstart.biz.query.CategoryQuery;
import com.hundsun.jresplus.quickstart.biz.query.GoodsQuery;
import com.hundsun.jresplus.quickstart.biz.query.SocityActivityQuery;
import com.hundsun.jresplus.quickstart.biz.query.SocityClubQuery;
import com.hundsun.jresplus.quickstart.biz.service.CategoryService;
import com.hundsun.jresplus.quickstart.biz.service.CommentService;
import com.hundsun.jresplus.quickstart.biz.service.GoodsService;
import com.hundsun.jresplus.quickstart.biz.service.UserService;
import com.hundsun.jresplus.quickstart.common.CommonDefine;
import com.hundsun.jresplus.quickstart.common.UserAgent;
import com.hundsun.jresplus.quickstart.enums.EnumGoodsType;
import com.hundsun.jresplus.quickstart.utils.EncryptUtil;
import com.hundsun.jresplus.quickstart.utils.MD5utils;

/**
 * 社团
 * 
 * @author tty
 *
 */

@RequestMapping(value = "/goods/society")
@Controller
public class SocietyAction {

	@Autowired
	private GoodsService goodsService;
	@Autowired
	private CategoryService cateService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private UserService userService;

	@Value("${property.login.url}")
	private String serverUrl;
	@Value("${md5.key}")
	private String key;

	/**
	 * 社团登录认证接口
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/embed")
	public String embed(UserAgent user, Model model) {
		if (user != null) {
			User userdata = userService.getById(user.getId());
			String userName = EncryptUtil.setEncrypt(userdata.getUsername());
			String password = EncryptUtil.setEncrypt(userdata.getPasswd());
			String url = serverUrl + "?userName=" + userName + "&password=" + password;
			System.out.println(url);
			

			return "redirect:"+url;

		} else {

			return "login/login";
		}

	}

	@RequestMapping(value = "/club")
	public String showclub(Model model,@RequestParam(value="url") String url) {

		
		model.addAttribute("url", url);
		 
		return "/goods/society/xqst";
	}
	
	
	@RequestMapping(value = "/xqst")
	public String showCurrentPoll(@ModelAttribute("query") SocityClubQuery query, Model model) {

		 
		
		goodsService.getSocietyPagination(query, model);
		return "/goods/society/xqst";
	}

	@RequestMapping(value = "/list")
	public String showSocietyList(UserAgent user, @ModelAttribute("query") SocityClubQuery query,
			 Model model) {
		query.setPageSize(6);

		
		query.setIsDelete(CommonDefine.IS_DELETE_NO);
		
		goodsService.getSocietyPagination(query, model);
		return "/goods/society/list";
	}

	@RequestMapping(value = "/iframeList")
	public String showSocietyList2(UserAgent user, @ModelAttribute("query") GoodsQuery query,
			@ModelAttribute("cateQuery") CategoryQuery cateQuery, Model model) {
		query.setPageSize(6);

		if (user != null) {
			query.setBuildingId(user.getBuildingId());
		} else {
			query.setBuildingId(0L);
		}
		query.setType(EnumGoodsType.SOCIETY.getCode());
		goodsService.getPagination(query, model);
		return "/goods/society/iframeList";
	}

	// @RequestMapping(value = "/list")
	// public String showCurrentPoll2(
	// @ModelAttribute("query") GoodsQuery query,
	// @ModelAttribute("cateQuery") CategoryQuery cateQuery,
	// Model model,UserAgent user) {
	//
	// cateQuery.setParentId(684L);
	// cateQuery.setType(EnumGoodsType.SOCIETY.getCode());
	// List<Category> lst = cateService.getParentCategory(cateQuery);
	// model.addAttribute("parentList", lst);
	//
	//
	// List<Category> lst1 = cateService.getChildCategoryById(cateQuery);
	// model.addAttribute("categoryList", lst1);
	//
	//
	// //query.setCategoryId(681L);
	// query.setBuildingId(5l);
	// query.setType(EnumGoodsType.SOCIETY.getCode());
	// System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaa"+EnumGoodsType.SOCIETY.getCode());
	// goodsService.getPagination(query, model);
	// return "/goods/society/list";
	// }

	// @RequestMapping(value = "/listCategory")
	// public String getCategory(@RequestParam(value="id", required=false)
	// String id,
	// @ModelAttribute("query") GoodsQuery query,
	// @ModelAttribute("cateQuery") CategoryQuery cateQuery,
	// Model model) {
	//
	// cateQuery.setType(EnumGoodsType.PROVIDER.getCode());
	// List<Category> lst = cateService.getParentCategory(cateQuery);
	// model.addAttribute("parentList", lst);
	//
	// cateQuery.setParentId(Long.parseLong(id));
	// List<Category> lst1 = cateService.getChildCategoryById(cateQuery);
	// model.addAttribute("categoryList", lst1);
	//
	// if(lst1.size()>0){
	// query.setCategoryId(lst1.get(0).getId());
	// } else query.setCategoryId(681L);
	// query.setType(EnumGoodsType.PROVIDER.getCode());
	// query.setBuildingId(2L);
	// goodsService.getPagination(query);
	// return "/goods/provider/index";
	// }
	// @RequestMapping(value = "/listProvider")
	// public String getListProvider(@RequestParam(value="id", required=false)
	// String id,
	// @RequestParam(value="parentId", required=false) String parentId,
	// @ModelAttribute("query") GoodsQuery query,
	// @ModelAttribute("cateQuery") CategoryQuery cateQuery,
	// Model model) {
	//
	// cateQuery.setType(EnumGoodsType.PROVIDER.getCode());
	// List<Category> lst = cateService.getParentCategory(cateQuery);
	// model.addAttribute("parentList", lst);
	//
	// //String parentId = (String) request.getParameter("parentId");
	// cateQuery.setParentId(Long.parseLong(parentId));
	// List<Category> lst1 = cateService.getChildCategoryById(cateQuery);
	// model.addAttribute("categoryList", lst1);
	//
	// //String id = (String) request.getParameter("id");
	// query.setCategoryId(Long.parseLong(id));
	// query.setType(EnumGoodsType.PROVIDER.getCode());
	// query.setBuildingId(2L);
	// goodsService.getPagination(query);
	// return "/goods/provider/list";
	// }
	//
	// @RequestMapping(value = "/view")
	// public String showCurrentPoll(@RequestParam("id") Long id, Model model) {
	//
	//// Goods goods = service.getById(id);
	//// model.addAttribute("goods", goods);
	// return "/goods/provider/view";
	// }

}
