package com.yang.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/12/15.
 */
public class Role implements Serializable {

    private static final long serialVersionUID = -5738430628309764773L;

    private int id;

    private String roleName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
