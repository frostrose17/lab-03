/*
// file name: City.java
Classname: CMPUT301
Version information: first version
Date: January 13rd, 2026
Copyright: Kyumin Park
*/

package com.example.listylist;

import java.io.Serializable;

public class City implements Serializable {
    private String name;
    private String province;

    public void setName(String name) {
        this.name = name;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public City(String name, String province) {
        this.name =name;
        this.province = province;
    }

    public String getName() {
        return name;
    }

    public String getProvince() {
        return province;
    }
}
