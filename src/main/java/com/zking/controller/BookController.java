package com.zking.controller;

import com.zking.model.Book;
import com.zking.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/")
@ContextConfiguration(locations = "classpath*:spring.xml")
public class BookController{
    @Autowired
    private IBookService bookService;
    private Book book=new Book();

    @RequestMapping("getAll")
    @ResponseBody
    public List<Book> getAll(String name){
        book.setBookName(name);
        List<Book> list = bookService.getAll(book);
        return list;
    }


    @RequestMapping("add")
    @ResponseBody
    public String add(){
        book.setBookId(55);
        book.setBookName("何瑞源生吃妖精5");
        book.setBookBrief("真牛逼");
        book.setBookPrice(66f);
        int n = bookService.insert(book);
        if(n>0){
            return "新增成功";
        }else{
            return "新增失败";
        }
    }


    @RequestMapping("update")
    @ResponseBody
    public String update(){
        book.setBookId(55);
        book.setBookName("何瑞源生吃妖精3");
        book.setBookBrief("吃了屎");
        book.setBookPrice(66f);
        int n = bookService.updateByPrimaryKey(book);
        if(n>0){
            return "修改成功";
        }else{
            return "修改失败";
        }
    }

    @RequestMapping("delete")
    @ResponseBody
    public String delete(){
        int n = bookService.deleteByPrimaryKey(55);
        if(n>0){
            return "修改成功";
        }else{
            return "修改失败";
        }
    }

}
