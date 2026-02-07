package com.javaproject.movieticket.vo.seatRecord;

import lombok.Data;

/**
 * 添加选座记录请求体
 */
@Data
public class AddSeatRecordReq {
    
    /**
     * 座位 id
     */
    private Integer seatId;
    
    /**
     * 选座人 id
     */
    private Integer userId;
}
