package team.wy.orchestra.bean;

import java.io.Serializable;

/**
 * @className: MusicalWork
 * @description: Musical Work Class
 * @author: YORE
 * @date: 2022/7/25
 **/
public class MusicalWork implements Serializable {
    private long id;
    private String name;
    private String author;
    private String desc;

    @Override
    public String toString() {
        return "MusicalWork{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
