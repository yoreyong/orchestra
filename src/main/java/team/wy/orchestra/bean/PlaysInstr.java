package team.wy.orchestra.bean;

import java.io.Serializable;

/**
 * @className: MusicianPlaysInstru
 * @description:
 * @author: YORE
 * @date: 2022/7/31
 **/
public class PlaysInstr implements Serializable {

    private long id;
    private String SSN;
    private long instrNum;

    // Foreign key
    private Musician musician;
    private Instrument instrument;

    @Override
    public String toString() {
        return "MusicianPlaysInstru{" +
                "id=" + id +
                ", SSN='" + SSN + '\'' +
                ", instrNum=" + instrNum +
                ", musician=" + musician +
                ", instrument=" + instrument +
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

    public long getInstrNum() {
        return instrNum;
    }

    public void setInstrNum(long instrNum) {
        this.instrNum = instrNum;
    }

    public Musician getMusician() {
        return musician;
    }

    public void setMusician(Musician musician) {
        this.musician = musician;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }
}
