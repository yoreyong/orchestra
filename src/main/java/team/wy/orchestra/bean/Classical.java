package team.wy.orchestra.bean;

import java.io.Serializable;

/**
 * @className: Classical
 * @description:
 * @author: YORE
 * @date: 2022/7/25
 **/
public class Classical implements Serializable {
    private long id;
    private long musicalId;

    // Foreign key
    private MusicalWork musicalWork;

    @Override
    public String toString() {
        return "Classical{" +
                "id=" + id +
                ", musicalId=" + musicalId +
                ", musicalWork=" + musicalWork +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMusicalId() {
        return musicalId;
    }

    public void setMusicalId(long musicalId) {
        this.musicalId = musicalId;
    }

    public MusicalWork getMusicalWork() {
        return musicalWork;
    }

    public void setMusicalWork(MusicalWork musicalWork) {
        this.musicalWork = musicalWork;
    }
}
