package pers.xqy.demo.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.xqy.demo.entity.Comments;
import pers.xqy.demo.service.CommentsService;

import java.util.Date;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentsServiceImplTest {

    @Autowired
    private CommentsService commentsService;

    @Test
    public void listByGameId() {
        assertEquals(1, commentsService.listByGameId(3).size());
    }

    @Test
    public void findByUId() {
        assertEquals(1, commentsService.findByUId(1).size());
    }

    @Test
    public void insert() {
        Comments comments = new Comments();
        comments.setCommentsContent("哈哈哈");
        comments.setGameId(3);
        comments.setIsRecommend(1);
        comments.setuId(1);
        comments.setCommentsTime(new Date());
//        System.out.println(new Date());
        assertEquals(true, commentsService.insert(comments));
    }

    @Test
    public void delete() {
        assertEquals(true, commentsService.delete(5));
    }
}