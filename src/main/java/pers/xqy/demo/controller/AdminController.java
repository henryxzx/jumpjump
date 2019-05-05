package pers.xqy.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.xqy.demo.entity.RotationChart;
import pers.xqy.demo.service.AdminService;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: demo
 * @description: 管理员Controller
 * @author: henryxzx
 * @create: 2019-03-13 17:52
 **/


@RestController
@RequestMapping("/Admin")
public class AdminController {
    @Autowired
    public AdminService adminService;

    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public Map<String, Object> listAll() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("list", adminService.listAll());
        return modelMap;
    }

    @RequestMapping(value = "/listAllRotationChart", method = RequestMethod.GET)
    public Map<String, Object> listAllRotationChart(){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("list", adminService.listAllRotationChart());
        return modelMap;
    }

    @RequestMapping(value = "/insertRotationChart", method = RequestMethod.POST)
    public Map<String, Object> insertRotationChart(@RequestParam(value = "url") String url, @RequestParam(value = "pageId")int pageId){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        RotationChart rotationChart = new RotationChart();
        rotationChart.setPageId(pageId);
        rotationChart.setUrl(url);
        if(adminService.insertRotationChart(rotationChart) == true){
            modelMap.put("success", "插入成功！");
        }else {
            modelMap.put("errMsg", "插入失败！");
        }
        return modelMap;
    }
    @RequestMapping(value = "/deleteRotationChart", method = RequestMethod.GET)
    public Map<String, Object> deleteRotationChart(int id){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        if(adminService.deleteRotationChart(id) == true){
            modelMap.put("success", "删除成功！");
        }else{
            modelMap.put("errMsg", "删除失败！");
        }
        return modelMap;
    }



}

