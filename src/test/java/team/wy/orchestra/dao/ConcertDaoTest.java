package team.wy.orchestra.dao;

import org.junit.Test;
import team.wy.orchestra.bean.Concert;

import java.sql.SQLException;

/**
 * @className: ConcertDaoTest
 * @description:
 * @author: YORE
 * @date: 2022/7/18
 **/
public class ConcertDaoTest {

    @Test
    public void getConcertByIdTest() {
        ConcertDao concertDao = new ConcertDao();
        try {
            Concert concert = concertDao.getConcertById(1);
            System.out.println(concert);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
