package cn.javabs.school.entity;
/**
 * 管理员
 *
 * type表示用户管理权限类型 管理员和信息发布员
 * */
public class Admin {

    private Integer id;
    private String name;
    private String usercode;
    private String password;
    private String birthday;
    private String type;
    //状态  0表示可使用的账号
    private int status;

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", usercode='" + usercode + '\'' +
                ", password='" + password + '\'' +
                ", birthday='" + birthday + '\'' +
                ", type='" + type + '\'' +
                ", status=" + status +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
