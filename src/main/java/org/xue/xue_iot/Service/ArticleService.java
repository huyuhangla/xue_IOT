package org.xue.xue_iot.Service;

import org.xue.xue_iot.pojo.ArticleRequest;

public interface ArticleService {
    public void createArticle(ArticleRequest request, String username);
}
