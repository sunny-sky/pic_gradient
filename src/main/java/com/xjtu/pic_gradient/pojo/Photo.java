package com.xjtu.pic_gradient.pojo;

public class Photo {
    private Integer id;

    private String photoname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhotoname() {
        return photoname;
    }

    public void setPhotoname(String photoname) {
        this.photoname = photoname == null ? null : photoname.trim();
    }
}