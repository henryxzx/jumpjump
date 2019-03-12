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
        assertEquals(1, gameService.findAllLimit().size());
//        assertEquals(gameService.findAllLimit(0).size(), 3);
    }

    @Test
//    @Ignore
    public void findByName() {
        assertEquals("3" , gameService.findByName("好玩的").getGameId().toString());
        assertEquals("拉萨游戏", gameService.findByName("不好玩的").getGameType().getGameTypeName());
    }


    @Test
//    @Ignore
    public void findById() {
        assertEquals("好玩的", gameService.findById(3).getGameName());
    }


    @Test
//    @Ignore
    public void listByType() {
        assertEquals(2, gameService.listByType("拉萨游戏").size());
    }

//    @Test
//    @Ignore
//    public void listByPublisher() {
//        assertEquals(4, gameService.listByPublisher("腾讯").size());
//    }

    @Test
    public void listByPublishTime() {
        assertEquals("2019-02-11",gameService.listByPublishTime().get(0).getGamePublishTime().toString());
    }

    @Test
    public void listByGameScore() {
        assertEquals("10", gameService.listByGameScore().get(0).getGameScore().toString());
    }

    @Test
    public void addCommentsNum() {
        assertEquals(true, gameService.addCommentsNum(3));
    }

    @Test
    public void reduceCommentsNum() {
        assertEquals(true, gameService.reduceCommentsNum(3));
    }

    @Test
    public void listByHot() {
        assertEquals("无聊的", gameService.listByHot().get(0).getGameName());
    }
}