package pers.xqy.demo.entity;

import java.sql.Timestamp;

/**
 * @program: demo
 * @description: 游戏推荐引擎游戏类
 * @author: henryxzx
 * @create: 2019-03-06 12:46
 **/
public class News {
    //游戏Id
    private Integer id;
    //游戏介绍
    private String content;
    //更新时间
    private Timestamp newsTime;
    //游戏标题
    private String title;
    //游戏类型id
    private Integer moduleId;
    //游戏爬取时url(可为空)
    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getNewsTime() {
        return newsTime;
    }

    public void setNewsTime(Timestamp newsTime) {
        this.newsTime = newsTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
