package pers.xqy.demo.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.xqy.demo.entity.Recommend;
import pers.xqy.demo.service.RecommendService;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest

public class RecommendServiceImplTest {

    @Autowired
    private RecommendService recommendService;

    @Test
    public void listAllRecommend() {
        assertEquals(2, recommendService.listAllRecommend().size());
    }

    @Test
    public void updateStatus() {
        assertEquals(true, recommendService.updateStatus(1));
    }

    @Test
    public void insert() {
        Recommend recommend = new Recommend();
        recommend.setGameId(3);
        recommend.setRecommendContent("好");
        recommend.setUserId(1);
        recommend.setRecommendImage("zz");
        assertEquals(true, recommendService.insert(recommend));
    }

    @Test
    public void delete() {
        assertEquals(true, recommendService.delete(2));
    }
}