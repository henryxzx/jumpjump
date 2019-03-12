package pers.xqy.demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.xqy.demo.entity.Comments;
import pers.xqy.demo.service.CommentsService;
import pers.xqy.demo.service.GameService;

import java.util.HashMap;
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

    @Autowired
    private GameService gameService;

    @RequestMapping(value = "/listByGameId", method = RequestMethod.GET)
    private PageInfo<Comments> listByGameId(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize,String gameId){
        int id = Integer.parseInt(gameId);
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<Comments> pageInfo = new PageInfo<>(commentsService.listByGameId(id));
        return pageInfo;
    }

    @RequestMapping(value = "/addComments", method = RequestMethod.POST)
    private Map<String, Object> addComments(@RequestParam(value = "uId") int uId, @RequestParam(value = "content") String content, @RequestParam(value = "gameId")int gameId, @RequestParam(value = "isRecommend")int isRecommend){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Comments comments = new Comments();
        comments.setuId(uId);
        comments.setIsRecommend(isRecommend);
        comments.setCommentsContent(content);
        comments.setGameId(gameId);
        if(commentsService.insert(comments) == true){
            gameService.addCommentsNum(gameId);
            modelMap.put("success", "success");
        }else {
            modelMap.put("err", "err");
        }
        return modelMap;
    }

}
