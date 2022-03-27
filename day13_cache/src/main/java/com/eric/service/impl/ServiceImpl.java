package com.eric.service.impl;

import com.eric.domain.Book;
import com.eric.mapper.BookMapper;
import com.eric.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2022-03-27 18:22
 */
@Service
public class ServiceImpl implements BookService {

    @Resource(name = "bookMapper")
    private BookMapper bookMapper;

    @Override
    public boolean save(Book book)
    {
        return bookMapper.insert(book) > 0;
    }

    @Override
    public Book getById(Integer id)
    {
        return bookMapper.selectById(id);
    }

    @Override
    public boolean update(Book book)
    {
        return bookMapper.updateById(book) > 0;
    }

    @Override
    public boolean delete(Integer id)
    {
        return bookMapper.deleteById(id) > 0;
    }

    @Override
    public List<Book> getAll()
    {
        return bookMapper.selectList(null);
    }
}