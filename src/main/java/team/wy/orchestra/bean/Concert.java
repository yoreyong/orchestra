package team.wy.orchestra.bean;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

/**
 * @className: Concert
 * @description: TODO 类描述
 * @author: YORE
 * @date: 2022/7/18
 **/
public class Concert implements Serializable {

    private int id;
    private String concert_name;
    private String place;
    private java.sql.Date concert_date;
    private java.sql.Time start_time;
    private String description;

    @Override
    public String toString() {
        return "Concert{" +
                "id=" + id +
                ", concert_name='" + concert_name + '\'' +
                ", place='" + place + '\'' +
                ", concert_date=" + concert_date +
                ", start_time=" + start_time +
                ", description='" + description + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConcert_name() {
        return concert_name;
    }

    public void setConcert_name(String concert_name) {
        this.concert_name = concert_name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getConcert_date() {
        return concert_date;
    }

    public void setConcert_date(Date concert_date) {
        this.concert_date = concert_date;
    }

    public Time getStart_time() {
        return start_time;
    }

    public void setStart_time(Time start_time) {
        this.start_time = start_time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
