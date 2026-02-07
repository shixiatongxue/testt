package com.javaproject.movieticket.service.impl;

import com.javaproject.movieticket.entity.Seat;
import com.javaproject.movieticket.mapper.SeatMapper;
import com.javaproject.movieticket.service.SeatService;
import com.javaproject.movieticket.vo.seat.AddSeatReq;
import com.javaproject.movieticket.vo.seat.UpdateSeatReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 系统 Service 层实现类
 */
@Slf4j
@Service
public class SeatServiceImpl implements SeatService {

    @Autowired
    private SeatMapper seatMapper;
    
    /**
     * 通过名字查找座位
     * @param name 原因名称
     * @return Seat 对象
     */
    @Override
    public Seat findSeatByName(String name) {
        if (!StringUtils.hasText(name)) {
            throw new IllegalArgumentException("座位名称不能为空");
        }
        return seatMapper.findSeatByName(name.trim());
    }
    
    /**
     * 添加座位（去重 + 校验）
     * @param addSeatReq
     */
    @Override
    public void addSeat(AddSeatReq addSeatReq) {
        seatMapper.addSeat(addSeatReq);
        log.info("添加原因成功: {}", addSeatReq);
    }
    /**
     * 批量获取座位列表
     * @return 原因集合
     */
    @Override
    public List<Seat> seatList() {
        return seatMapper.seatList();
    }
    
    /**
     * 删除座位（校验ID）
     * @param id 原因ID
     */
    @Override
    public void deleteSeat(Integer id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("非法座位ID");
        }
        
        int rows = seatMapper.deleteSeat(id);
        if (rows == 0) {
            log.warn("删除失败，座位ID不存在: {}", id);
            throw new IllegalStateException("座位不存在或已删除");
        }
        
        log.info("删除座位成功: ID = {}", id);
    }
    
    /**
     * 通过id查找座位
     *
     * @param id
     * @return
     */
    @Override
    public Seat findSeatById(Integer id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("非法座位ID");
        }
        return seatMapper.findSeatById(id);
    }
    
    /**
     * 更新座位信息
     *
     * @param updateSeatReq
     */
    @Override
    public void updateSeat(UpdateSeatReq updateSeatReq) {
        seatMapper.updateSeat(updateSeatReq);
    }
}
