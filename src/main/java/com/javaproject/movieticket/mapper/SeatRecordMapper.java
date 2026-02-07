package com.javaproject.movieticket.mapper;

import com.javaproject.movieticket.entity.SeatRecord;
import com.javaproject.movieticket.vo.seatRecord.AddSeatRecordReq;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 选座记录类 mapper 层
 */
@Mapper
public interface SeatRecordMapper {
    /**
     * 添加选座记录
     * @param addSeatRecordReq
     */
    @Insert("INSERT INTO seat_record(seat_id, user_id, create_time, update_time) " +
            "VALUES (#{seatId}, #{userId},  NOW(), NOW())")
    void addSeatRecord(AddSeatRecordReq addSeatRecordReq);
    
    /**
     * 批量获取选座列表
     * @return
     */
    @Select("SELECT * FROM seat_record")
    List<SeatRecord> seatRecordList();
    
    /**
     * 删除选座记录
     * @param id
     */
    @Delete("DELETE FROM seat_record WHERE id = #{id}")
    int deleteSeatRecord(Integer id);
    
    /**
     * 通过 id 查找选座记录
     *
     * @param id
     * @return
     */
    @Select("SELECT * FROM seat_record WHERE seat_id = #{id}")
    SeatRecord findSeatRecordBySeatId(Integer id);
}
