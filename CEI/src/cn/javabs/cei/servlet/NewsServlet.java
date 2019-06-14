package cn.javabs.cei.servlet;

import cn.javabs.cei.entity.News;
import cn.javabs.cei.service.NewsService;
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

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


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

        request.getRequestDispatcher("/admin/addNews.jsp").forward(request,response);
    }

    /**
     * 数据回显
     * @param request
     * @param response
     */
    private void editNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        int newsId = Integer.parseInt(id);
        News news = newsService.findNewsById(newsId);
        if(news != null){
            request.setAttribute("news",news);
            request.getRequestDispatcher("/admin/updateNews.jsp").forward(request,response);
        }else{
            request.setAttribute("msg","数据回显失败");
            request.getRequestDispatcher("/admin/updateNews.jsp").forward(request,response);
        }


    }

    /**
     * 修改新闻
     * @param request
     * @param response
     */
    private void updateNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        int newsId = Integer.parseInt(id);
        News news = new News();
        try {
        news.setId(newsId);

            BeanUtils.populate(news,request.getParameterMap());
        } catch (Exception e) {
           throw new RuntimeException(e);
    }
        int rows = newsService.updateNews(news);
        if(rows>0){
            request.setAttribute("msg","修改新闻成功");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }else{
            request.setAttribute("msg","修改新闻失败");
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
        if(rows>0){
            request.setAttribute("msg","删除新闻成功");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }else{
            request.setAttribute("msg","删除新闻失败");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }
    }

    /**
     * 查找全部新闻
     * @param request
     * @param response
     */
    private void findAllNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<News> list = newsService.findAllNews();
        request.setAttribute("list",list);
        request.getRequestDispatcher("/admin/NewsList.jsp").forward(request,response);
    }
    /**
     * 添加新闻
     * @param request
     * @param response
     */
    private void addNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        News news = new News();
        try {
            BeanUtils.populate(news,request.getParameterMap());

        int rows = newsService.addNews(news);
        if(rows>0){
            request.setAttribute("msg","添加新闻成功");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }else{
            request.setAttribute("msg","添加新闻失败");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
