package pers.xqy.demo.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.xqy.demo.entity.GameCommunityPostingEvaluate;
import pers.xqy.demo.service.GameCommunityPostingEvaluateService;

import java.util.Date;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest

public class GameCommunityPostingEvaluateServiceImplTest {

    @Autowired
    public GameCommunityPostingEvaluateService gameCommunityPostingEvaluateService;


    @Test
    public void listAllById() {
        assertEquals(1, gameCommunityPostingEvaluateService.listAllById(1).size());
    }

    @Test
    public void findById() {
        assertEquals(1, gameCommunityPostingEvaluateService.findById(2).getGameCommunityPostingEvaluateUid().intValue());
    }

    @Test
    public void insert() {
        GameCommunityPostingEvaluate gameCommunityPostingEvaluate = new GameCommunityPostingEvaluate();
        gameCommunityPostingEvaluate.setGameCommunityPostingEvaluateTime(new java.sql.Date(new Date().getTime()));
        gameCommunityPostingEvaluate.setGameCommunityPostingEvaluateContent("测试评论");
        gameCommunityPostingEvaluate.setGameCommunityPostingEvaluatePostingId(1);
        gameCommunityPostingEvaluate.setGameCommunityPostingEvaluateUid(1);
        assertEquals(true, gameCommunityPostingEvaluateService.insert(gameCommunityPostingEvaluate));
    }

    @Test
    public void delete() {
        assertEquals(true, gameCommunityPostingEvaluateService.delete(2));
    }

    @Test
    public void listByUId() {
        assertEquals(1, gameCommunityPostingEvaluateService.listByUId(1).size());
    }
}