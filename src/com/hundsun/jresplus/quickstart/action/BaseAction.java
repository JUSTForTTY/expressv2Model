package com.hundsun.jresplus.quickstart.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import com.hundsun.jresplus.common.util.StringUtil;
import com.hundsun.jresplus.quickstart.biz.po.Building;
import com.hundsun.jresplus.quickstart.common.CommonDefine;
import com.hundsun.jresplus.quickstart.common.UserAgent;

public class BaseAction {

    protected final Log _log = LogFactory.getLog(this.getClass());

    protected String success(Model model, String message) {
        model.addAttribute("message", message);
        return "success";
    }

    protected String success(ModelMap model, String message) {
        model.addAttribute("message", message);
        return "success";
    }

    protected String error(Model model, String message) {
        model.addAttribute("message", message);
        return "error";
    }

    protected String error(ModelMap model, String message) {
        model.addAttribute("message", message);
        return "error";
    }

    /**
     * 获取用于查询的楼宇id
     * @param userAgent
     * @param request
     * @param cookyjar
     * @return
     */
    protected String[] getQueryBuilding(UserAgent userAgent, HttpServletRequest request) {
        String buildingStr = Building.allBuildings + "";
        if (userAgent != null && StringUtil.isNotBlank(userAgent.getUserName())) {
            if (userAgent.getBuildingId() != null && userAgent.getBuildingId() != 0L) {
                buildingStr = buildingStr + "," + userAgent.getBuildingId().toString();
            }
        } else {
            String requestBuildingId = request.getParameter(CommonDefine.REQ_BUILDING);
            if (requestBuildingId != null) {
                String buildingId = (String) requestBuildingId;
                if (StringUtils.isNumeric(buildingId)) {
                    buildingStr = buildingStr + "," + buildingId;
                }
            }
        }
        String[] building = buildingStr.split(",");
        return building;
    }
}
