package pers.xqy.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Good {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        return "tony ma";
    }
}