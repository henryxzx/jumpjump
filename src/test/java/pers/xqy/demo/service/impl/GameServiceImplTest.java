package pers.xqy.demo.service.impl;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.xqy.demo.entity.Game;
import pers.xqy.demo.service.GameService;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GameServiceImplTest {
    @Autowired
    private GameService gameService;

    @Test
//    @Ignore
    public void findAllLimit() {
        assertEquals(2, gameService.findAllLimit(0).size());
//        assertEquals(gameService.findAllLimit(0).size(), 3);
    }

    @Test
    public void findByName() {
        assertEquals("腾讯", gameService.findByName("测试"));
    }


}