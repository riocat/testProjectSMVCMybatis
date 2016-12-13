package com.yang.controller;

import com.yang.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2016/12/12.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TeamService teamService;

    @RequestMapping("/findAllTeams")
    public ModelAndView findAllTeams() {
        ModelAndView mav = new ModelAndView("/showTeamsNum");
        mav.addObject("num", teamService.findAllTeams().size());
        return mav;
    }

    @RequestMapping("/toZtree")
    public String toZtree() {
        return "/toZtree";
    }

}
