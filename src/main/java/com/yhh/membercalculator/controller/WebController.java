package com.yhh.membercalculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author yhh1056
 * @since 2021/02/08
 */

@Controller
public class WebController {

    @GetMapping("/")
    public String home() {
        return "/home";
    }

    @GetMapping("/members/create")
    public String create() {
        return "/members/create";
    }

    @GetMapping("/members/manage")
    public String manage() {
        return "/members/manage";
    }

    @GetMapping("/members/calc")
    public String calc() {
        return "/members/calc";
    }

    @GetMapping("/members/members")
    public String members() {
        return "/members/members";
    }

}
