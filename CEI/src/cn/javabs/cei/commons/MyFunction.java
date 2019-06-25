package cn.javabs.cei.commons;

import cn.javabs.cei.entity.Column;
import cn.javabs.cei.service.ColumnService;
import cn.javabs.cei.service.impl.ColumnServiceImpl;

public class MyFunction {
    public static ColumnService service = new ColumnServiceImpl();

    public static String  showColumnName(String columnId){
        Column column =service.findColumnById(columnId);

        if (column != null){
            return column.getName();

        }
        return null;
    }

}
