package cn.javabs.cei.servlet;

import cn.javabs.cei.entity.Columns;
import cn.javabs.cei.entity.News;
import cn.javabs.cei.service.ColumnsService;
import cn.javabs.cei.service.NewsService;
import cn.javabs.cei.service.impl.ColumnsServiceImpl;
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
    ColumnsService columnsService=new ColumnsServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html,charset=utf-8");

        //op接收参数
        String op = request.getParameter("op");
        //op与addNews相等
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
        }else if(op.equals("findNewsByLike")){
            findNewsByLike(request,response);
        }else if(op.equals("findNewsByName")){
            findNewsByName(request,response);
        }else if(op.equals("findNewsById")) {
            findNewsById(request,response);
        }
        //数据回显
        else if (op.equals("editNews")) {
            editNews(request, response);
        } else {
            System.out.println("参数传递有误！");
        }

    }

    /**
     * id查询
     * @param request
     * @param response
     */
    private void findNewsById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        int newsId=Integer.parseInt(id);
        News news=newsService.findNewsById(newsId);
        System.out.println(news);
        if (news!=null){
            request.setAttribute("news",news);
            request.getRequestDispatcher("/News/IdList.jsp").forward(request,response);
        }
        else{
            request.setAttribute("msg","新闻根据ID查询失败");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }
    }

    /**
     *模糊查询
     * @param request
     * @param response
     */
    private void findNewsByLike(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String author = request.getParameter("author");
        int name =Integer.parseInt(author);
        News news= newsService.findNewsByLike(author);
        System.out.println(news);

        if(news != null){
            request.setAttribute("news",news);
            request.getRequestDispatcher("/News/IdList.jsp").forward(request,response);
        }  else{
            request.setAttribute("msg","新闻根据模糊查询失败");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }
    }

    /**
     * 名字查询
     * @param request
     * @param response
     */
    private void findNewsByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String author= request.getParameter("author");
        News news=newsService.findNewsByName(author);

        if ( news !=null ){
            request.setAttribute("news",news);
            request.getRequestDispatcher("/News/IdList.jsp").forward(request,response);
        }
        else{
            request.setAttribute("msg","新闻根据作者查询失败");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }
    }

    /**
     * 去添加新闻页面的方法
     * @param request
     * @param response
     */
    private void goToAddNewsView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Columns> list = columnsService.findAllColumns();
        request.setAttribute("list",list);
        request.getRequestDispatcher("/News/addNews.jsp").forward(request,response);
    }

    /**
     * 数据回显
     * @param request
     * @param response
     */
    private void editNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Columns> list = columnsService.findAllColumns();
        request.setAttribute("list",list);

        String id = request.getParameter("id");
        System.out.println("id:"+id);
        int  newsId = Integer.parseInt(id);
        System.out.println("newsId:"+newsId);
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

        List<Columns> list = columnsService.findAllColumns();
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
        List<Columns> columns = columnsService.findAllColumns();
        request.setAttribute("columns",columns);
        System.out.println(columns);
        if (list != null && list.size() >0){
            request.setAttribute("list",list);
            request.getRequestDispatcher("/News/news.jsp").forward(request,response);
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
            int rows=newsService.addNews(news);
            if (rows>0){
                request.setAttribute("msg","添加新闻成功");
                request.getRequestDispatcher("/message.jsp").forward(request,response);
            }else {
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

