package com.hundsun.jresplus.quickstart.biz.bo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;

/**
 * 业务处理结果类
 * @author chengy
 */
public class ServiceResult extends BaseDomain {

    private static final long   serialVersionUID = 9046960841766279618L;

    private Map<String, String> messageMap       = new LinkedHashMap<String, String>();

    private Type                type             = Type.NORMAL;

    private Object              resultObject;

    public static enum Type {
        NORMAL, ERROR, SUCCESS;
    }

    public ServiceResult() {
        this(null, Type.NORMAL, null);
    }

    public ServiceResult(Type type) {
        this(null, type, null);
    }

    public ServiceResult(Object resultObject) {
        this(null, null, resultObject);
    }

    public ServiceResult(Map<String, String> messages) {
        this(messages, null, null);
    }

    public ServiceResult(Map<String, String> messages, Type type) {
        this(messages, type, null);
    }

    public ServiceResult(Map<String, String> messages, Type type, Object resultObject) {
        if (messages != null && !messages.isEmpty()) {
            this.messageMap = messages;
        }
        if (type != null) {
            this.type = type;
        }
        this.resultObject = resultObject;
    }

    public boolean isError() {
        return Type.ERROR.equals(this.type);
    }

    public void addMessage(String message) {
        if (StringUtils.isNotBlank(message)) {
            this.messageMap.put(String.valueOf(message.hashCode()), message);
        }
    }

    public void addMessage(List<String> message) {
        if (message != null && !message.isEmpty()) {
            for (String msg : message) {
                this.messageMap.put(String.valueOf(msg.hashCode()), msg);
            }
        }
    }

    public void addMessage(String code, String message) {
        if (StringUtils.isNotBlank(code) && StringUtils.isNotBlank(message)) {
            this.messageMap.put(code, message);
        }
    }

    public void addMessage(Map<String, String> message) {
        if (message != null && !message.isEmpty()) {
            for (Entry<String, String> msg : message.entrySet()) {
                this.messageMap.put(msg.getKey(), msg.getValue());
            }
        }
    }

    public String getMessage() {
        if (this.messageMap != null && !this.messageMap.isEmpty()) {
            return this.messageMap.values().toArray()[0].toString();
        }
        return null;
    }

    public List<String> getMessages() {
        List<String> messageList = new ArrayList<String>();
        if (this.messageMap != null && !this.messageMap.isEmpty()) {
            for (Entry<String, String> message : this.messageMap.entrySet()) {
                messageList.add(message.getValue());
            }
        }
        return messageList;
    }

    public List<String> getCodes() {
        List<String> codeList = new ArrayList<String>();
        if (this.messageMap != null && !this.messageMap.isEmpty()) {
            for (Entry<String, String> message : this.messageMap.entrySet()) {
                codeList.add(message.getKey());
            }
        }
        return codeList;
    }

    public Map<String, String> getMessageMap() {
        return Collections.unmodifiableMap(messageMap);
    }

    public Object getResultObject() {
        return resultObject;
    }

}
