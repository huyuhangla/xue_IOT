package org.xue.xue_iot.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ArticleTagMapper {
    @Insert("insert into article_tag(article_id, tag_id) values(#{articleId}, #{tagId})")
    public void insert(@Param("articleId") Long articleId, @Param("tagId") Long tagId);
}
