package cn.javabs.cei.entity;

public class News {

    private int id;
    private String title;//新闻标题

    private String author;//作者
    private String content;//新闻内容
    private String createTime;//创建时间
    private int click;//点击量
    private Column columns;//栏目

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getClick() {
        return click;
    }

    public void setClick(int click) {
        this.click = click;
    }

    public Column getColumns() {
        return columns;
    }

    public void setColumns(Column columns) {
        this.columns = columns;
    }

    public String getAuthor() {
        return author;
}

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createTime='" + createTime + '\'' +
                ", click=" + click +
                ", column=" + columns +
                ", author='" + author + '\'' +
                '}';
    }

}