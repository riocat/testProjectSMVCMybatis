package com.yang.service.impl;

import junit.framework.TestCase;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/12/15.
 */
public class RoleServiceImplTest extends TestCase {

    public void testAddRole() throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"core.xml"});
        RoleServiceImpl ri = (RoleServiceImpl) context.getBean("RoleServiceImpl");
        ri.addRole("a", Arrays.asList(1,2));
        System.out.println();
    }
}