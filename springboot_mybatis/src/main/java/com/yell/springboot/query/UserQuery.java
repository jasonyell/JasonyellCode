package com.yell.springboot.query;

/**
 *  分页及条件查询
 */
public class UserQuery {
    /*分页参数*/
    private Integer pageNum = 1;  // 当前页码
    private Integer pageSize = 10; // 每页现实的记录数据

    /* 条件查询的参数 */
    private String userName; // 查询条件：用户名

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
