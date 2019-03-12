package pers.xqy.demo.service.impl;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.xqy.demo.dao.CommentsDao;
import pers.xqy.demo.dao.UserDao;
import pers.xqy.demo.entity.Comments;
import pers.xqy.demo.service.CommentsService;

import java.util.Date;

/**
 * @program: demo
 * @description: 游戏评测Service层Impl
 * @author: henryxzx
 * @create: 2019-02-11 11:05
 **/
@Service
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    private CommentsDao commentsDao;

    @Autowired
    private UserDao userDao;

    /**
     * @Author henryxzx
     * @Description //TODO 根据游戏Id找出所有的评论
     * @Date 11:27 2019-02-11
     * @Param [gameId]
     * @return java.util.List<pers.xqy.demo.entity.Comments>
     **/
    @Transactional
    @Override
    public Page<Comments> listByGameId(int gameId) {
        Page<Comments> list = commentsDao.listByGameId(gameId);
        for (int i = 0; i < list.size();i++){
            list.get(i).setUser(userDao.findUserByUId(list.get(i).getuId()));
        }
        return list;
    }

    /**
     * @Author henryxzx
     * @Description //TODO 根据uId找到该用户的评论
     * @Date 11:27 2019-02-11
     * @Param [uId]
     * @return java.util.List<pers.xqy.demo.entity.Comments>
     **/
    @Transactional
    @Override
    public Page<Comments> findByUId(int uId) {
        return commentsDao.findByUId(uId);
    }

    /**
     * @Author henryxzx
     * @Description //TODO 插入评论
     * @Date 11:27 2019-02-11
     * @Param [comments]
     * @return boolean
     **/
    @Transactional
    @Override
    public boolean insert(Comments comments) {
        if (comments.getCommentsContent() != null) {
            comments.setCommentsTime(new java.sql.Date(new Date().getTime()));
//            System.out.println(new Date());
            try {
                int effectedNum = commentsDao.insert(comments);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入信息失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入信息失败" + e.getMessage());
            }
        }else{
            throw new RuntimeException("评论信息不能为空");
        }

    }

    /**
     * @Author henryxzx
     * @Description //TODO 根据ID删除评论
     * @Date 11:27 2019-02-11
     * @Param [commentsId]
     * @return boolean
     **/
    @Transactional
    @Override
    public boolean delete(int commentsId) {
        if (commentsId > 0) {
            try {
                int effectedNum = commentsDao.delete(commentsId);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除信息失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除信息失败" + e.getMessage());
            }
        }else{
            throw new RuntimeException("Id不能为空");
        }
    }
}
