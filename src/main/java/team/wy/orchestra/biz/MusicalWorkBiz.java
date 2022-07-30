package team.wy.orchestra.biz;

import team.wy.orchestra.bean.MusicalWork;
import team.wy.orchestra.bean.MusicalWorkType;
import team.wy.orchestra.dao.MusicalWorkDao;
import team.wy.orchestra.dao.MusicalWorkTypeDao;

import java.sql.SQLException;
import java.util.List;


/**
 * @className: MusicalWorkBiz
 * @description:
 * @author: YORE
 * @date: 2022/7/25
 **/
public class MusicalWorkBiz {

    MusicalWorkDao musicalWorkDao = new MusicalWorkDao();
    MusicalWorkTypeDao musicalWorkTypeDao = new MusicalWorkTypeDao();

    public int add(String name, String author, String desc, long typeId) {
        int count = 0;
        try {
            count = musicalWorkDao.add(name, author, desc, typeId);
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


    public int modify(long id, String name, String author, String desc, long typeId) {
        int count = 0;
        try {
            count = musicalWorkDao.modify(id, name, author, desc, typeId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public MusicalWork getMusicalWorkById(long id) {
        MusicalWork musicalWork = null;
        try {
            musicalWork = musicalWorkDao.getMusicalWorkById(id);
            MusicalWorkType musicalWorkType = musicalWorkTypeDao.getTypeById(musicalWork.getTypeId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return musicalWork;
    }

    public List<MusicalWork> getMusicalWorkByPage(int pageIndex, int pageSize) {
        List<MusicalWork> musicalWorks = null;
        try {
            musicalWorks = musicalWorkDao.getMusicalWorkByPage(pageIndex, pageSize);
            for(MusicalWork musicalWork : musicalWorks) {
                MusicalWorkType type = musicalWorkTypeDao.getTypeById(musicalWork.getTypeId());
                musicalWork.setType(type);
            }
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
            for(MusicalWork musicalWork : musicalWorks) {
                MusicalWorkType type = musicalWorkTypeDao.getTypeById(musicalWork.getTypeId());
                musicalWork.setType(type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return musicalWorks;
    }

    public List<MusicalWork> getMusicalWorkByAuthor(String author) {
        List<MusicalWork> musicalWorks = null;
        try {
            musicalWorks = musicalWorkDao.getMusicalWorkByAuthor(author);
            for(MusicalWork musicalWork : musicalWorks) {
                MusicalWorkType type = musicalWorkTypeDao.getTypeById(musicalWork.getTypeId());
                musicalWork.setType(type);
            }
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
