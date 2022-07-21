package team.wy.orchestra.dao;

import org.junit.Test;
import team.wy.orchestra.bean.Musician;

import java.sql.SQLException;
import java.util.List;


/**
 * @className: MusicianDaoTest
 * @description: MusicianDao Unit test
 * @author: YORE
 * @date: 2022/7/17
 **/
public class MusicianDaoTest {

    @Test
    public void getMusicianBySSNTest() {
        String SSN = "591-17-3946";
        Musician musician = null;
        try {
            musician = new MusicianDao().getMusicianBySSN(SSN);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(musician);
    }

    @Test
    public void getMusiciansByGenderTest() {
        String gender = "F";
        List<Musician> musicians = null;
        try {
            musicians = new MusicianDao().getMusiciansByGender(gender);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(musicians.size());
        for(Musician musician : musicians) {
            System.out.println(musician);
        }
    }

    @Test
    public void addTest() {
        int count = 0;
        try {
            count = new MusicianDao().add("866-86-4245", 0,
                    "Wilton", "Dollard", "M",
                    "713-981-8035", "Texas", "Houston",
                    "4 Lighthouse Bay Road", "77250", null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }

    @Test
    public void removeTest() {
        int count = 0;
        try {
            count = new MusicianDao().remove("866-86-4245");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }

    @Test
    public void modifyTest() {
        int count = 0;
        try {
            count = new MusicianDao().modify("866-86-4245", 0,
                    "Wilton", "Dollard", "M",
                    "713-981-8035", "Texas", "Dallas",
                    "17570 Sequoia Dr", "77250", null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }


    @Test
    public void getMusiciansByPageTest() {
        List<Musician> musicians = null;
        try {
            musicians = new MusicianDao().getMusiciansByPage(3, 2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(musicians.size());
        for(Musician musician : musicians) {
            System.out.println(musician);
        }
    }

    @Test
    public void getMusicianCountTest() {
        int number = 0;
        try {
            number = new MusicianDao().getMusicianCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(number);
    }

}
