package com.kfx.xsb.common.model;

public class Pageable {
    
    // 当前页，默认为第一页
    private int curPage = 1;
    // 每页记录数
    private int pageSize = 10;
    // 总页数
    private int pageCount;
    // 总记录条数
    private int totalCount;

    public Pageable() {
    	setCurPage(1);
        setPageSize(10);
    }

    public Pageable(int curPage, int pageSize) {
        setCurPage(curPage);
        setPageSize(pageSize);
    }

    /**
     * 获取当前页，默认第一页
     */
    public int getCurPage() {
        return curPage;
    }

    /**
     * 设置当前页
     */
    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    /**
     * 获取每页记录数
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 设置每页记录数
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 获取总页数
     */
    public int getPageCount() {
        return pageCount;
    }

    /**
     * 设置总页数
     */
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    /**
     * 获取总记录条数
     * 
     * @return
     */
    public int getTotalCount() {
        return totalCount;
    }

    /**
     * 设置总记录条数
     * 
     * @param totalCount
     */
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pageable [curPage=");
		builder.append(curPage);
		builder.append(", pageSize=");
		builder.append(pageSize);
		builder.append(", pageCount=");
		builder.append(pageCount);
		builder.append(", totalCount=");
		builder.append(totalCount);
		builder.append("]");
		return builder.toString();
	}

   
}
