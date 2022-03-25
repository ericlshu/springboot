package com.eric;

import com.eric.domain.Book;
import com.eric.mapper.BookMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class Day09DaoSqlApplicationTests {

    @Autowired
    private BookMapper bookMapper;

    @Test
    void contextLoads()
    {
        Book book = bookMapper.selectById(10);
        log.warn("book : " + book);
    }
}
