package com.hundsun.jresplus.quickstart.biz.service;

public interface CommonService {
   /**
    * to Json 转码
    * @param object
    * @return
    */
    String toJson(Object object);
    
    /**
     * Json 转 object<T>
     * @param json
     * @param classOfT
     * @return
     */
    public <T> T fromJson(String json, Class<T> classOfT);
}
