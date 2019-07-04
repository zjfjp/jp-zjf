package cn.javabs.cei.servlet;

import cn.javabs.cei.commons.Page;
import cn.javabs.cei.entity.Columns;
import cn.javabs.cei.service.ColumnsService;
import cn.javabs.cei.service.impl.ColumnsServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/columnsServlet")
public class ColumnsServlet extends HttpServlet {

    ColumnsService columnsService=new ColumnsServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("textml ;charset = utf-8 ");

        //接收参数op
        String op =request.getParameter("op");

        if ("delColumns".equals(op)){
            delColumns(request,response);
        }else if ("editColumnsView".equals(op)){
            editColumnsView(request,response);
        }else if ("editColumns".equals(op)){
            editColumns(request,response);
        }else if ("addColumns".equals(op)){
            addColumns(request,response);
        }else if ("showColumnsNews".equals(op)){
            showColumnsNews(request,response);
        }else if  ("findAllColumns".equals(op)){
            findAllColumns(request,response);
        }else if ("showIndex".equals(op)){
            showIndex(request,response);
        }

    }
    /**
     * 添加栏目
     * @param request
     * @param response
     */
    private void addColumns(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 1. 创建一个分类的对象
        Columns columns = new Columns();
        // 2. 接收了前台的name属性
        String name = request.getParameter("name");
        // 3. 通过对象 封装到 description
        columns.setName(name);
        System.out.println("分类" + columns);
        // 分类 哈希值
        System.out.println("分类名称：" + columns.getName());
        columnsService.addColumns(columns);
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
    private void showColumnsNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pagenumber = request.getParameter("pagenumber");
        String columnId = request.getParameter("columnId");
        List<Columns> cs = columnsService.findAllColumns();
        Page page = columnsService.findAllNewsPageRecords(pagenumber,columnId);
        page.setUrl("columnsServlet?op=showColumnsNews&columnId="+columnId);

        request.setAttribute("page",page);
        request.setAttribute("cs",cs);
        request.getRequestDispatcher("showAllNews.jsp").forward(request,response);

    }

    /**
     * 查询所有栏目
     * @param request
     * @param response
     */
    private void findAllColumns(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Columns> cs = columnsService.findAllColumns();
        request.setAttribute("cs",cs);
        request.getRequestDispatcher("columnsList.jsp").forward(request,response);
    }

    /**
     * 展示一个首页
     * @param request
     * @param response
     */
    private void showIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pagenumber = request.getParameter("pagenumber");
        Page page = columnsService.findAllNews(pagenumber);
        page.setUrl("columnsServlet?op=showIndex");
        List<Columns> cs = columnsService.findAllColumns();
        request.setAttribute("page",page);
        request.setAttribute("cs",cs);
        request.getRequestDispatcher("/showAllNews.jsp").forward(request,response);
    }

    /**
     * 编辑栏目  更新内容
     * @param request
     * @param response
     */
    private void editColumns(HttpServletRequest request, HttpServletResponse response)  {
        try {
            Columns columns = new Columns();

            BeanUtils.populate(columns, request.getParameterMap());

             columnsService.editColumns(columns);
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
    private void editColumnsView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String columnId = request.getParameter("columnId");

        Columns cs = columnsService.findColumnsById(columnId);

        request.setAttribute("cs", cs);

        request.getRequestDispatcher("/edit.jsp").forward(request, response);
    }


    /**
     * 删除栏目
     * @param request
     * @param response
     */
    private void delColumns(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String columnId = request.getParameter("columnId");

        if (columnId != null && !"".equals(columnId)) {
            columnsService.delColumns(columnId);
            request.setAttribute("msg", "删除栏目成功！");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
            return;
        }
        System.out.println("是不是空");
        response.sendRedirect(request.getContextPath() + "/error.jsp");
    }
}
