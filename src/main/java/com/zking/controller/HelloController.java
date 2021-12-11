package com.zking.controller;

import com.zking.mapper.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HelloController {

    @ModelAttribute//非请求处理方法
    public void testModel(Model model){
        Student stu=new Student();
        List list=new ArrayList();
        List sexlist=new ArrayList();
        list.add("邓宗良爱放屁");
        list.add("放屁");
        sexlist.add("男");
        sexlist.add("女");
        stu.setSname("孙旭东是傻逼");
        stu.setPassword("4567");
        stu.setSex("男");
        model.addAttribute("sellist",sexlist);
        model.addAttribute("list",list);
        model.addAttribute("stu",stu);
    }

    @RequestMapping("/hello/{name}")
    @ResponseBody
    public String hello(@PathVariable String name){
        System.out.println(name+":牛逼");
        return name;
    }

    @RequestMapping("/index")
    public String index(HttpSession session){
        System.out.println("首页");
        session.setAttribute("sex","男");
        return "index";
    }


}
