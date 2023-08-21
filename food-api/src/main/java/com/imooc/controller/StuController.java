package com.imooc.controller;

import com.imooc.service.StuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StuController {

    public final StuService stuService;

    public StuController(StuService stuService) {
        this.stuService = stuService;
    }

    @GetMapping("/stu")
    public Object stu() {
        return stuService.getStuInfo(1);
    }

    @PostMapping("/updateStu")
    public Object updateStu() {
         stuService.updateStu(1, "wang");
         return "OK";
    }

    @PostMapping("/saveStu")
    public Object saveStu() {
        stuService.setStu();
        return "OK";
    }

    @PostMapping("/delStu")
    public Object delStu() {
        return stuService.getStuInfo(1);
    }
}