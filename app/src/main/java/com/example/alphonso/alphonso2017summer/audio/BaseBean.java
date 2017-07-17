package com.example.alphonso.alphonso2017summer.audio;

import java.io.Serializable;
import java.io.SerializablePermission;



public class BaseBean implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
