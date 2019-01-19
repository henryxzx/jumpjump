package pers.xqy.demo.service;

import pers.xqy.demo.entity.Area;

import java.util.List;

public interface AreaService {
    /**
     * 返回所有信息
     * @return
     */
    List<Area> getAreaList();

    /**
     * 根据Id获取区域
     * @param areaId
     * @return
     */
    Area getAreaById(int areaId);

    /**
     * 增加区域
     * @param area
     * @return
     */
    boolean addArea(Area area);

    /**
     * 修改区域信息
     * @param area
     * @return
     */
    boolean modifyArea(Area area);

    /**
     * 删除区域信息
     * @param areaId
     * @return
     */
    boolean deleteArea(int areaId);
}
