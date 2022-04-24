package com.unicorn.service.mapper;

import com.unicorn.service.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeacherMapper {
    // 新建一个Teacher
    Teacher getTeacherByTeacherId(int TeacherId);

    Teacher getTeacherByLoginId(String LoginId);

    Teacher getTeacherByTeacherMobile(String TeacherMobile);
}
