package com.bouncer77.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Kosenkov Ivan
 * Created by Kosenkov Ivan on 02.09.2020
 */
@Controller
@RequestMapping("first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(HttpServletRequest request) {

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        System.out.println("Hello, " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage(@RequestParam("name") String name,
                              @RequestParam("surname") String surname) {
        System.out.println("Goodbye, " + name + " " + surname);
        return "first/goodbye";
    }

    @GetMapping("/hi")
    public String hiPage(@RequestParam("name") String name,
                         @RequestParam("surname") String surname,
                         Model model) {
        model.addAttribute("key1", "Hi, " + name + " " + surname);
        return "first/hi";
    }

    @GetMapping("/calc")
    public String culcPage(@RequestParam("a") int a,
                           @RequestParam("b") int b,
                           @RequestParam("act") String act,
                           Model model) {

        System.out.println(a + " " + act + " " + b + " = ");

        int res = 0;
        switch (act) {
            case "mul":
                res = a * b;
                break;
            case "add":
                res = a + b;
                break;
            case "sub":
                res = a - b;
                break;
            case "div":
                if (b != 0) {
                    res = a / b;
                } else {
                    res = -9999;
                }
                break;
            default:
                res = 1;
        }
        model.addAttribute("res", res);

        return "first/calc";
    }

}
