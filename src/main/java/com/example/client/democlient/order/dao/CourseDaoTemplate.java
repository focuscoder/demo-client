package com.example.client.democlient.order.dao;

import com.example.client.democlient.order.OrderEntity.CourseVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CourseDaoTemplate {

    CourseVo getCourseById(Integer courseId);
}
