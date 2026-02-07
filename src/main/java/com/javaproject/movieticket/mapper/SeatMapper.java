package com.javaproject.movieticket.mapper;

import com.javaproject.movieticket.entity.Seat;
import com.javaproject.movieticket.vo.seat.AddSeatReq;
import com.javaproject.movieticket.vo.seat.UpdateSeatReq;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 座位类 mapper 层
 */
@Mapper
public interface SeatMapper {
    
    /**
     * 通过名字查找座位
     * @param name
     * @return
     */
    @Select("SELECT * FROM seat WHERE seat_name = #{name}")
    Seat findSeatByName(String name);
    
    /**
     * 添加座位
     * @param addSeatReq
     */
    @Insert("INSERT INTO seat(seat_name, seat_line, seat_column, seat_price, create_time, update_time) " +
            "VALUES (#{seatName}, #{seatLine}, #{seatColumn}, #{seatPrice}, NOW(), NOW())")
    void addSeat(AddSeatReq addSeatReq);
    
    /**
     * 批量获取座位列表
     * @return
     */
    @Select("SELECT * FROM seat")
    List<Seat> seatList();
    
    /**
     * 删除座位
     * @param id
     */
    @Delete("DELETE FROM seat WHERE id = #{id}")
    int deleteSeat(Integer id);
    
    /**
     * 通过id查找座位
     *
     * @param id
     * @return
     */
    @Select("SELECT * FROM seat WHERE id = #{id}")
    Seat findSeatById(Integer id);
    
    /**
     * 更新座位信息
     * @param updateSeatReq
     */
    @Update("UPDATE seat SET " +
            "seat_name = #{seatName}, " +
            "seat_line = #{seatLine}, " +
            "seat_column = #{seatColumn}, " +
            "seat_price = #{seatPrice} WHERE id = #{id}")
    void updateSeat(UpdateSeatReq updateSeatReq);
}
