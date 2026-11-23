package org.xue.xue_iot.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.xue.xue_iot.Service.ArticleService;
import org.xue.xue_iot.pojo.ArticleRequest;
import org.xue.xue_iot.pojo.Result;
import org.xue.xue_iot.utils.JWTutil;

@RestController
@RequestMapping("/api/v1/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping
    public Result createArticle(@RequestBody ArticleRequest request, HttpServletRequest httpRequest) {
        String token = httpRequest.getHeader("Authorization");
        String username = JWTutil.parseToken(token).get("username").toString();

        if (request.getTitle() == null || request.getTitle().trim().isEmpty()) {
            return Result.fail("标题不能为空");
        }
        if (request.getContent() == null || request.getContent().trim().isEmpty()) {
            return Result.fail("正文内容不能为空");
        }

        articleService.createArticle(request, username);
        return Result.success();
    }
}
