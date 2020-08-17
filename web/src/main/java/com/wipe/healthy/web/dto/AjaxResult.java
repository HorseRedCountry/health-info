package com.wipe.healthy.web.dto;


import com.wipe.healty.common.paging.Page;

import java.io.Serializable;

/**
 * 处理ajax返回的结果信息
 * @author wenqiang.luo date:15-9-7
 */
public class AjaxResult implements Serializable {

    private static final long serialVersionUID = 5837409853066710012L;

    /** ajax 交互结果 */
    private boolean success;

    /** 交互描述信息 */
    private String description;

    /** 上次请求url地址 */
    private String lastRequestUrl;

    /** 本次请求url地址 */
    private String currentRequestUrl;

    /** 下次跳转的url地址 */
    private String nextRequestUrl;

    /** 交互数据 */
    private Object data;

    /** 分页模型 */
    private Page page;

    public AjaxResult() {
        this.success = true;
        this.description = "success";
    }

    public AjaxResult(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLastRequestUrl() {
        return lastRequestUrl;
    }

    public void setLastRequestUrl(String lastRequestUrl) {
        this.lastRequestUrl = lastRequestUrl;
    }

    public String getCurrentRequestUrl() {
        return currentRequestUrl;
    }

    public void setCurrentRequestUrl(String currentRequestUrl) {
        this.currentRequestUrl = currentRequestUrl;
    }

    public String getNextRequestUrl() {
        return nextRequestUrl;
    }

    public void setNextRequestUrl(String nextRequestUrl) {
        this.nextRequestUrl = nextRequestUrl;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
