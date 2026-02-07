package com.javaproject.movieticket.service;

import com.javaproject.movieticket.entity.SeatRecord;
import com.javaproject.movieticket.vo.seatRecord.AddSeatRecordReq;

import java.util.List;

/**
 * seatRecord 的 Service 层
 */
public interface SeatRecordService {
    /**
     * 添加选座记录
     * @param addSeatRecordReq
     */
    void addSeatRecord(AddSeatRecordReq addSeatRecordReq);
    
    /**
     * 批量获取选座列表
     * @return
     */
    List<SeatRecord> seatRecordList();
    
    /**
     * 删除选座记录
     * @param id
     */
    void deleteSeatRecord(Integer id);
    
    /**
     * 通过 id 查找选座记录
     * @param id
     * @return
     */
    SeatRecord findSeatRecordBySeatId(Integer id);
}
