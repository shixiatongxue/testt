package com.javaproject.movieticket.controller;

import com.javaproject.movieticket.entity.Seat;
import com.javaproject.movieticket.entity.Result;
import com.javaproject.movieticket.service.SeatService;
import com.javaproject.movieticket.vo.seat.AddSeatReq;
import com.javaproject.movieticket.vo.seat.DeleteSeatReq;
import com.javaproject.movieticket.vo.seat.UpdateSeatReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * seat 相关的 Controller
 */
@RestController
@RequestMapping("/seat")
public class SeatController {
    
    @Autowired
    private SeatService seatService;

    /**
     * 添加座位
     * @param addSeatReq
     * @return
     */
    @PostMapping
    public Result addSeat(@RequestBody AddSeatReq addSeatReq) {
        Seat seat = seatService.findSeatByName(addSeatReq.getSeatName());
        if (seat == null) {
            seatService.addSeat(addSeatReq);
            return Result.success();
        } else {
            return Result.error("已有座位");
        }
    }
    
    /**
     * 批量获取座位列表
     * @return
     */
    @GetMapping
    public Result<List<Seat>> seatList() {
        List<Seat> seats = seatService.seatList();
        return Result.success(seats);
    }
    
    /**
     * 删除座位
     * @return
     */
    @DeleteMapping
    public Result deleteSeat(@RequestBody DeleteSeatReq deleteSeatReq) {
        seatService.deleteSeat(deleteSeatReq.getId());
        return Result.success();
    }
    
    /**
     * 更新座位信息
     * @param updateSeatReq
     * @return
     */
    @PutMapping
    public Result updateSeat(@RequestBody UpdateSeatReq updateSeatReq) {
        Seat seat = seatService.findSeatById(updateSeatReq.getId());
        if (seat != null) {
            seatService.updateSeat(updateSeatReq);
            return Result.success();
        } else {
            return Result.error("更新的座位不存在");
        }
    }
}
