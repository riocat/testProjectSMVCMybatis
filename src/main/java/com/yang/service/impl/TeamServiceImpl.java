package com.yang.service.impl;

import com.yang.dao.TeamDao;
import com.yang.model.Team;
import com.yang.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/12/12.
 */
@Service("TeamServiceImpl")
public class TeamServiceImpl implements TeamService{

    @Autowired
    private TeamDao teamDao;

    @Override
    public List<Team> findAllTeams() {
        return teamDao.findAllTeams();
    }
}
