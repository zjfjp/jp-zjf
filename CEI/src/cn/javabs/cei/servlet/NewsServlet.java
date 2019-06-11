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

@WebServlet("/newsServlet")
public class NewsServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //op接收参数
        String op = request.getParameter("op");
        if(op.equals("addNews")){
            addNews(request,response);
        }else if(op.equals("findAllNews")){
            findAllNews(request,response);
        }else if(op.equals("delNews")){
            delNews(request,response);
        }
        else if(op.equals("updateNews")){
            updateNews(request,response);
        }

    }
    //修改新闻
    private void updateNews(HttpServletRequest request, HttpServletResponse response) {

        News news = new News();

        try {
            BeanUtils.populate(news,request.getParameterMap());
            NewsService newsService = new NewsServiceImpl();
            int rows = newsService.updateNews(news);
            if(rows>0){
                response.getWriter().write("");
            }else{
                response.getWriter().write("");

            }

        } catch (Exception e) {
            throw new  RuntimeException(e);

        }
    }
    //删除新闻
    private void delNews(HttpServletRequest request, HttpServletResponse response) {

        News news = new News();

        try {
            BeanUtils.populate(news,request.getParameterMap());
            NewsService newsService = new NewsServiceImpl();
            int rows = newsService.delNews(news);
            if(rows>0){
                response.getWriter().write("");
            }else{
                response.getWriter().write("");

            }

        } catch (Exception e) {
            throw new  RuntimeException(e);

        }

    }
    //查找新闻
    private void findAllNews(HttpServletRequest request, HttpServletResponse response) {

        News news = new News();

        try {
            BeanUtils.populate(news,request.getParameterMap());
            NewsService newsService = new NewsServiceImpl();
            int rows = newsService.findAllNews(news);
            if(rows>0){
                response.getWriter().write("");
            }else{
                response.getWriter().write("");

            }

        } catch (Exception e) {
            throw new  RuntimeException(e);

        }
    }
    //添加新闻
    private void addNews(HttpServletRequest request, HttpServletResponse response) {
        News news = new News();

        try {
            BeanUtils.populate(news,request.getParameterMap());
            NewsService newsService = new NewsServiceImpl();
            int rows = newsService.addNews(news);
            if(rows>0){
                response.getWriter().write("添加新闻成功");
            }else{
                response.getWriter().write("添加新闻失败");

            }

        } catch (Exception e) {
            throw new  RuntimeException(e);

        }

    }
}
