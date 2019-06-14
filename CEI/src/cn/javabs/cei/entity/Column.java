package cn.javabs.cei.entity;
/***
 * 栏目
 */

public class Column {

    private int id;
    private String Cname;//栏目名称
    private String Ctime;//栏目创建时间

    @Override
    public String toString() {
        return "Column{" +
                "id=" + id +
                ", Cname='" + Cname + '\'' +
                ", Ctime='" + Ctime + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public String getCtime() {
        return Ctime;
    }

    public void setCtime(String ctime) {
        Ctime = ctime;
    }
}
