package pers.xqy.demo.service.impl;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.xqy.demo.entity.Area;
import pers.xqy.demo.service.AreaService;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaServiceImplTest {

    @Autowired
    private AreaService areaService;
    @Test
    public void getAreaList() {
        assertEquals(2, areaService.getAreaList().size());
    }

    @Test
    public void getAreaById() {
        assertEquals("东苑", areaService.getAreaById(1).getAreaName());
    }

    @Test
    @Ignore
    public void addArea() {
        Area area = new Area();
        area.setLastEditTime(new Date());
        area.setAreaName("西园");
        area.setCreateTime(new Date());
        area.setPriority(3);
        assertEquals(true, areaService.addArea(area));
    }

    @Test
    @Ignore
    public void modifyArea() {
        Area area = new Area();
        area.setAreaId(4);
        area.setAreaName("芷园");
        area.setLastEditTime(new Date());
        assertEquals(true, areaService.modifyArea(area));
    }

    @Test
    @Ignore
    public void deleteArea() {
        int delete_id = 4;
        assertEquals(true, areaService.deleteArea(delete_id));
    }
}