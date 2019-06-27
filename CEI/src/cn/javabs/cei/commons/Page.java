package cn.javabs.cei.commons;

import java.util.List;

public class Page {
    //条数
    private List records;
    //每页显示条数
    private  int pageSize=3;
    //当前页码
    private int currentPageNum;
    //总页数
    private int totalPage;
    //上一页
    private int prePageNum;
    //下一页
    private int nextPageNum;
    //每页开始记录的索引
    private int startIndex;
    //记录总条数
    private int totalRecords;
    private  String url;

    public  Page(int currentPagenum, int totalRecords){

        this.totalRecords=totalRecords;
        this.currentPageNum=currentPagenum;

        totalPage= totalRecords%pageSize==0?totalRecords/pageSize : totalRecords/pageSize+1;

        startIndex =(currentPageNum-1)*pageSize;
    }
    @Override
    public String toString() {
        return "Page{" +
                "records=" + records +
                ", pageSize=" + pageSize +
                ", currentPageNum=" + currentPageNum +
                ", totalPage=" + totalPage +
                ", prePageNum=" + prePageNum +
                ", nextPageNum=" + nextPageNum +
                ", startIndex=" + startIndex +
                ", totalRecords=" + totalRecords +
                ", url='" + url + '\'' +
                '}';
    }

    public List getRecords() {
        return records;
    }

    public void setRecords(List records) {
        this.records = records;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPageNum() {
        return currentPageNum;
    }

    public void setCurrentPageNum(int currentPageNum) {
        this.currentPageNum = currentPageNum;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPrePageNum() {
        return prePageNum;
    }

    public void setPrePageNum(int prePageNum) {
        this.prePageNum = prePageNum;
    }

    public int getNextPageNum() {
        return nextPageNum;
    }

    public void setNextPageNum(int nextPageNum) {
        this.nextPageNum = nextPageNum;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
