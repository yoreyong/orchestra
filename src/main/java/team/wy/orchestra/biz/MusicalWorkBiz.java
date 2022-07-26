package team.wy.orchestra.biz;

import team.wy.orchestra.bean.MusicalWork;
import team.wy.orchestra.dao.MusicalWorkDao;

import java.sql.SQLException;
import java.util.List;


/**
 * @className: MusicalWorkBiz
 * @description: TODO 类描述
 * @author: YORE
 * @date: 2022/7/25
 **/
public class MusicalWorkBiz {

    MusicalWorkDao musicalWorkDao = new MusicalWorkDao();

    public int add(String name, String author, String type, String desc) {
        int count = 0;
        try {
            count = musicalWorkDao.add(name, author, type, desc);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int remove(long id) {
        int count = 0;
        try {
            count = musicalWorkDao.remove(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }


    public int modify(long id, String name, String author, String type, String desc) {
        int count = 0;
        try {
            count = musicalWorkDao.modify(id, name, author, type, desc);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public MusicalWork getMusicalWorkById(long id) {
        try {
            return musicalWorkDao.getMusicalWorkById(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<MusicalWork> getMusicalWorkByPage(int pageIndex, int pageSize) {
        List<MusicalWork> musicalWorks = null;
        try {
            musicalWorks = musicalWorkDao.getMusicalWorkByPage(pageIndex, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return musicalWorks;
    }

    public int getMusicalWorkCount() {
        int count = 0;
        try {
            count = musicalWorkDao.getMusicalWorkCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public List<MusicalWork> getMusicalWorkByName(String name) {
        List<MusicalWork> musicalWorks = null;
        try {
            musicalWorks = musicalWorkDao.getMusicalWorkByName(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return musicalWorks;
    }

    public List<MusicalWork> getMusicalWorkByAuthor(String author) {
        List<MusicalWork> musicalWorks = null;
        try {
            musicalWorks = musicalWorkDao.getMusicalWorkByAuthor(author);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return musicalWorks;
    }

    public int getPageCount(int pageSize) {
        int pageCount = 0;
        try {
            int rowCount = musicalWorkDao.getMusicalWorkCount();
            pageCount = (rowCount - 1) / pageSize + 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pageCount;
    }
}
