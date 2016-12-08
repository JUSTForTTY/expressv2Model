package com.hundsun.jresplus.quickstart.biz.service.impl;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.hundsun.jresplus.quickstart.biz.service.CommonService;

@Service("commonService")
public class CommonServiceImpl implements CommonService{
  
  private Gson gson;
  
  public CommonServiceImpl(){
    this.gson = new Gson();
  }

  @Override
  public String toJson(Object object) {
    return this.gson.toJson(object);
  }

  @Override
  public <T> T fromJson(String json, Class<T> classOfT) {
    return this.gson.fromJson(json, classOfT);
  }

}
