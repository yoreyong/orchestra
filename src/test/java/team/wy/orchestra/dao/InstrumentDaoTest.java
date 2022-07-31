package team.wy.orchestra.dao;

import org.junit.Test;

import java.sql.SQLException;

/**
 * @className: InstrumentDaoTest
 * @description:
 * @author: YORE
 * @date: 2022/7/31
 **/
public class InstrumentDaoTest {

    InstrumentDao instrumentDao = new InstrumentDao();

    @Test
    public void addTest() {
        try {
            int count = instrumentDao.add("guiter", "strings", true);
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
