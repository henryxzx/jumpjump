package pers.xqy.demo.entity;

/**
 * @program: demo
 * @description: 游戏推荐引擎游戏类型
 * @author: henryxzx
 * @create: 2019-03-06 12:51
 **/
public class NewsModules {
    //游戏Id
    private Integer id;
    //游戏类型名字
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
