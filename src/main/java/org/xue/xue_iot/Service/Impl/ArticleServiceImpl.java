package org.xue.xue_iot.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xue.xue_iot.Mapper.ArticleMapper;
import org.xue.xue_iot.Mapper.ArticleTagMapper;
import org.xue.xue_iot.Mapper.TagMapper;
import org.xue.xue_iot.Service.ArticleService;
import org.xue.xue_iot.pojo.Article;
import org.xue.xue_iot.pojo.ArticleRequest;
import org.xue.xue_iot.pojo.Tag;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private TagMapper tagMapper;
    @Autowired
    private ArticleTagMapper articleTagMapper;

    @Override
    @Transactional
    public void createArticle(ArticleRequest request, String username) {
        Article article = new Article();
        article.setTitle(request.getTitle());
        article.setContent(request.getContent());
        article.setCoverUrl(request.getCoverUrl());
        article.setAuthor(username);
        article.setCategoryId(request.getCategoryId());
        articleMapper.insert(article);

        List<String> tagNames = request.getTags();
        if (tagNames != null) {
            for (String tagName : tagNames) {
                Tag tag = tagMapper.findByName(tagName);
                if (tag == null) {
                    tag = new Tag();
                    tag.setName(tagName);
                    tagMapper.insert(tag);
                }
                articleTagMapper.insert(article.getId(), tag.getId());
            }
        }
    }
}
