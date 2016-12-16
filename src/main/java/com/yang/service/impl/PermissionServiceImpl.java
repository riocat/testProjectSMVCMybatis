package com.yang.service.impl;

import com.yang.dao.PermissionDao;
import com.yang.model.Permission;
import com.yang.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Administrator on 2016/12/13.
 */
@Service("PermissionServiceImpl")
public class PermissionServiceImpl implements PermissionService {

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

    @Override
    public List<Permission> getRolePermission(int rid) {
        List<Permission> permissions = permissionDao.getPermissionsByRoleId(1);
        List<Permission> parents = permissionDao.getAllParents();
        Permission root = permissions.remove(0);
        Map<String, Permission> targetMap = new HashMap<String, Permission>();
        targetMap.put(String.valueOf(root.getId()), root);
        for (Permission p : permissions) {
            targetMap.put(String.valueOf(p.getId()), p);
            getMenuData(p, parents, root, targetMap);
        }
        List<Permission> result = new ArrayList<Permission>(targetMap.values());
        return result;
    }

    private void getMenuData(Permission p, List<Permission> parents, Permission root, Map<String, Permission> targetMap) {
        if (p.getpId() == root.getId()) {
            return;
        } else {
            Permission parent = getParentPermission(p, parents);
            if (parent == null)
                return;
            if (targetMap.containsKey(String.valueOf(p.getpId()))) {
                return;
            } else {
                targetMap.put(String.valueOf(parent.getId()), parent);
                getMenuData(parent, parents, root, targetMap);
            }
        }
    }

    private Permission getParentPermission(Permission p, List<Permission> parents) {
        for (Permission temp : parents) {
            if (p.getpId() == temp.getId()) {
                return temp;
            }
        }
        return null;
    }
}
