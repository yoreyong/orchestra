package team.wy.orchestra.bean;

import java.io.Serializable;

/**
 * @className: Repertoire
 * @description:
 * @author: YORE
 * @date: 2022/7/30
 **/
public class Repertoire implements Serializable {

    private long id;
    private long concertId;
    private long musicalWorkId;

    // Foreign Key
    private Concert concert;
    private MusicalWork musicalWork;

    @Override
    public String toString() {
        return "Repertoire{" +
                "id=" + id +
                ", concertId=" + concertId +
                ", musicalWorkId=" + musicalWorkId +
                ", concert=" + concert +
                ", musicalWork=" + musicalWork +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getConcertId() {
        return concertId;
    }

    public void setConcertId(long concertId) {
        this.concertId = concertId;
    }

    public long getMusicalWorkId() {
        return musicalWorkId;
    }

    public void setMusicalWorkId(long musicalWorkId) {
        this.musicalWorkId = musicalWorkId;
    }

    public Concert getConcert() {
        return concert;
    }

    public void setConcert(Concert concert) {
        this.concert = concert;
    }

    public MusicalWork getMusicalWork() {
        return musicalWork;
    }

    public void setMusicalWork(MusicalWork musicalWork) {
        this.musicalWork = musicalWork;
    }
}
