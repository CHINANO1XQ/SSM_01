package com.zking.service.impl;

import com.zking.model.Book;
import com.zking.service.IBookService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring.xml")
public class BookServiceImplTest{
    @Autowired
    private IBookService bookService;
    private Book book;

    @Before
    public void setUp() throws Exception {
        book=new Book();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByPrimaryKey() {
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
    }
/*
    @Test
    public void getAll() {
        List<Book> bookList = bookService.getAll(book);
        for (Book b : bookList) {
            System.out.println(b);
        }

    }*/
}