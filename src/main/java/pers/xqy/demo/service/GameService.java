package pers.xqy.demo.service;

import pers.xqy.demo.entity.Game;

import java.util.List;

public interface GameService {
    //主页的信息分页列出
    public List<Game> findAllLimit(int start);
    //查找游戏名称
    public Game findByName(String gameName);
    //根据类型显示游戏
    public List<Game> listByType(String gameType);
    //根据发行商显示游戏
    public List<Game> listByPublisher(String gamePublisher);





    
    



}
