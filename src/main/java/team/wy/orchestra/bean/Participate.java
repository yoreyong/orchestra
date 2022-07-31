package team.wy.orchestra.bean;

import java.io.Serializable;

/**
 * @className: Participates
 * @description:
 * @author: YORE
 * @date: 2022/7/30
 **/
public class Participate implements Serializable {

    private long id;
    private String SSN;
    private long conId;

    // Foreign Key
    private Musician musician;
    private Concert concert;

    @Override
    public String toString() {
        return "Participates{" +
                "id=" + id +
                ", SSN='" + SSN + '\'' +
                ", conId=" + conId +
                ", musician=" + musician +
                ", concert=" + concert +
                '}';
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public long getConId() {
        return conId;
    }

    public void setConId(long conId) {
        this.conId = conId;
    }

    public Musician getMusician() {
        return musician;
    }

    public void setMusician(Musician musician) {
        this.musician = musician;
    }

    public Concert getConcert() {
        return concert;
    }

    public void setConcert(Concert concert) {
        this.concert = concert;
    }
}
