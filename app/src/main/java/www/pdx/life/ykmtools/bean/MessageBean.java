package www.pdx.life.ykmtools.bean;

/**
 * Created by wenxin on 2017/3/10.
 */

public class MessageBean {

    public String title;
    public String content;
    public long comment;
    public long read;

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

    public long getComment() {
        return comment;
    }

    public void setComment(long comment) {
        this.comment = comment;
    }

    public long getRead() {
        return read;
    }

    public void setRead(long read) {
        this.read = read;
    }

    public MessageBean(String title, String content, long comment, long read) {
        this.title = title;
        this.content = content;
        this.comment = comment;
        this.read = read;
    }
}
