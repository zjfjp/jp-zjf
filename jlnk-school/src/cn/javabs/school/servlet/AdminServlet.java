package cn.javabs.school.servlet;

import cn.javabs.school.entity.Admin;
import cn.javabs.school.service.AdminService;
import cn.javabs.school.service.impl.AdminServiceImpl;
import cn.javabs.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet( "/adminServlet")

public class AdminServlet extends BaseServlet {
//实例化AdminService
    AdminService adminService = new AdminServiceImpl();
//    用户登录
    protected String userLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String usercode = request.getParameter("usercode");
        String password = request.getParameter("password");



        if(!usercode.equalsIgnoreCase("") || !password.equalsIgnoreCase("") || usercode != null || password != null){
            //传递用户名和密码到adminService、返回一个admin对象 属于admin类型
            Admin admin = adminService.login(usercode,password);

           if(admin != null) {
               //通过请求对象获取session【云端缓存】
               request.getSession().setAttribute("ADMIN_SESSION",admin);

               return "forword:/main.jsp";
           }else{
               return "redirect:/login.jsp";
           }
        }else{
            request.setAttribute("msg","用户名或者密码不许为空");
            return "forword:/message.jsp";
        }
    }
//    用户注销
    protected String userLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        return "";
    }
}
