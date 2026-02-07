package com.javaproject.movieticket.vo.seat;

import lombok.Data;

/**
 * 删除座位请求体
 */
@Data
public class DeleteSeatReq {
    
    /**
     * 待删除的id
     */
    private Integer id;
}
