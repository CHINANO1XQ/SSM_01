package com.zking.service;

import com.zking.model.Book;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface IBookService {
    int deleteByPrimaryKey(Integer bookId);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer bookId);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    List<Book> getAll(Book book);
}