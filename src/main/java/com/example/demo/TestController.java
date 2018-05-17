package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by think on 2018/4/28.
 */
@Controller
public class TestController {
    @RequestMapping(value="/",consumes = "application/xml",produces ="application/xml" )
    public String test(@RequestBody Map xml){
        return "";
    }
}
