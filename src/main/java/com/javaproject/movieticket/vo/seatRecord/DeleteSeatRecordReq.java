package com.javaproject.movieticket.vo.seatRecord;

import lombok.Data;

/**
 * 删除选座记录请求体
 */
@Data
public class DeleteSeatRecordReq {
    
    /**
     * 待删除的id
     */
    private Integer id;
}
