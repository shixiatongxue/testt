package com.javaproject.movieticket.service.impl;

import com.javaproject.movieticket.entity.SeatRecord;
import com.javaproject.movieticket.mapper.SeatRecordMapper;
import com.javaproject.movieticket.service.SeatRecordService;
import com.javaproject.movieticket.vo.seatRecord.AddSeatRecordReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * 选座记录 Service 层实现类
 */
@Slf4j
@Service
public class SeatRecordServiceImpl implements SeatRecordService {

    @Autowired
    private SeatRecordMapper seatRecordMapper;
    
    /**
     * 添加选座记录（去重 + 校验）
     * @param addSeatRecordReq
     */
    @Override
    public void addSeatRecord(AddSeatRecordReq addSeatRecordReq) {
        seatRecordMapper.addSeatRecord(addSeatRecordReq);
        log.info("添加选座记录成功: {}", addSeatRecordReq);
    }
    
    /**
     * 批量获取选座列表
     * @return
     */
    @Override
    public List<SeatRecord> seatRecordList() {
        return seatRecordMapper.seatRecordList();
    }
    
    /**
     * 删除选座记录（校验ID）
     * @param id 原因ID
     */
    @Override
    public void deleteSeatRecord(Integer id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("非法座位ID");
        }
        
        int rows = seatRecordMapper.deleteSeatRecord(id);
        if (rows == 0) {
            log.warn("删除失败，座位ID不存在: {}", id);
            throw new IllegalStateException("座位不存在或已删除");
        }
        
        log.info("删除座位成功: ID = {}", id);
    }
    
    /**
     * 通过 id 查找选座记录
     *
     * @param id
     * @return
     */
    @Override
    public SeatRecord findSeatRecordBySeatId(Integer id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("非法座位ID");
        }
        return seatRecordMapper.findSeatRecordBySeatId(id);
    }
}
