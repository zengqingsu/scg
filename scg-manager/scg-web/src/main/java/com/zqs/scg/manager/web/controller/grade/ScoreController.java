package com.zqs.scg.manager.web.controller.grade;

import com.zqs.scg.manager.service.grade.IscoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author; zengqinghsu
 * @Description:
 * @Date:Created in 2017/11/30 15:45
 */
@Controller
public class ScoreController {
    @Autowired(required = false)
    private IscoreService scoreService;

    @RequestMapping(value = "/getScoreReport")
    public String getScore(){

    return null;
    }

}
