package pers.xqy.demo.service;

import pers.xqy.demo.entity.GameCommunity;

import java.util.List;

/**
 * @program: demo
 * @description: 游戏社区Service层
 * @author: henryxzx
 * @create: 2019-02-16 17:28
 **/
public interface GameCommunityService {

    //列出所有游戏社区
    public List<GameCommunity> listAll();

    //根据Id返回游戏社区信息
    public GameCommunity findById(int gameCommunityId);

}
