package cn.javabs.cei.entity;

import java.io.Serializable;

public class Column implements Serializable {
    private String cid;
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
        return "Column{" +
                "cid=" + cid +
                ", name='" + name + '\'' +
                '}';
    }
}
