package cn.javabs.cei.servlet;

import cn.javabs.cei.commons.Page;
import cn.javabs.cei.entity.Column;
import cn.javabs.cei.service.ColumnService;
import cn.javabs.cei.service.impl.ColumnServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/columnServlet")
public class ColumnServlet extends HttpServlet {

    ColumnService columnService=new ColumnServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("textml ;charset = utf-8 ");

        //接收参数op
        String op =request.getParameter("op");

        if ("delColumn".equals(op)){
            delColumn(request,response);
        }else if ("editColumnView".equals(op)){
            editColumnView(request,response);
        }else if ("editColumn".equals(op)){
            editColumn(request,response);
        }else if ("addColumn".equals(op)){
            addColumn(request,response);
        }else if ("showColumnNews".equals(op)){
            showColumnNews(request,response);
        }else if  ("findAllColumn".equals(op)){
            findAllColumn(request,response);
        }else if ("showIndex".equals(op)){
            showIndex(request,response);
        }

    }
    /**
     * 添加栏目
     * @param request
     * @param response
     */
    private void addColumn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 1. 创建一个分类的对象
        Column column = new Column();
        // 2. 接收了前台的name属性
        String name = request.getParameter("name");
        // 3. 通过对象 封装到 description
        column.setName(name);
        System.out.println("分类" + column);
        // 分类 哈希值
        System.out.println("分类名称：" + column.getName());
        columnService.addColumn(column);
        // 添加一个成功的提示信息 ，临时性将“添加分类成功” 存放到msg
        // 设置一个标记 为msg （自个取得名字） 讲我想要的提示信息 放在后面的参数中
        request.setAttribute("msg", "添加分类成功！");
        // 转发到message的jsp页面，通过msg 讲存入进的“添加分类成功”信息取出来
        request.getRequestDispatcher("/message.jsp").forward(request, response);
    }

    /**
     * 按照栏目查询新闻
     * @param request
     * @param response
     */
    private void showColumnNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pagenumber = request.getParameter("pagenumber");
        String columnId = request.getParameter("columnId");
        List<Column> cs = columnService.findAllColumn();
        Page page = columnService.findAllNewsPageRecords(pagenumber,columnId);
        page.setUrl("columnServlet?op=showColumnNews&columnId="+columnId);

        request.setAttribute("page",page);
        request.setAttribute("cs",cs);
        request.getRequestDispatcher("showAllNews.jsp").forward(request,response);

    }

    /**
     * 查询所有栏目
     * @param request
     * @param response
     */
    private void findAllColumn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Column> cs = columnService.findAllColumn();
        request.setAttribute("cs",cs);
        request.getRequestDispatcher("columnList.jsp").forward(request,response);
    }

    /**
     * 展示一个首页
     * @param request
     * @param response
     */
    private void showIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pagenumber = request.getParameter("pagenumber");
        Page page = columnService.findAllNews(pagenumber);
        page.setUrl("columnServlet?op=showIndex");
        List<Column> cs = columnService.findAllColumn();
        request.setAttribute("page",page);
        request.setAttribute("cs",cs);
        request.getRequestDispatcher("/showAllNews.jsp").forward(request,response);
    }

    /**
     * 编辑栏目  更新内容
     * @param request
     * @param response
     */
    private void editColumn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Column column = new Column();

            BeanUtils.populate(column, request.getParameterMap());

            System.out.println("id" + column.getCid());
            columnService.editColumn(column);
            request.setAttribute("msg", "修改分类成功！");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *编辑栏目   回显数据
     * @param request
     * @param response
     */
    private void editColumnView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String columnId = request.getParameter("columnId");

        Column cs = columnService.findColumnById(columnId);

        request.setAttribute("cs", cs);

        request.getRequestDispatcher("/edit.jsp").forward(request, response);
    }


    /**
     * 删除栏目
     * @param request
     * @param response
     */
    private void delColumn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String columnId = request.getParameter("columnId");

        if (columnId != null && !"".equals(columnId)) {
            columnService.delColumn(columnId);
            request.setAttribute("msg", "删除栏目成功！");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
            return;
        }
        System.out.println("是不是空");
        response.sendRedirect(request.getContextPath() + "/error.jsp");
    }
}
