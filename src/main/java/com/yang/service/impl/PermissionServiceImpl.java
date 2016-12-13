package com.yang.service.impl;

import com.yang.dao.PermissionDao;
import com.yang.model.Permission;
import com.yang.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/12/13.
 */
@Service("PermissionServiceImpl")
public class PermissionServiceImpl implements PermissionService{

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<Permission> getAllPermissions() {
        return permissionDao.getAllPermissions();
    }

    @Override
    public int addPermission(Permission permission) {
        return permissionDao.addPermission(permission);
    }
}
