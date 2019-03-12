package pers.xqy.demo.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.xqy.demo.service.GameCommunityService;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class GameCommunityServiceImplTest {

    @Autowired
    private GameCommunityService gameCommunityService;

    @Test
    public void listAll() {
        assertEquals(2, gameCommunityService.listAll().size());
    }

    @Test
    public void findById() {
        assertEquals(0, gameCommunityService.findById(1).getGameCommunityPostingNum().intValue());
    }


    @Test
    public void findByGameId() {
        assertEquals("zz",gameCommunityService.findByGameId(3).getGameCommunityImage());
    }

    @Test
    public void insert() {

    }
}