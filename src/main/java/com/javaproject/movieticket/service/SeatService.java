package com.javaproject.movieticket.service;

import com.javaproject.movieticket.entity.Seat;
import com.javaproject.movieticket.vo.seat.AddSeatReq;
import com.javaproject.movieticket.vo.seat.UpdateSeatReq;

import java.util.List;

/**
 * seat 的 Service 层
 */
public interface SeatService {
    
    /**
     * 通过名字查找座位
     * @param name
     * @return
     */
    Seat findSeatByName(String name);
    
    /**
     * 添加座位
     * @param addSeatReq
     */
    void addSeat(AddSeatReq addSeatReq);
    
    /**
     * 批量获取座位列表
     * @return
     */
    List<Seat> seatList();
    
    /**
     * 删除座位
     * @param id
     */
    void deleteSeat(Integer id);
    
    /**
     * 通过id查找座位
     * @param id
     * @return
     */
    Seat findSeatById(Integer id);
    
    /**
     * 更新座位信息
     * @param updateSeatReq
     */
    void updateSeat(UpdateSeatReq updateSeatReq);
}
