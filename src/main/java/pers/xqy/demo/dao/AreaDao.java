package pers.xqy.demo.dao;

import pers.xqy.demo.entity.Area;

import java.util.List;

public interface AreaDao {
    List<Area> queryArea();
    Area queryAreaById(int areaId);
    int insertArea(Area area);
    int updateArea(Area area);
    int deleteArea(int areaId);
}
