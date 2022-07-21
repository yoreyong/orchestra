package team.wy.orchestra.bean;

import java.io.Serializable;

/**
 * @className: Instrument
 * @description:
 * @author: YORE
 * @date: 2022/7/17
 **/
public class Instrument implements Serializable {
    private long id;
    private String name;
    private String type;
    private boolean status;

    @Override
    public String toString() {
        return "Instrument{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", status=" + status +
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
