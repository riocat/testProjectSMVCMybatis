package com.yang.service.impl;

import com.yang.dao.RoleDao;
import com.yang.model.Role;
import com.yang.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/15.
 */
@Service("RoleServiceImpl")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public int addRole(String name, List<Integer> pids) {
        Role temp = new Role();
        temp.setRoleName(name);
        roleDao.addRole(temp);
        for (int id : pids) {
            Map<String,Object> pMap = new HashMap<String,Object>();
            pMap.put("id",temp.getId());
            pMap.put("pid",id);
            roleDao.addRolePermission(pMap);
        }
        return 0;
    }
}
