package team.wy.orchestra.bean;

import java.io.Serializable;

/**
 * @className: MusicalWorkType
 * @description:
 * @author: YORE
 * @date: 2022/7/26
 **/
public class MusicalWorkType implements Serializable {
    private long id;
    private String name;
    private long parentId;

    @Override
    public String toString() {
        return "MusicalWorkType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentId=" + parentId +
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

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }
}
