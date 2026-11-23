package org.xue.xue_iot.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.xue.xue_iot.pojo.Tag;

@Mapper
public interface TagMapper {
    @Select("select * from tag where name = #{name}")
    public Tag findByName(String name);

    @Insert("insert into tag(name) values(#{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void insert(Tag tag);
}
