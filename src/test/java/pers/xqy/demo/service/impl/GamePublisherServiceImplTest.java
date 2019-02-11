package pers.xqy.demo.service.impl;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.xqy.demo.service.GamePublisherService;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GamePublisherServiceImplTest {

    @Autowired
    private GamePublisherService gamePublisherService;

    @Test
    @Ignore
    public void listAll() {
        assertEquals(1, gamePublisherService.listAll().size());
    }

    @Test
    @Ignore
    public void findById() {
        assertEquals("腾讯", gamePublisherService.findById(1).getGamePublisherName());
    }
}