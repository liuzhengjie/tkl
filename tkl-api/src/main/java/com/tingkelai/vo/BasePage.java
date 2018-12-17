package com.tingkelai.vo;

import io.swagger.annotations.ApiModelProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * 基本分页信息：当前页，每页显示数量
 */
public class BasePage<VO> {

    /** 当前页 */
    @ApiModelProperty(value = "查询页，默认1")
    private int page = 1;

    /** 每页显示数量 */
    @ApiModelProperty(value = "每页显示数量，默认10")
    private int size = 10;

    /** 总数量 */
    @ApiModelProperty(hidden = true)
    private long total;

    /** 总页数 */
    @ApiModelProperty(hidden = true)
    private long totalPages;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }

    public Map<String, Object> toMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("page", page);
        map.put("size", size);
        map.put("total", total);
        map.put("totalPages", totalPages);
        return map;
    }
}
