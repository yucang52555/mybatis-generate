/*
 * @(#) BaseModel.java 2015年6月8日
 * 
 * Copyright (c), 2009 深圳孔方兄金融信息服务有限公司（Shenzhen kfxiong
 * Financial Information Service Co. Ltd.）
 * 
 * 著作权人保留一切权利，任何使用需经授权。
 */
package com.kfx.xsb.common.model;

/**
 * @author Zhao Hui
 * @2015年6月8日
 */
public abstract class BaseModel {

    private Pageable page;
    
    //查询的起始条数
    private int startIndex;
    
   
    
    public Pageable getPage() {
    	if(null == page){
    		page = new Pageable(1, 10);
    	}
        return page;
    }

    public void setPage(Pageable page) {
        this.page = page;
    }
    
    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }


}
