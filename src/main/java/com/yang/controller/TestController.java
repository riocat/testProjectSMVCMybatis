package com.yang.controller;

import com.yang.dao.PermissionDao;
import com.yang.model.Permission;
import com.yang.model.Team;
import com.yang.service.PermissionService;
import com.yang.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/12.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TeamService teamService;

    @Autowired
    private PermissionService permissionService;

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

    @RequestMapping("/getZtreeData")
    @ResponseBody
    public Map<String, Object> getZtreeData() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Permission> lists = permissionService.getAllPermissions();
        map.put("data", lists);
        map.put("result", "success");
        return map;
    }

    @RequestMapping("/addTreeNode")
    @ResponseBody
    public Map<String, Object> addTreeNode(@RequestBody Permission permission) {
        Map<String, Object> map = new HashMap<String, Object>();
        int num = permissionService.addPermission(permission);
        if (num == 1) {
            map.put("result", "success");
        }
        return map;
    }

    @RequestMapping("/toAddRole")
    public String toAddRole() {
        return "/addRole";
    }
}
