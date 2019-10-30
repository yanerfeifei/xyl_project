package com.xyl.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by meridian on 2019/9/10.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String exportPdf(){
        return "/index";
    }

















}
