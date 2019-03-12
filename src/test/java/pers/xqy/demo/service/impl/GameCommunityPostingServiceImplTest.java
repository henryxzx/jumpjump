package pers.xqy.demo.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.xqy.demo.entity.GameCommunityPosting;
import pers.xqy.demo.service.GameCommunityPostingService;

import java.util.Date;

import static org.junit.Assert.assertEquals;
@RunWith(SpringRunner.class)
@SpringBootTest
public class GameCommunityPostingServiceImplTest {

    @Autowired
    private GameCommunityPostingService gameCommunityPostingService;

    @Test
    public void listAllById() {
        assertEquals(1, gameCommunityPostingService.listAllById(1).size());
    }

    @Test
    public void insert() {
        GameCommunityPosting gameCommunityPosting = new GameCommunityPosting();
        gameCommunityPosting.setGameCommunityPostingContent("测试咯");
        gameCommunityPosting.setGameCommunityPostingEvaluateNum(0);
        gameCommunityPosting.setGameCommunityPostingTime(new java.sql.Date(new Date().getTime()));
        gameCommunityPosting.setGameCommunityPostingTitle("测试标题");
        gameCommunityPosting.setGameCommunityPostingUid(1);
        gameCommunityPosting.setGameCommuntiyPostingGameCommuntiyId(1);
        assertEquals(true, gameCommunityPostingService.insert(gameCommunityPosting));
    }

    @Test
    public void delete() {
        assertEquals(true, gameCommunityPostingService.delete(1));
    }

    @Test
    public void addEvaluateNum() {
        assertEquals(true, gameCommunityPostingService.addEvaluateNum(1));
    }

    @Test
    public void reduceEvaluateNum() {
        assertEquals(true, gameCommunityPostingService.reduceEvaluateNum(1));

    }

    @Test
    public void findById() {
        assertEquals("测试标题", gameCommunityPostingService.findById(1).getGameCommunityPostingTitle());
    }
}