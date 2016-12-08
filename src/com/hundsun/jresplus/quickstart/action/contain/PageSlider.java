package com.hundsun.jresplus.quickstart.action.contain;

import static java.lang.Math.max;
import static java.lang.Math.min;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hundsun.jresplus.common.util.StringUtil;
import com.hundsun.network.common.query.QueryBase;
import com.hundsun.network.common.query.QueryPage;

/**
 * 分页参数传入(两种方式必选其一): put("slider_query",$QueryBase 子类)
 *
 * 缺省分页url使用 $appServer生成url,如需指定,则使用 put('slider_borker',$broker)
 * 如果要指定vm，请put('slider_path',vm路径) 如果要指定浮动窗大小,请put('slider_width',int)，否则使用缺省值
 */
@Controller
public class PageSlider {

    public static final Log logger                        = LogFactory.getLog(PageSlider.class);

    /**
     * 浮动窗大小，应该是奇数为好
     */
    private int             defaultSliderWidth            = 5;

    private String          defaultFrontFormSlider        = "/contain/front_page_slider";

    private String          defaultCenterFormSlider       = "/contain/center_page_slider";

    private String          defaultFrontPageParameterName = "currentPage";

    /**
     * 缺省form提交的方式为post
     */
    private String          defaultFormPageMethod         = "post";

    private Random          random                        = new Random();

    /**
     * 使用form提交进行分页,入参为以下值 .分页url(必需):put('slider_target',$分页提交的url(只包含路径))
     * 如果要指定分页变量名(缺省为"page"),则put('slider_page',$分页变量名称)
     * 如果要指定分页提交为GET方式而不是POST,则put('slider_method','get')
     */
    @RequestMapping("/contain/front_page_slider")
    public ModelAndView frontPage(HttpServletRequest request) throws Exception {
        int totalPage = 0;
        int currentPage = 0;
        QueryPage query = (QueryPage) request.getAttribute("slider_query");
        if (query == null) {
            throw new IllegalArgumentException("not find parameter slider_query");
        }
        totalPage = query.getTotalPage();
        currentPage = query.getCurrentPage();

        if (currentPage == 0) {
            throw new IllegalStateException("current page will be 0?");
        }
        Object temp = null;
        int width = defaultSliderWidth;
        if ((temp = request.getAttribute("slider_width")) != null) {
            try {
                width = Integer.parseInt(temp.toString());
            } catch (NumberFormatException e) {
                logger.error("error then parse slider_width", e);
            }
        }
        List<Integer> grids = getGrids(totalPage, currentPage, width);
        String currentSlider = this.defaultFrontFormSlider;
        if ((temp = request.getAttribute("slider_path")) != null) {
            currentSlider = temp.toString();
        }

        String sliderPage = this.defaultFrontPageParameterName;
        if ((temp = request.getAttribute("slider_page")) != null) {
            sliderPage = temp.toString();
        }

        String sliderTarget = (String) request.getAttribute("slider_target");
        if (sliderTarget == null) {
            throw new IllegalArgumentException("not find parameter slider_target");
        }

        String sliderMethod = (String) request.getAttribute("slider_method");
        if (StringUtil.isBlank(sliderMethod)) {
            sliderMethod = defaultFormPageMethod;
        }

        ModelAndView mv = new ModelAndView(currentSlider, "grids", grids);
        mv.addObject("sliderTotal", totalPage);
        mv.addObject("sliderCurrent", currentPage);
        mv.addObject("sliderNext", currentPage + 1);
        mv.addObject("sliderPrev", currentPage - 1);
        mv.addObject("sliderQuery", query);
        mv.addObject("sliderPage", sliderPage);
        mv.addObject("sliderTarget", sliderTarget);
        mv.addObject("sliderRandom", getFormId());
        mv.addObject("sliderMethod", sliderMethod);
        return mv;
    }

    /**
     * 使用GET方式,也就是普通超连接方式分页,入参为. 必需:put('slider_builder',$PagingURLBuilder)
     *
     */
    @RequestMapping("/contain/center_page_slider")
    public ModelAndView centerPage(HttpServletRequest request) throws Exception {
        int totalPage = 0;
        int currentPage = 0;
        QueryPage query = (QueryPage) request.getAttribute("slider_query");
        if (query == null) {
            throw new IllegalArgumentException("not find parameter slider_query");
        }
        totalPage = query.getTotalPage();
        currentPage = query.getCurrentPage();

        if (currentPage == 0) {
            throw new IllegalStateException("current page will be 0?");
        }
        Object temp = null;
        int width = defaultSliderWidth;
        if ((temp = request.getAttribute("slider_width")) != null) {
            try {
                width = Integer.parseInt(temp.toString());
            } catch (NumberFormatException e) {
                logger.error("error then parse slider_width", e);
            }
        }
        List<Integer> grids = getGrids(totalPage, currentPage, width);
        String currentSlider = this.defaultCenterFormSlider;
        if ((temp = request.getAttribute("slider_path")) != null) {
            currentSlider = temp.toString();
        }

        String sliderPage = this.defaultFrontPageParameterName;
        if ((temp = request.getAttribute("slider_page")) != null) {
            sliderPage = temp.toString();
        }

        String sliderTarget = (String) request.getAttribute("slider_target");
        if (sliderTarget == null) {
            throw new IllegalArgumentException("not find parameter slider_target");
        }

        String sliderMethod = (String) request.getAttribute("slider_method");
        if (StringUtil.isBlank(sliderMethod)) {
            sliderMethod = defaultCenterFormSlider;
        }

        ModelAndView mv = new ModelAndView(currentSlider, "grids", grids);
        mv.addObject("sliderTotal", totalPage);
        mv.addObject("sliderCurrent", currentPage);
        mv.addObject("sliderNext", currentPage + 1);
        mv.addObject("sliderPrev", currentPage - 1);
        mv.addObject("sliderQuery", query);
        mv.addObject("sliderPage", sliderPage);
        mv.addObject("sliderTarget", sliderTarget);
        mv.addObject("sliderRandom", getFormId());
        mv.addObject("sliderMethod", sliderMethod);
        return mv;
    }

    protected static List<Integer> getGrids(int totalPage, int currentPage, int width) {
        int widthHalf = width / 2;
        List<Integer> grids = new ArrayList<Integer>();
        for (int i = 1; i <= min(width, currentPage); i++) {
            grids.add(i);
        }
        if (currentPage - grids.size() > widthHalf) {
            grids.add(0);
        }
        for (int i = max(currentPage - widthHalf, grids.size() + 1); i <= min(currentPage
                                                                              + widthHalf,
            totalPage); i++) {
            grids.add(i);
        }
        if (totalPage - grids.get(grids.size() - 1) > width) {
            grids.add(0);
        }
        for (int i = max(totalPage - width + 1, grids.get(grids.size() - 1) + 1); i <= totalPage; i++) {
            grids.add(i);
        }
        return grids;
    }

    private String getFormId() {
        return Integer.toString(random.nextInt(999));
    }

    public static interface PagingURLBuilder {
        public String build(QueryBase query, int page);
    }
}
