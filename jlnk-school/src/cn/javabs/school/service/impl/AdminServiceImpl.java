package cn.javabs.school.service.impl;

import cn.javabs.school.dao.AdminDao;
import cn.javabs.school.dao.impl.AdminDaoImpl;
import cn.javabs.school.entity.Admin;
import cn.javabs.school.service.AdminService;

public class AdminServiceImpl implements AdminService {
    AdminDao adminDao = new AdminDaoImpl();
    @Override
    public Admin login(String usercode, String password) {
        return adminDao.loginAdmin(usercode,password);
    }
}
