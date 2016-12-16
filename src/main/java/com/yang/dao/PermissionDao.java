package com.yang.dao;

import com.yang.model.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2016/12/13.
 */
public interface PermissionDao {

    List<Permission> getAllPermissions();

    int addPermission(Permission permission);

    List<Permission> getPermissionsByRoleId(int rid);

    List<Permission> getAllParents();
}
