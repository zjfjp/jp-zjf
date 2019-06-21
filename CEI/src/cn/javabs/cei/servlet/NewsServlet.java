package cn.javabs.cei.servlet;

import cn.javabs.cei.entity.Column;
import cn.javabs.cei.entity.News;
import cn.javabs.cei.service.ColumnService;
import cn.javabs.cei.service.NewsService;
import cn.javabs.cei.service.impl.ColumnServiceImpl;
import cn.javabs.cei.service.impl.NewsServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@WebServlet("/newsServlet")
public class NewsServlet extends HttpServlet {

    NewsService newsService = new NewsServiceImpl();
    ColumnService columnService=new ColumnServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html,charset=utf-8");

        //op接收参数
        String op = request.getParameter("op");
        if (op.equals("addNews")) {
            addNews(request, response);
        } else if (op.equals("findAllNews")) {
            findAllNews(request, response);
        } else if (op.equals("delNews")) {
            delNews(request, response);
        } else if (op.equals("updateNews")) {
            updateNews(request, response);
        } else if (op.equals("goToAddNewsView")) {
            goToAddNewsView(request, response);
        }
        //数据回显
        else if (op.equals("editNews")) {
            editNews(request, response);
        } else {
            System.out.println("参数传递有误！");
        }

    }

    /**
     * 去添加新闻页面的方法
     * @param request
     * @param response
     */
    private void goToAddNewsView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      List<Column> list = columnService.findAllColumn();
      request.setAttribute("list",list);
        request.getRequestDispatcher("/admin/addNews.jsp").forward(request,response);
    }

    /**
     * 数据回显
     * @param request
     * @param response
     */
    private void editNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Column> list = columnService.findAllColumn();
        request.setAttribute("list",list);

        String id = request.getParameter("id");
        System.out.println("id:"+id);
        int  newsId = Integer.parseInt(id);
        System.out.println("userId:"+newsId);
        News news = newsService.findNewsById(newsId);
        System.out.println("news:"+news);


        if (news != null){
            request.setAttribute("news",news);
            request.getRequestDispatcher("/News/updateNews.jsp").forward(request,response);
        }else{
            request.setAttribute("msg","用户数据回显失败");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }

    }

    /**
     * 修改新闻
     * @param request
     * @param response
     */
    private void updateNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id=request.getParameter("id");
        int newsId=Integer.parseInt(id);
        News news =new News();

        List<Column> list = columnService.findAllColumn();
        request.setAttribute("list",list);

        try {
            news.setId(newsId);
            BeanUtils.populate(news,request.getParameterMap());
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        System.out.println("news:"+news);
        int rows=newsService.updateNews(news);
        if (rows>0){
            request.setAttribute("msg","修改成功");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }else {
            request.setAttribute("msg","修改失败");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }
    }
    /**
     * 删除新闻
     * @param request
     * @param response
     */
    private void delNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String id = request.getParameter("id");
        int newsId = Integer.parseInt(id);
        int rows = newsService.delNews(newsId);
        if (rows > 0) {
            request.setAttribute("msg", "删除新闻成功");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
        } else {
            request.setAttribute("msg", "删除新闻失败");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
        }
    }


    /**
     * 查找全部新闻
     * @param request
     * @param response
     */
    private void findAllNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<News> list = newsService.findAllNews();
        System.out.println("list="+list);
        List<Column> columns = columnService.findAllColumn();
        request.setAttribute("columns",columns);
        if (list != null && list.size() >0){
            request.setAttribute("list",list);
            request.getRequestDispatcher("/admin/news.jsp").forward(request,response);
        }else{
            request.setAttribute("msg","error");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }
    }
       /**
     * 添加新闻
     * @param request
     * @param response
     */
    private void addNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        News news =new News();



        try {
            BeanUtils.populate(news,request.getParameterMap());
            int rows=newsService.addNews(news);;


            if (rows>0){
                request.setAttribute("msg","success");
                request.getRequestDispatcher("/message.jsp").forward(request,response);
            }else {
                request.setAttribute("msg","error");
                request.getRequestDispatcher("/message.jsp").forward(request,response);
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);

    }
}
