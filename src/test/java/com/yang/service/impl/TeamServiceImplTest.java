package com.yang.service.impl;

import com.yang.model.Team;
import junit.framework.TestCase;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Administrator on 2016/12/12.
 */
public class TeamServiceImplTest extends TestCase {

    public void testFindAllTeams() throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"core.xml"});
        TeamServiceImpl ti = (TeamServiceImpl) context.getBean("TeamServiceImpl");
        List<Team> list = ti.findAllTeams();
        System.out.println(list.size());
    }
}