package cn.javabs.cei.entity;

import java.io.Serializable;

public class Columns implements Serializable {
    private String cid;//栏目id
    private String name; //栏目名称

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Columns{" +
                "cid=" + cid +
                ", name='" + name + '\'' +
                '}';
    }
}
