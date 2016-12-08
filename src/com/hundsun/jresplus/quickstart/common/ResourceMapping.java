package com.hundsun.jresplus.quickstart.common;

public class ResourceMapping {

    // Url  
    private String   resourcePath;

    // 角色  
    private String[] recipients = new String[3];

    public String[] getRecipients() {
        return recipients;
    }

    public void setRecipients(String[] recipients) {
        this.recipients = recipients;
    }

    public String getResourcePath() {
        return resourcePath;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

}