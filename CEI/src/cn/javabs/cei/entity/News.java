package cn.javabs.cei.entity;

public class News {

    private int id;//新闻id
    private String title; //新闻标题
    private String author;//新闻作者
    private String content;//新闻内容
    private int click;//新闻点击量
    private String createTime;//创建新闻时间
    private String columnid;//栏目id
    private String name;//栏目名称

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getClick() {
        return click;
    }

    public void setClick(int click) {
        this.click = click;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getColumnid() {
        return columnid;
    }

    public void setColumnid(String columnid) {
        this.columnid = columnid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", click=" + click +
                ", createTime='" + createTime + '\'' +
                ", columnid='" + columnid + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}