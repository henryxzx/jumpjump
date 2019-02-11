package pers.xqy.demo.service;

import pers.xqy.demo.entity.GameType;

import java.util.List;

/**
 * @program: demo
 * @description: 游戏类型Service层
 * @author: henryxzx
 * @create: 2019-02-10 19:52
 **/
public interface GameTypeService {
    //列出所有游戏类型
    public List<GameType> listAll();
    //根据游戏类型Id列出游戏类型
    public GameType findById(int gameTypeId);
    //根据游戏类型名称返回游戏类型Id
    public Integer findIdByName(String gameTypeName);

}
