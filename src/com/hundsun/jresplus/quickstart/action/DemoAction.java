package com.hundsun.jresplus.quickstart.action;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hundsun.jresplus.common.util.DateUtil;

@Controller
@RequestMapping("/demo")
public class DemoAction {
	
	@RequestMapping("/view")
	public void view(Integer nums,ModelMap model){
		if(nums!=null){
			model.put("nums", nums);
		}else{
			model.put("nums", 20);
		}
	}
	@RequestMapping("/bpView")
	public void bpview(Integer nums,ModelMap model){
		if(nums!=null){
			model.put("nums", nums);
		}else{
			model.put("nums", 20);
		}
	}
	@RequestMapping("/orderBpView")
	public void orderBpview(Integer nums,ModelMap model){
		if(nums!=null){
			model.put("nums", nums);
		}else{
			model.put("nums", 20);
		}
	}
	@RequestMapping("/staticView")
	public void staticview(Integer nums,ModelMap model){
		if(nums!=null){
			model.put("nums", nums);
		}else{
			model.put("nums", 20);
		}
	}
	@RequestMapping("/subView")
	public void subView(Integer num,ModelMap model){
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {

		}
		long time=System.currentTimeMillis();
		model.put("num", num);
		model.put("time", DateUtil.convertDateToString("hh:mm:ss", new Date(time)));
	}
}
