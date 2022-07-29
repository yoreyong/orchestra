package team.wy.orchestra.dao;

import org.junit.Test;
import team.wy.orchestra.bean.Concert;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

/**
 * @className: ConcertDaoTest
 * @description:
 * @author: YORE
 * @date: 2022/7/18
 **/
public class ConcertDaoTest {
    ConcertDao concertDao = new ConcertDao();

    @Test
    public void addTest() {
        try {
            int count = concertDao.add("Duobam123", "6443 Weeping Birch", "2022-01-10",
                    "06:05:00", "null", 1, 100.21);
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void removeTest() {
        try {
            int count = concertDao.remove(21);
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void modifyTest() {
        try {
            int count = concertDao.modify(22, "Duobam", "6443 Weeping Birch", "2022-01-10",
                    "06:15:00", "null", 1, 100.21);
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getByOageTest() {
        try {
            List<Concert> concerts = concertDao.getByPage(1, 5);
            System.out.println(concerts.size());
            for (Concert concert : concerts) {
                System.out.println(concert);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getConcertByIdTest() {
        concertDao = new ConcertDao();
        try {
            Concert concert = concertDao.getById(1);
            System.out.println(concert);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getCountTest() {
        try {
            int count = concertDao.getCount();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getByNameTest() {
        try {
            List<Concert> concerts = concertDao.getByName("Duobam");
            System.out.println(concerts.size());
            for(Concert concert :  concerts) {
                System.out.println(concert);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getConcertsByTypeIdTest() {
        try {
            List<Concert> concerts = concertDao.getByTypeId(1);
            System.out.println(concerts.size());
            for(Concert concert :  concerts) {
                System.out.println(concert);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
