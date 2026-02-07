package com.javaproject.movieticket.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SeatRecord {
    
    /**
     * 选座记录 id
     */
    private Integer id;
    
    /**
     * 所选座位 id
     */
    private Integer seatId;
    
    /**
     * 选座人 id
     */
    private Integer userId;
    
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
