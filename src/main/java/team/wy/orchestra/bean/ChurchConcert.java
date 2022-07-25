package team.wy.orchestra.bean;

import java.io.Serializable;

/**
 * @className: ChurchConcert
 * @description: TODO 类描述
 * @author: YORE
 * @date: 2022/7/25
 **/
public class ChurchConcert implements Serializable {

    private long id;
    private long conId;
    private String churchName;

    // Foreign Key
    private Concert concert;

    @Override
    public String toString() {
        return "ChurchConcert{" +
                "id=" + id +
                ", conId=" + conId +
                ", churchName='" + churchName + '\'' +
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

    public String getChurchName() {
        return churchName;
    }

    public void setChurchName(String churchName) {
        this.churchName = churchName;
    }

    public Concert getConcert() {
        return concert;
    }

    public void setConcert(Concert concert) {
        this.concert = concert;
    }
}
