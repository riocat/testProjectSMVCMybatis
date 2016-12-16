package com.yang.service.impl;

import com.yang.model.Permission;
import junit.framework.TestCase;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


/**
 * Created by Administrator on 2016/12/13.
 */
public class PermissionServiceImplTest extends TestCase {

    public void testGetAllPermissions() throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"core.xml"});
        PermissionServiceImpl pi = (PermissionServiceImpl) context.getBean("PermissionServiceImpl");
        List<Permission> list = pi.getAllPermissions();
        System.out.println(list.size());
    }

    public void testGetAllPermissions1() throws Exception {

    }

    public void testAddPermission() throws Exception {

    }

    public void testGetRolePermission() throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"core.xml"});
        PermissionServiceImpl pi = (PermissionServiceImpl) context.getBean("PermissionServiceImpl");
        List<Permission> list = pi.getRolePermission(1);
        System.out.println(list.size());
    }
}