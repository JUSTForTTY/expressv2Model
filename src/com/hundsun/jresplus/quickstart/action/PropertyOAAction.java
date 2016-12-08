package com.hundsun.jresplus.quickstart.action;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hundsun.jresplus.quickstart.biz.po.PropertyNote;
import com.hundsun.jresplus.quickstart.biz.service.BuildingService;
import com.hundsun.jresplus.quickstart.common.UserAgent;
import com.hundsun.jresplus.quickstart.utils.Md5Encrypt;

@Controller
public class PropertyOAAction {

    @Value("${md5.key}")
    private String                        key;

    @Value("${property.server.url}")
    private String                        serverUrl;

    @Autowired
    private BuildingService               buildingService;

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMddHHmm");

    @RequestMapping(value = "/property/embed", method = RequestMethod.GET)
    public String embed(UserAgent user, ModelMap model) {
        if (user != null) {
            String userId = user.getId().toString();
            String buildingId = user.getBuildingId().toString();
            String sign1 = Md5Encrypt.md5(userId + buildingId + key
                                          + DATE_FORMAT.format(new Date()));// 按时间格式进行加密
            long time = new Date().getTime(); // 当前时间戳
            String timeMin = new BigDecimal(String.valueOf(time)).divide(new BigDecimal("60"),
                BigDecimal.ROUND_DOWN).toPlainString();// 当前时间戳/60=分钟的时间戳
            String sign2 = Md5Encrypt.md5(userId + buildingId + key + timeMin);// 按时间格式进行加密
            String url = serverUrl + "?id=" + userId + "&buildingId=" + buildingId + "&sign="
                         + sign1;
            model.addAttribute("url", url);

            PropertyNote note = buildingService.getPropertyNoteByBuildingId(user.getBuildingId());
            model.addAttribute("note", note);
        }
        return "property/embed";
    }
}
