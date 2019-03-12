package pers.xqy.demo.service.impl;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.xqy.demo.entity.NewsLogs;
import pers.xqy.demo.service.NewsLogsService;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NewsLogsServiceImplTest {

    @Autowired
    private NewsLogsService newsLogsService;

    @Test
    public void listAll() {
        assertEquals(1, newsLogsService.listAll().size());
    }

    @Test
    @Ignore
    public void insert() {
        NewsLogs newsLogs = new NewsLogs();
        newsLogs.setPreferDegree(1);
        newsLogs.setUserId(4);
        newsLogs.setNewsId(4);
        assertEquals(true, newsLogsService.insert(newsLogs));
    }
}