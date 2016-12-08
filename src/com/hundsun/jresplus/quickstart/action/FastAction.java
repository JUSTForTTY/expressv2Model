package com.hundsun.jresplus.quickstart.action;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hundsun.jresplus.quickstart.biz.po.Fast;
import com.hundsun.jresplus.quickstart.biz.service.FastService;
import com.hundsun.jresplus.quickstart.common.UserAgent;

@Controller
public class FastAction {

	@Autowired
	private FastService fastService;
	
	@RequestMapping(value="/front/list", method = RequestMethod.GET)
	public String queryselect(ModelMap model,UserAgent user){
	//定义buildingId为0，默认为无人登录
		Long buildingId = 0L;
		if (user != null && user.getBuildingId() != null) {
			// 楼宇
			buildingId = user.getBuildingId();
		}
		else {
			buildingId = 0L;
		}
		List<Fast> lst=fastService.getfast(buildingId);
		model.addAttribute("fast",lst);
		//model.addAttribute("");
		return "/front/list";
	
	}
}
		
		
		
		
	

