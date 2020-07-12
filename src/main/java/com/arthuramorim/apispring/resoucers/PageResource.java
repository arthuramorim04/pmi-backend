package com.arthuramorim.apispring.resoucers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageResource {


    @RequestMapping("/")
    public String index() {
        return "index";
    }

}
