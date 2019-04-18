package cn.com.springboot.controller;

import cn.com.springboot.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.gateway.mvc.ProxyExchange;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author sj
 * @since 2018-12-27 15:32
 **/
@Api(tags = "代理接口")
@RestController
public class ProxyController {

    /**
     * 还原请求头
     */
    private static void addOriginHeaders(HttpServletRequest request, ProxyExchange<byte[]> proxy) {
        String[] keys = new String[]{
                "Content-Type",
                "token",
        };
        Arrays.stream(keys).forEach(k -> proxy.header(k, request.getHeader(k)));
    }

    @ApiOperation("我是哈哈哈")
    @GetMapping("/hahaha")
    public HttpResult hahaha() {
        return HttpResult.success("哈哈哈");
    }

    @ApiOperation("代理到哈哈哈")
    @GetMapping("/proxy/**")
    public ResponseEntity<?> proxy(ProxyExchange<byte[]> proxy, HttpServletRequest request) throws IOException {
        addOriginHeaders(request, proxy);
        var url = "http://localhost:8080/hahaha" + "?" + request.getQueryString();
//        实际情况，用switch判断各种方法
//        post方法不用加body，具体可以参考源码
        return proxy.uri(url).get();
    }


}
