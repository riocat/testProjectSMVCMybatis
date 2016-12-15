package com.yang.service;

import java.util.List;

/**
 * Created by Administrator on 2016/12/15.
 */
public interface RoleService {

    int addRole(String name,List<Integer> pids);
}
