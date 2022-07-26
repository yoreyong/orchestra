package team.wy.orchestra.dao;

import org.junit.Test;
import team.wy.orchestra.bean.MusicalWork;

import java.sql.SQLException;
import java.util.List;

/**
 * @className: MusicalWorkDaoTest
 * @description: TODO 类描述
 * @author: YORE
 * @date: 2022/7/25
 **/
public class MusicalWorkDaoTest {

    MusicalWorkDao musicalWorkDao = new MusicalWorkDao();

    @Test
    public void addTest() {
        try {
            int count = musicalWorkDao.add("Percussion and Celesta",
                    "Kleon Dyton", null, null);
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void removeTest() {
        try {
            int count = musicalWorkDao.remove(49);
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void modify() {
        try {
            int count = musicalWorkDao.modify(30, "Damascus-XXX", "Freddi Seer", "classical", null);
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getMusicalWorkById() {
        try {
            MusicalWork musicalWork = musicalWorkDao.getMusicalWorkById(1);
            System.out.println(musicalWork);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getMusicalWorkByPage() {
        try {
            List<MusicalWork> musicalWorks = musicalWorkDao.getMusicalWorkByPage(1, 5);
            System.out.println(musicalWorks.size());
            for(MusicalWork musicalWork : musicalWorks) {
                System.out.println(musicalWork);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getMusicalWorkCount() {
        try {
            Number count = musicalWorkDao.getMusicalWorkCount();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getMusicalWorkByName() {
        try {
            List<MusicalWork> musicalWorks = musicalWorkDao.getMusicalWorkByName("Symphony No.1");
            System.out.println(musicalWorks.size());
            for(MusicalWork musicalWork : musicalWorks) {
                System.out.println(musicalWork);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getMusicalWorkByAuthor() {
        try {
            List<MusicalWork> musicalWorks = musicalWorkDao.getMusicalWorkByAuthor("Brier Woodburne");
            System.out.println(musicalWorks.size());
            for(MusicalWork musicalWork : musicalWorks) {
                System.out.println(musicalWork);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
