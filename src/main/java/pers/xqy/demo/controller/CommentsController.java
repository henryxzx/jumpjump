package pers.xqy.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pers.xqy.demo.entity.Comments;
import pers.xqy.demo.service.CommentsService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: demo
 * @description: 游戏评测Controller
 * @author: henryxzx
 * @create: 2019-02-16 15:52
 **/

@RestController
@RequestMapping("/comments")
public class CommentsController {
    @Autowired
    private CommentsService commentsService;

    @RequestMapping(value = "/listByGameId", method = RequestMethod.GET)
    private Map<String, Object> listByGameId(String gameId){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        int id = Integer.parseInt(gameId);
        List<Comments> list = commentsService.listByGameId(id);
        modelMap.put("commentsList", list);
        return modelMap;
    }


}
