package com.yang.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/12/12.
 */
public class Team implements Serializable{

    private static final long serialVersionUID = -7460635368366675247L;

    private int id;

    private String name;

    private String postion;

    private String owner;

    private String content;

    private String logo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostion() {
        return postion;
    }

    public void setPostion(String postion) {
        this.postion = postion;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
