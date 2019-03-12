package pers.xqy.demo.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.xqy.demo.service.RecommendationsService;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecommendationsServiceImplTest {

    @Autowired
    private RecommendationsService recommendationsService;

    @Test
    public void listById() {
        assertEquals(1, recommendationsService.listById(1).size());
    }
}