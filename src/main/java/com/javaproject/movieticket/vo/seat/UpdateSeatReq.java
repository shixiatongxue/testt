package com.javaproject.movieticket.vo.seat;

import lombok.Data;

/**
 * 更新座位请求体
 */
@Data
public class UpdateSeatReq {
    /**
     * 座位id
     */
    private Integer id;
    
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
