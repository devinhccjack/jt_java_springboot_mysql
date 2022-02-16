package com.jt.mapper;

import com.jt.pojo.Rights;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface RightsMapper {
    @Select("select * from rights where parent_id=#{parentId}")
    List<Rights> findByParentId(int parentId);

    List<Rights> getRightsList();
}
