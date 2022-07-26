package team.wy.orchestra.dao;

import org.junit.Test;
import team.wy.orchestra.bean.MusicalWorkType;

import java.sql.SQLException;
import java.util.List;

/**
 * @className: MusicalWorkTypeDaoTest
 * @description:
 * @author: YORE
 * @date: 2022/7/26
 **/
public class MusicalWorkTypeDaoTest {

    MusicalWorkTypeDao musicalWorkTypeDao = new MusicalWorkTypeDao();

    @Test
    public void addTest() {
        try {
            int count = musicalWorkTypeDao.add("Funk", 0);
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void removeTest() {
        try {
            int count = musicalWorkTypeDao.remove(4);
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void modifyTest() {
        try {
            int count = musicalWorkTypeDao.modify(5, "Uptown Funk", 0);
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAllTest() {
        try {
            List<MusicalWorkType> musicalWorkTypes = musicalWorkTypeDao.getAllTypes();
            System.out.println(musicalWorkTypes.size());
            for(MusicalWorkType musicalWorkType : musicalWorkTypes) {
                System.out.println(musicalWorkType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getByIdTest() {
        try {
            MusicalWorkType musicalWorkType = musicalWorkTypeDao.getTypeById(3);
            System.out.println(musicalWorkType);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
