package pers.xqy.demo.dao;

import pers.xqy.demo.entity.GameCommunity;

import java.util.List;

/**
 * @program: java_project
 * @description: 游戏社区类型Dao层
 * @author: henryxzx
 * @create: 2019-02-10 16:48
 **/
public interface GameCommunityDao {

    //列出所有游戏社区
    public List<GameCommunity> listAll();


}
