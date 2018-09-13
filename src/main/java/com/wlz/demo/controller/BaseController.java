package com.wlz.demo.controller;

import com.wlz.demo.domain.ResponseBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 对外接口根目录接口(json格式)
 * 注解@Sfl4j 自动注入日志字段log，并且可以使用{}占位符占位日志输出
 *
 * @author wlz
 * @date 9/7/18 10:17
 */
@Slf4j
@RestController
public class BaseController {

//    @Autowired
//    private UserService userService;

//    @Resource
//    private GraphQL graphQL;


    @GetMapping("/")
    public ResponseBean index() {
        log.info("根目录请求处理1");
//        ExecutionResult result = graphQL.execute(query);
//        return new ResponseEntity<Object>(result, HttpStatus.OK);
        return new ResponseBean("SUCCESS", 200, "V1.0.1");
    }
}


