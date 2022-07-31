package team.wy.orchestra.bean;

import java.io.Serializable;

/**
 * @className: RequireInstrument
 * @description:
 * @author: YORE
 * @date: 2022/7/30
 **/
public class RequireInstrument implements Serializable {

    private long id;
    private long settingNum;
    private long MWorkNum;

    // Foreign Key
    private Instrument instrument;
    private MusicalWork musicalWork;

    @Override
    public String toString() {
        return "RequireInstrument{" +
                "id=" + id +
                ", settingNum=" + settingNum +
                ", MWorkNum=" + MWorkNum +
                ", instrument=" + instrument +
                ", musicalWork=" + musicalWork +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSettingNum() {
        return settingNum;
    }

    public void setSettingNum(long settingNum) {
        this.settingNum = settingNum;
    }

    public long getMWorkNum() {
        return MWorkNum;
    }

    public void setMWorkNum(long MWorkNum) {
        this.MWorkNum = MWorkNum;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public MusicalWork getMusicalWork() {
        return musicalWork;
    }

    public void setMusicalWork(MusicalWork musicalWork) {
        this.musicalWork = musicalWork;
    }
}
