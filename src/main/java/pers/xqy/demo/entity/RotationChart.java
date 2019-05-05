package pers.xqy.demo.entity;

/**
 * @program: demo
 * @description: 轮播图实体类
 * @author: henryxzx
 * @create: 2019-03-13 19:51
 **/
public class RotationChart {

    //轮播图Id
    private Integer id;
    //轮播图url
    private String url;
    //页面id 主页1
    private Integer pageId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPageId() {
        return pageId;
    }

    public void setPageId(Integer pageId) {
        this.pageId = pageId;
    }
}
