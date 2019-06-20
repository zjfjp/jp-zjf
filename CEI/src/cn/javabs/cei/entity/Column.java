package cn.javabs.cei.entity;

public class Column {
    private int cid;
    private String names; //栏目名称

    public int getId() {
        return cid;
    }

    public void setId(int id) {
        this.cid = id;
    }

    public String getName() {
        return names;
    }

    public void setName(String name) {
        this.names = name;
    }

    @Override
    public String toString() {
        return "Column{" +
                "id=" + cid +
                ", name='" + names + '\'' +
                '}';
    }

}
