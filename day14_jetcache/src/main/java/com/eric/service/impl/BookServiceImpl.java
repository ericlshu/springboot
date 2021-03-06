package com.eric.service.impl;

import com.alicp.jetcache.anno.*;
import com.eric.domain.Book;
import com.eric.mapper.BookMapper;
import com.eric.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2022-03-27 18:22
 */
@Service
public class BookServiceImpl implements BookService {

    @Resource(name = "bookMapper")
    private BookMapper bookMapper;

    private final Map<Integer, Book> cache = new HashMap<>();

    @Override
    @CacheUpdate(name = "book_", key = "#book.id", value = "#book")
    public boolean save(Book book)
    {
        return bookMapper.insert(book) > 0;
    }

    @Override
    @Cached(name = "book_", key = "#id", expire = 60, timeUnit = TimeUnit.MINUTES, cacheType = CacheType.REMOTE)
    @CacheRefresh(refresh = 1, timeUnit = TimeUnit.HOURS)
    public Book getById(Integer id)
    {
        return bookMapper.selectById(id);
    }

    @Override
    @CacheUpdate(name = "book_", key = "#book.id", value = "#book")
    public boolean update(Book book)
    {
        return bookMapper.updateById(book) > 0;
    }

    @Override
    @CacheInvalidate(name = "book_", key = "#id")
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
