package team.wy.orchestra.dao;

import org.junit.Test;

import java.sql.SQLException;

/**
 * @className: RequireInstrumentDaoTest
 * @description: TODO 类描述
 * @author: YORE
 * @date: 2022/7/31
 **/
public class RequireInstrumentDaoTest {

    RequireInstrumentDao require = new RequireInstrumentDao();
    @Test
    public void addTest() {

        try {
            int count = require.add(1,11);
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
