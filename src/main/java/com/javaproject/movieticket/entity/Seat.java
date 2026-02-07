package com.javaproject.movieticket.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 座位
 */
@Data
public class Seat {
    
    /**
     * 座位id
     */
    private Integer id;
    
    /**
     * 座位名称
     */
    private String SeatName;
    
    /**
     * 座位所在行
     */
    private Integer SeatLine;
    
    /**
     * 座位所在列
     */
    private Integer SeatColumn;
    
    /**
     * 座位价格
     */
    private Double SeatPrice;
    
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
