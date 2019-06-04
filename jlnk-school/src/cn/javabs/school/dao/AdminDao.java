package cn.javabs.school.dao;

import cn.javabs.school.entity.Admin;

public interface AdminDao {
    Admin loginAdmin(String usercode, String password);
}
