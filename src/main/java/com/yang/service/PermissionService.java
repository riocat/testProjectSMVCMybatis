package com.yang.service;

import com.yang.model.Permission;

import java.util.List;

/**
 * Created by Administrator on 2016/12/13.
 */
public interface PermissionService {

    List<Permission> getAllPermissions();

    int addPermission(Permission permission);

    List<Permission> getRolePermission(int rid);
}
