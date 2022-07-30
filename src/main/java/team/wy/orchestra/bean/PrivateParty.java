package team.wy.orchestra.bean;

import java.io.Serializable;

/**
 * @className: PrivateParty
 * @description:
 * @author: YORE
 * @date: 2022/7/25
 **/
public class PrivateParty implements Serializable {

    private long id;
    private long conId;

    // Foreign Key
    private Concert concert;

    @Override
    public String toString() {
        return "PrivateParty{" +
                "id=" + id +
                ", conId=" + conId +
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

    public Concert getConcert() {
        return concert;
    }

    public void setConcert(Concert concert) {
        this.concert = concert;
    }
}
