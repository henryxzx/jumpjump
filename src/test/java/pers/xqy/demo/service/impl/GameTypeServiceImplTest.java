package pers.xqy.demo.service.impl;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.xqy.demo.dao.GameTypeDao;
import pers.xqy.demo.service.GameTypeService;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class GameTypeServiceImplTest {

    @Autowired
    private GameTypeDao gameTypeDao;

    @Autowired
    private GameTypeService gameTypeService;

    @Test
    @Ignore
    public void listAll() {
        assertEquals(1, gameTypeDao.listAll().size());
    }

    @Test
    @Ignore
    public void findById() {
        assertEquals("拉萨游戏", gameTypeDao.findById(1).getGameTypeName());
    }

    @Test
    public void findIdByName() {
        assertEquals("1", gameTypeService.findIdByName("拉萨游戏").toString());
    }
}