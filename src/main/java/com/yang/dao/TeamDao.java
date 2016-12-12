package com.yang.dao;

import com.yang.model.Team;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2016/12/12.
 */
@Repository
public interface TeamDao {

    public List<Team> findAllTeams();
}
