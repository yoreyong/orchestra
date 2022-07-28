package team.wy.orchestra.bean;

import java.io.Serializable;

/**
 * @className: OutdoorParty
 * @description:
 * @author: YORE
 * @date: 2022/7/25
 **/
public class OutdoorParty implements Serializable {

    private long id;
    private long conId;
    private String type;

    // Foreign Key
    private Concert concert;

    @Override
    public String toString() {
        return "OutdoorParty{" +
                "id=" + id +
                ", conId=" + conId +
                ", type='" + type + '\'' +
                ", concert=" + concert +
                '}';
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getConId() {
        return conId;
    }

    public void setConId(long conId) {
        this.conId = conId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Concert getConcert() {
        return concert;
    }

    public void setConcert(Concert concert) {
        this.concert = concert;
    }
}
