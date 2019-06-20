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
            request.getRequestDispatcher("/admin/editNews.jsp").forward(request,response);
        }else{
            request.setAttribute("SESSION","数据回显失败");
            request.getRequestDispatcher("success.jsp").forward(request,response);
        }


    }

    /**
     * 修改新闻
     * @param request
     * @param response
     */
    private void updateNews(HttpServletRequest request, HttpServletResponse response)  {



        String id = request.getParameter("id");
        int newsId = Integer.parseInt(id);
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String author = request.getParameter("author");
        String content = request.getParameter("content");
        String createTime = request.getParameter("createTime");


        News news = new News();

        news.setId(newsId);
        news.setTitle(title);
        news.setDescription(description);
        news.setContent(content);
        news.setAuthor(author);
        news.setCreateTime(createTime);

        try {
            int rows = newsService.updateNews(news);

            if (rows > 0) {
                request.setAttribute("SESSION", "修改新闻数据成功！");
                request.getRequestDispatcher("/success.jsp").forward(request,
                        response);
            } else {
                request.setAttribute("SESSION", "修改新闻数据失败！");
                request.getRequestDispatcher("/success.jsp").forward(request,
                        response);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
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
    private void findAllNews(HttpServletRequest request, HttpServletResponse response)  {

        List<News> list = newsService.findAllNews();
        System.out.println(list);
        if (list!=null&&list.size()>0){
            request.setAttribute("list",list);
            try {
                request.getRequestDispatcher("/admin/findAllNews.jsp").forward(request,response);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }else {
            request.setAttribute("SESSION","查询失败");
            try {
                request.getRequestDispatcher("/success.jsp").forward(request,response);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
       /**
     * 添加新闻
     * @param request
     * @param response
     */
    private void addNews(HttpServletRequest request, HttpServletResponse response)  {

        News news = new News();
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String description = request.getParameter("description");
        String author = request.getParameter("author");
        String createTime = request.getParameter("createTime");

        news.setTitle(title);
        news.setContent(content);
        news.setDescription(description);
        news.setAuthor(author);
        news.setCreateTime(createTime);
        System.out.println(news);

        int rows = newsService.addNews(news);
        if (rows>0){
            request.setAttribute("SESSION","添加成功");
            try {
                request.getRequestDispatcher("/success.jsp").forward(request,response);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }else {
            request.setAttribute("SESSION","添加失败");
            try {
                request.getRequestDispatcher("/success.jsp").forward(request,response);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);

    }
}
