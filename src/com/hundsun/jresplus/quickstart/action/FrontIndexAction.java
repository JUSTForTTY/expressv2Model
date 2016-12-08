package com.hundsun.jresplus.quickstart.action;

import com.hundsun.jresplus.common.util.StringUtil;
import com.hundsun.jresplus.quickstart.biz.po.Building;
import com.hundsun.jresplus.quickstart.biz.po.Category;
import com.hundsun.jresplus.quickstart.biz.po.Codemaster;
import com.hundsun.jresplus.quickstart.biz.po.DsVisitor;
import com.hundsun.jresplus.quickstart.biz.po.News;
import com.hundsun.jresplus.quickstart.biz.po.User;
import com.hundsun.jresplus.quickstart.biz.query.NewsQuery;
import com.hundsun.jresplus.quickstart.biz.query.NormalGoodsQuery;
import com.hundsun.jresplus.quickstart.biz.service.BuildingService;
import com.hundsun.jresplus.quickstart.biz.service.ChannelService;
import com.hundsun.jresplus.quickstart.biz.service.GoodsService;
import com.hundsun.jresplus.quickstart.biz.service.NewsService;
import com.hundsun.jresplus.quickstart.biz.service.UserService;
import com.hundsun.jresplus.quickstart.common.UserAgent;
import com.hundsun.jresplus.quickstart.enums.EnumGoodsType;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FrontIndexAction
{

  @Autowired
  private ChannelService channelService;

  @Autowired
  private NewsService newsService;

  @Autowired
  private BuildingService buildingService;
  
  @Autowired
  private UserService userService;
  
  @Autowired
  private GoodsService    goodsService;
  
  private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMddHHmm");

  @RequestMapping({"index"})
  public String embed(UserAgent user, Model model, HttpServletRequest request,@ModelAttribute("query") NormalGoodsQuery query)
  {
	  StringBuffer url = request.getRequestURL();  
		String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append("/").toString();  

    System.out.println("域名" + tempContextUrl);

    Long buildingId = Long.valueOf(0L);
    String status = "0";
    List lst = this.buildingService.getBuildingListByYuming(tempContextUrl);
    if (lst.size() > 0)
    {
      buildingId = ((Building)lst.get(0)).getId();
      model.addAttribute("building", lst.get(0));
    }
    System.out.println("域名访问后楼宇id" + buildingId);

    if ((user != null) && (user.getBuildingId() != null))
    {
      buildingId = user.getBuildingId();
      status = "1";
    }

    List channelList = this.channelService.getIndexChannelBlock(buildingId, status);
    System.out.println("首页" + channelList.size());
    model.addAttribute("channelList", channelList);
    model.addAttribute("zongheNews", getzongheNews(user, request));
    model.addAttribute("wuyeokNews", getwuyeokNews(user, request));
    model.addAttribute("downloadNews", getdownloadNews(user, request));
    model.addAttribute("gonggaoNews", getgonggaoNews(user, request));
    model.addAttribute("newsList", getpicturesNews(user, request));

    
    
    //查询商品信息
    
    query.addType(EnumGoodsType.NORMAL.getCode());
    query.addType(EnumGoodsType.SALE.getCode());
    query.setPageSize(8);
    Long categoryId = query.getCategoryId();
    String name = query.getName();
    // 如果有name字段填写就清空类目
    if (StringUtil.isNotBlank(name)) {
        categoryId = null;
        query.setCategoryId(categoryId);
    }
    
    query.setBuildingId(buildingId);
    goodsService.getPagination(query, model);
   
    
    if(buildingId.equals("7")||buildingId==7L){
		System.out.println("跳转到8070");
		return  "redirect:" + "http://lt.wuyeok.com:8070/index.htm";
	}
	if(buildingId.equals("6")||buildingId==6L){
		System.out.println("跳转到8060");
		return  "redirect:" + "http://shy.wuyeok.com:8060/index.htm";
	}
	
	else{
	return "index";
	}
    
   
  }

  @RequestMapping({"newsDetail"})
  public String newsDetail(UserAgent user, ModelMap model, HttpServletRequest request, @RequestParam("id") Long id)
  {
    Long buildingId = Long.valueOf(0L);
    StringBuffer url = request.getRequestURL();  
	String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append("/").toString();  
    String status = "0";
    List lst = this.buildingService.getBuildingListByYuming(tempContextUrl);
    if (lst.size() > 0)
    {
      buildingId = ((Building)lst.get(0)).getId();
    }
    if ((user != null) && (user.getBuildingId() != null))
    {
      buildingId = user.getBuildingId();
    }

    News newsBean = this.newsService.getNewsById(id);
    model.addAttribute("newsbean", newsBean);

    model.addAttribute("newsTypes", getNewsTypes(user, request));

    System.out.println(newsBean.getId());

    System.out.println(newsBean.getId());
    newsBean.setBuildingId(buildingId);

    model.addAttribute("previousNews", this.newsService.getPreviousNews(newsBean));

    model.addAttribute("nextNews", this.newsService.getNextNews(newsBean));

    return "news/newsDetail";
  }

  @RequestMapping({"newsList"})
  public String newsList(UserAgent user, ModelMap model, HttpServletRequest request, @ModelAttribute("query") NewsQuery query)
  {
    String type = request.getParameter("type");
    Long buildingId = Long.valueOf(0L);
    StringBuffer url = request.getRequestURL();  
	String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append("/").toString();  
    String status = "0";
    List lst = this.buildingService.getBuildingListByYuming(tempContextUrl);
    if (lst.size() > 0)
    {
      buildingId = ((Building)lst.get(0)).getId();
    }
    if ((user != null) && (user.getBuildingId() != null))
    {
      buildingId = user.getBuildingId();
    }

    if ((type == null) || (type == null))
    {
      type = "1";
    }

    model.addAttribute("newsTypes", getNewsTypes(user, request));

    query.setPageSize(Integer.valueOf(12));
    query.setProviderId(3854);;
    query.setType(type);
    this.newsService.getNewsList(query);

    if (query.getType().equals("5")) {
      query.setPageSize(Integer.valueOf(6));
      System.out.println("你好，类型啊");
      System.out.println("类型" + query.getType());
      return "redirect:/goods/houseList/iframeList.htm";
    }
    return "news/newsList";
  }

  @RequestMapping({"/goods/houseList/iframeList"})
  public String houseList2(UserAgent user, ModelMap model, HttpServletRequest request, @ModelAttribute("query") NewsQuery query)
  {
    query.setPageSize(Integer.valueOf(6));
    System.out.println("2222222222======" + query.getCurrentPage() + "你好11112233");
    model.addAttribute("houseNews", getHouseNews(user, request));

    return "goods/house/houseList";
  }

  @RequestMapping({"/goods/news/iframeList"})
  public String newsFrame(UserAgent user, ModelMap model, HttpServletRequest request, @ModelAttribute("query") NewsQuery query)
  {
    model.addAttribute("newsTypes", getNewsTypes(user, request));

    model.addAttribute("zongheNews", getzongheNews(user, request));
    model.addAttribute("wuyeokNews", getwuyeokNews(user, request));
    model.addAttribute("downloadNews", getdownloadNews(user, request));
    model.addAttribute("gonggaoNews", getgonggaoNews(user, request));

    return "block/lasterinformation";
  }

  @RequestMapping({"/goods/houseNews/iframeList"})
  public String houseFrame(UserAgent user, ModelMap model, HttpServletRequest request, @ModelAttribute("query") NewsQuery query)
  {
    model.addAttribute("houseNews", getHouseNews(user, request));

    return "block/house";
  }

  @RequestMapping({"/goods/fastNews/iframeList"})
  public String fastFrame(UserAgent user, ModelMap model, HttpServletRequest request, @ModelAttribute("query") NewsQuery query)
  {
    model.addAttribute("fastNews", getQuickNews(user, request));

    return "block/fasttrack";
  }

  public List<News> getpicturesNews(UserAgent user, HttpServletRequest request)
  {
    Long buildingId = Long.valueOf(0L);
    StringBuffer url = request.getRequestURL();  
	String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append("/").toString();  
    String status = "0";
    List lst = this.buildingService.getBuildingListByYuming(tempContextUrl);
    if (lst.size() > 0)
    {
      buildingId = ((Building)lst.get(0)).getId();
    }
    if ((user != null) && (user.getBuildingId() != null))
    {
      buildingId = user.getBuildingId();
      status = "1";
    }

    return this.newsService.getpicturesNewsList(buildingId, status);
  }

  public List<Codemaster> getNewsTypes(UserAgent user, HttpServletRequest request)
  {
    Long buildingId = Long.valueOf(0L);
    StringBuffer url = request.getRequestURL();  
	String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append("/").toString();  
    String status = "0";
    List lst = this.buildingService.getBuildingListByYuming(tempContextUrl);
    if (lst.size() > 0)
    {
      buildingId = ((Building)lst.get(0)).getId();
    }
    if ((user != null) && (user.getBuildingId() != null))
    {
      buildingId = user.getBuildingId();
    }

    return this.newsService.getNewsType(buildingId);
  }

  public List<News> getzongheNews(UserAgent user, HttpServletRequest request)
  {
    Long buildingId = Long.valueOf(0L);
    StringBuffer url = request.getRequestURL();  
	String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append("/").toString();  
    String status = "0";
    List lst = this.buildingService.getBuildingListByYuming(tempContextUrl);
    if (lst.size() > 0)
    {
      buildingId = ((Building)lst.get(0)).getId();
    }
    if ((user != null) && (user.getBuildingId() != null))
    {
      buildingId = user.getBuildingId();
    }

    return this.newsService.getNewsListByType(3854, "2");
  }

  public List<News> getwuyeokNews(UserAgent user, HttpServletRequest request) {
    Long buildingId = Long.valueOf(0L);
    StringBuffer url = request.getRequestURL();  
	String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append("/").toString();  
    String status = "0";
    List lst = this.buildingService.getBuildingListByYuming(tempContextUrl);
    if (lst.size() > 0)
    {
      buildingId = ((Building)lst.get(0)).getId();
    }
    if ((user != null) && (user.getBuildingId() != null))
    {
      buildingId = user.getBuildingId();
    }

    return this.newsService.getNewsListByType(3854, "3");
  }

  public List<News> getdownloadNews(UserAgent user, HttpServletRequest request) {
    Long buildingId = Long.valueOf(0L);
    StringBuffer url = request.getRequestURL();  
	String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append("/").toString();  
    String status = "0";
    List lst = this.buildingService.getBuildingListByYuming(tempContextUrl);
    if (lst.size() > 0)
    {
      buildingId = ((Building)lst.get(0)).getId();
    }
    if ((user != null) && (user.getBuildingId() != null))
    {
      buildingId = user.getBuildingId();
    }

    return this.newsService.getNewsListByType(3854, "1");
  }

  public List<News> getgonggaoNews(UserAgent user, HttpServletRequest request) {
    Long buildingId = Long.valueOf(0L);
    StringBuffer url = request.getRequestURL();  
	String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append("/").toString();  
    String status = "0";
    List lst = this.buildingService.getBuildingListByYuming(tempContextUrl);
    if (lst.size() > 0)
    {
      buildingId = ((Building)lst.get(0)).getId();
    }
    if ((user != null) && (user.getBuildingId() != null))
    {
      buildingId = user.getBuildingId();
    }

    return this.newsService.getNewsListByType(3854, "4");
  }

  public List<News> getHouseNews(UserAgent user, HttpServletRequest request)
  {
    Long buildingId = Long.valueOf(0L);
    StringBuffer url = request.getRequestURL();  
	String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append("/").toString();  
    String status = "0";
    List lst = this.buildingService.getBuildingListByYuming(tempContextUrl);
    if (lst.size() > 0)
    {
      buildingId = ((Building)lst.get(0)).getId();
    }
    if ((user != null) && (user.getBuildingId() != null))
    {
      buildingId = user.getBuildingId();
    }

    return this.newsService.getNewsListByType(3854, "5");
  }

  public List<News> getQuickNews(UserAgent user, HttpServletRequest request)
  {
    Long buildingId = Long.valueOf(0L);
    StringBuffer url = request.getRequestURL();  
	String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append("/").toString();  
    String status = "0";
    List lst = this.buildingService.getBuildingListByYuming(tempContextUrl);
    if (lst.size() > 0)
    {
      buildingId = ((Building)lst.get(0)).getId();
    }
    if ((user != null) && (user.getBuildingId() != null))
    {
      buildingId = user.getBuildingId();
    }

    return this.newsService.getNewsListByType(3854, "6");
  }

  @RequestMapping(value={"headbar"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String headbar(UserAgent user, ModelMap model, HttpServletRequest request)
  {
    Long buildingId = Long.valueOf(0L);
    StringBuffer url = request.getRequestURL();  
	String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append("/").toString();  
    String status = "0";
    List lst = this.buildingService.getBuildingListByYuming(tempContextUrl);
    if (lst.size() > 0)
    {
      buildingId = ((Building)lst.get(0)).getId();
      model.addAttribute("building", lst.get(0));
    }

    System.out.println("域名访问后楼宇id" + buildingId);
    if ((user != null) && (user.getBuildingId() != null))
    {
      buildingId = user.getBuildingId();
      status = "1";
    }

    System.out.println("kaishi");

    List channelList = this.channelService.getIndexChannelList(buildingId, status);
    System.out.println("菜单" + channelList.size());
    model.addAttribute("channelList", channelList);
    return "contain/navigation";
  }

  @RequestMapping(value={"headcolor"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String head(UserAgent user, ModelMap model, HttpServletRequest request)
  {
    Long buildingId = Long.valueOf(0L);
    StringBuffer url = request.getRequestURL();  
	String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append("/").toString();  
    String status = "0";
    List lst = this.buildingService.getBuildingListByYuming(tempContextUrl);
    if (lst.size() > 0)
    {
      buildingId = ((Building)lst.get(0)).getId();
      model.addAttribute("building", lst.get(0));
    }
    System.out.println("域名访问后楼宇id" + buildingId);
    if ((user != null) && (user.getBuildingId() != null))
    {
      buildingId = user.getBuildingId();
      status = "1";
    }

    List channelList2 = this.channelService.getIndexChannelList(buildingId, status);
    System.out.println("图标" + channelList2.size());
    model.addAttribute("channelList2", channelList2);

    List channelColor = this.channelService.getIndexChannelColor(buildingId, status);
    System.out.println("颜色" + channelColor.size());
    model.addAttribute("channelColor", channelColor);
    return "contain/headbar";
  }

  @RequestMapping(value={"headbar"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String headbarGET(UserAgent user, ModelMap model, HttpServletRequest request) {
    Long buildingId = Long.valueOf(0L);
    StringBuffer url = request.getRequestURL();  
	String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append("/").toString();  
    String status = "0";
    List lst = this.buildingService.getBuildingListByYuming(tempContextUrl);
    if (lst.size() > 0)
    {
      buildingId = ((Building)lst.get(0)).getId();
      model.addAttribute("building", lst.get(0));
    }
    System.out.println("域名访问后楼宇id" + buildingId);
    if ((user != null) && (user.getBuildingId() != null))
    {
      buildingId = user.getBuildingId();
      status = "1";
    }
    System.out.println("kaishi");

    List channelList = this.channelService.getIndexChannelList(buildingId, status);
    System.out.println("菜单" + channelList.size());
    model.addAttribute("channelList", channelList);
    return "contain/navigation";
  }

  @RequestMapping(value={"headcolor"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String headGET(UserAgent user, ModelMap model, HttpServletRequest request)
  {
    Long buildingId = Long.valueOf(0L);
    StringBuffer url = request.getRequestURL();  
	String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append("/").toString();  
    String status = "0";
    List lst = this.buildingService.getBuildingListByYuming(tempContextUrl);
    if (lst.size() > 0)
    {
      buildingId = ((Building)lst.get(0)).getId();
      model.addAttribute("building", lst.get(0));
    }
    System.out.println("域名访问后楼宇id" + buildingId);
    if ((user != null) && (user.getBuildingId() != null))
    {
      buildingId = user.getBuildingId();
      status = "1";
    }

    List channelList2 = this.channelService.getIndexChannelList(buildingId, status);
    System.out.println("图标" + channelList2.size());
    model.addAttribute("channelList2", channelList2);

    List channelColor = this.channelService.getIndexChannelColor(buildingId, status);
    System.out.println("颜色" + channelColor.size());
    model.addAttribute("channelColor", channelColor);
    return "contain/headbar";
  }
  
  
  @RequestMapping({"/goods/contact"})
  public String contact( ModelMap model,DsVisitor visitor,UserAgent user)
  {
	  
	  visitor.setMember_id(visitor.getMember_id());
	  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd H:m:s");

	  
	  visitor.setTime((format.format(new Date())));
	  channelService.contactUs(visitor);
	 
	  
	  
	  
    return "/success";
  }
  
  
  
}