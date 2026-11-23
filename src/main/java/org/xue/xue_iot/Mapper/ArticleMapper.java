package org.xue.xue_iot.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.xue.xue_iot.pojo.Article;

@Mapper
public interface ArticleMapper {
    @Insert("insert into article(title, content, cover_url, author, category_id) values(#{title}, #{content}, #{coverUrl}, #{author}, #{categoryId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void insert(Article article);
}
