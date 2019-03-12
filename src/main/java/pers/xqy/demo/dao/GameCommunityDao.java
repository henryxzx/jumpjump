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

    //根据Id返回游戏社区信息
    public GameCommunity findById(int gameCommunityId);

    //根据游戏Id返回游戏社区信息
    public GameCommunity findByGameId(int gameId);
    //加入新的社区
    public Integer insert(GameCommunity gameCommunity);
}
