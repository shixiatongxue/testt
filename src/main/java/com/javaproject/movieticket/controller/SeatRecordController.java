package com.javaproject.movieticket.controller;

import com.javaproject.movieticket.entity.Result;
import com.javaproject.movieticket.entity.SeatRecord;
import com.javaproject.movieticket.service.SeatRecordService;
import com.javaproject.movieticket.vo.seatRecord.AddSeatRecordReq;
import com.javaproject.movieticket.vo.seatRecord.DeleteSeatRecordReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * seatRecord 相关的 Controller
 */
@RestController
@RequestMapping("/seatrecord")
public class SeatRecordController {
    
    @Autowired
    private SeatRecordService seatRecordService;
    
    /**
     * 添加选座记录
     * @param addSeatRecordReq
     * @return
     */
    @PostMapping
    public Result addSeatRecord(@RequestBody AddSeatRecordReq addSeatRecordReq) {
        SeatRecord seatRecord = seatRecordService.findSeatRecordBySeatId(addSeatRecordReq.getSeatId());
        if (seatRecord == null) {
            seatRecordService.addSeatRecord(addSeatRecordReq);
            return Result.success();
        } else {
            return Result.error("已有选座记录");
        }
    }
    
    /**
     * 批量获取选座列表
     * @return
     */
    @GetMapping
    public Result<List<SeatRecord>> seatRecordList() {
        List<SeatRecord> seatRecords = seatRecordService.seatRecordList();
        return Result.success(seatRecords);
    }
    
    /**
     * 删除选座记录
     * @return
     */
    @DeleteMapping
    public Result deleteSeatRecord(@RequestBody DeleteSeatRecordReq deleteSeatRecordReq) {
        seatRecordService.deleteSeatRecord(deleteSeatRecordReq.getId());
        return Result.success();
    }
}
