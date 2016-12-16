package com.yang.dao;

import com.yang.model.Role;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/15.
 */
public interface RoleDao {

    int addRole(Role role);

    int addRolePermission(Map<String,Object> map);
}
