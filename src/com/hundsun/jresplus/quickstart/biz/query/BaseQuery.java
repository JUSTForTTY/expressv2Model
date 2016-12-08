package com.hundsun.jresplus.quickstart.biz.query;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hundsun.jresplus.common.util.ArrayUtil;
import com.hundsun.network.common.query.QueryBase;
import com.hundsun.network.common.query.QueryPage;

public class BaseQuery extends QueryPage {

    /**
     * UID
     */
    private static final long serialVersionUID = -3631158632931413835L;

    public static final Log   logger           = LogFactory.getLog(QueryBase.class);

    public int getPageFristItem() {
        return super.getPageFristItem() - 1;
    }

    @Override
    public Map<String, String> getParameters() {
        String[] removeProperties = new String[] { "totalCount", "pageSize", "pageNo", "startRow",
                "endRow", "orderStr", "serialVersionUID" };
        Map<String, String> param = new HashMap<String, String>();
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (!ArrayUtil.contains(removeProperties, field.getName())) {
                try {
                    String properyValue = BeanUtils.getProperty(this, field.getName());
                    param.put(field.getName(), properyValue);
                } catch (IllegalAccessException e) {
                    logger.error("copy fildValue error", e);
                } catch (InvocationTargetException e) {
                    logger.error("copy fildValue error", e);
                } catch (NoSuchMethodException e) {
                    logger.error("copy fildValue error", e);
                }
            }
        }
        return param;
    }
}
