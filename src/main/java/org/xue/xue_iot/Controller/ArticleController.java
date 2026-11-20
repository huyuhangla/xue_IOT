package org.xue.xue_iot.Controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xue.xue_iot.pojo.Result;
import org.xue.xue_iot.utils.JWTutil;

import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {
    /**身份校验中间件**

            * 除注册/登录/健康检查外，所有接口均需验证 token 有效性
   * Token 过期时间设置为 7 天*/

   /*   * `0`：成功
  * `40001`：参数校验失败
  * `40100`：未登录/Token 无效
  * `40300`：无权限操作
  * `40400`：资源不存在
  * `50000`：服务器内部错误*/
    @GetMapping("/getall")
    public Result<String> GetAllArticle() {
        return Result.success("获取文章列表成功");
    }
}
