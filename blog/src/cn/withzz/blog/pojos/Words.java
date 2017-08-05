package cn.withzz.blog.pojos;

/**
 * Created by shmily_zz on 2017/3/22.
 */

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name="words")
public class Words implements Serializable{
    @Id
    @GeneratedValue
    private Integer id;
    private String content;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @ManyToOne
    private User auther;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getAuther() {
        return auther;
    }

    public void setAuther(User auther) {
        this.auther = auther;
    }
}
