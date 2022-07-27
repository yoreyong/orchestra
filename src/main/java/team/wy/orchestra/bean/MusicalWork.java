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
    private long typeId;
    private String desc;

    private MusicalWorkType type;

    @Override
    public String toString() {
        return "MusicalWork{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", typeId=" + typeId +
                ", desc='" + desc + '\'' +
                ", type=" + type +
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

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public MusicalWorkType getType() {
        return type;
    }

    public void setType(MusicalWorkType type) {
        this.type = type;
    }
}
