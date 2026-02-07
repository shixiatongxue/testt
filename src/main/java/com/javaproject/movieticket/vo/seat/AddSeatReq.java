package com.javaproject.movieticket.vo.seat;

import lombok.Data;

/**
 * 添加座位请求体
 */
@Data
public class AddSeatReq {
    
    /**
     * 座位名称
     */
    private String seatName;
    
    /**
     * 座位所在行
     */
    private Integer seatLine;
    
    /**
     * 座位所在列
     */
    private Integer seatColumn;
    
    /**
     * 座位价格
     */
    private Double seatPrice;
}
