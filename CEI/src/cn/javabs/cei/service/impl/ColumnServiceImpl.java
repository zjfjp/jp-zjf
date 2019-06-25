package cn.javabs.cei.service.impl;

import cn.javabs.cei.commons.Page;
import cn.javabs.cei.dao.ColumnDao;
import cn.javabs.cei.dao.impl.ColumnDaoImpl;
import cn.javabs.cei.entity.Column;
import cn.javabs.cei.entity.News;
import cn.javabs.cei.service.ColumnService;

import java.util.List;
import java.util.UUID;

public class ColumnServiceImpl implements ColumnService {
    ColumnDao columnDao = new ColumnDaoImpl();

    @Override
    public Page findAllNews(String pagenumber) {
        int currentPagenum = 1;

        if (pagenumber != null) {
            //currentPagenum 是 前台jsp 传入给servlet ，此时变成了字符串 故此处需要转换成为int
            currentPagenum = Integer.parseInt(pagenumber);
        }
        // 拿到总的记录条数
        //  7
        int totalRecords = columnDao.findAllNewsNumber();

        Page page = new Page(currentPagenum, totalRecords);
        /*
         * 分页的条数
         */
        List<News> records = columnDao.findAllNewsRecords(page.getStartIndex(), page.getPageSize());
        // 把分页条数 封装到page里去
        page.setRecords(records);

        System.out.println("page = " + page);

        return page;
    }

    @Override
    public List<Column> findAllColumn() {
        return columnDao.getAllColumn();
    }

    @Override
    public Page findAllNewsPageRecords(String pagenumber, String columnId) {
        int currentPagenum = 1;

        if (pagenumber != null) {

            currentPagenum = Integer.parseInt(pagenumber);
        }
        int totalRecords = columnDao.findPageNewsNumber(columnId);
        Page page = new Page(currentPagenum, totalRecords);
        List<News> records = columnDao.findPageNews(page.getStartIndex(), page.getPageSize(), columnId);
        page.setRecords(records);
        System.out.println("page=" + page);
        return page;
    }

    @Override
    public void addColumn(Column column) {

        column.setCid(UUID.randomUUID().toString());
        columnDao.save(column);
    }

    @Override
    public void editColumn(Column column) {

        columnDao.updateColumn(column);
    }

    @Override
    public Column findColumnById(String id) {
        columnDao.getColumnById(id);
        return null;
    }


    @Override
    public void delColumn(String columnId) {

        columnDao.removeColumn(columnId);
    }
}
