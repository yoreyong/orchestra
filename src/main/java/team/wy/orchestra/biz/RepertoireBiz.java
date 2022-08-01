package team.wy.orchestra.biz;

import team.wy.orchestra.bean.Concert;
import team.wy.orchestra.bean.MusicalWork;
import team.wy.orchestra.bean.Repertoire;
import team.wy.orchestra.dao.ConcertDao;
import team.wy.orchestra.dao.RepertoireDao;
import team.wy.orchestra.util.DBHelper;

import java.sql.SQLException;
import java.util.List;

/**
 * @className: RepertoireBiz
 * @description:
 * @author: YORE
 * @date: 2022/7/30
 **/
public class RepertoireBiz {
    RepertoireDao repertoireDao = new RepertoireDao();
    ConcertDao concertDao = new ConcertDao();
    MusicalWorkBiz musicalWorkBiz = new MusicalWorkBiz();

    public int add(long concertId, long musicalWorkId) {
        int count = 0;
        try {
            count = repertoireDao.add(concertId, musicalWorkId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int add(long concertId, List<Long> musicalWorkIds) {
        //启动事务
        try {
            DBHelper.beginTransaction();

            for(Long musicialWorkId : musicalWorkIds) {
                repertoireDao.add(concertId, musicialWorkId);
            }

            DBHelper.commitTransaction(); // 事务提交：成功
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                DBHelper.rollbackTransaction(); // 事务回滚：有异常
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return 0;
        }
        return 1;
    }

    public int remove(long id) {
        int count = 0;
        try {
            count = repertoireDao.remove(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int modify(long id, long concertId, long musicalWorkId) {
        int count = 0;
        try {
            count = repertoireDao.modify(id, concertId, musicalWorkId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public List<Repertoire> getAll() {
        List<Repertoire> repertoires = null;

        try {
            repertoires = repertoireDao.getAll();
            for(Repertoire repertoire : repertoires) {
                Concert concert = concertDao.getById(repertoire.getConcertId());
                repertoire.setConcert(concert);
                MusicalWork musicalWork = musicalWorkBiz.getMusicalWorkById(repertoire.getMusicalWorkId());
                repertoire.setMusicalWork(musicalWork);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return repertoires;
    }

    public List<Repertoire> getByPage(int pageIndex, int pageSize) {
        // ConcertTypeDao
        List<Repertoire> repertoires = null;
        try {
            repertoires = repertoireDao.getByPage(pageIndex, pageSize);
            for(Repertoire repertoire : repertoires) {
                Concert concert = concertDao.getById(repertoire.getConcertId());
                repertoire.setConcert(concert);
                MusicalWork musicalWork = musicalWorkBiz.getMusicalWorkById(repertoire.getMusicalWorkId());
                repertoire.setMusicalWork(musicalWork);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return repertoires;
    }

    public List<Repertoire> getByPageAndConId(int pageIndex, int pageSize, long conId) {
        // ConcertTypeDao
        List<Repertoire> repertoires = null;
        try {
            repertoires = repertoireDao.getByPageAndConId(pageIndex, pageSize, conId);
            for(Repertoire repertoire : repertoires) {
                Concert concert = concertDao.getById(repertoire.getConcertId());
                repertoire.setConcert(concert);
                MusicalWork musicalWork = musicalWorkBiz.getMusicalWorkById(repertoire.getMusicalWorkId());
                repertoire.setMusicalWork(musicalWork);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return repertoires;
    }

    public Repertoire getById(long id) {
        Repertoire repertoire = null;
        try {
            repertoire = repertoireDao.getById(id);
            Concert concert = concertDao.getById(repertoire.getConcertId());
            repertoire.setConcert(concert);
            MusicalWork musicalWork = musicalWorkBiz.getMusicalWorkById(repertoire.getMusicalWorkId());
            repertoire.setMusicalWork(musicalWork);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return repertoire;
    }

    public int getPageCount(int pageSize) {
        int pageCount = 0;
        try {
            int rowCount = repertoireDao.getCount();
            pageCount = (rowCount - 1) / pageSize + 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pageCount;
    }

    public List<Repertoire> getByConcertId(long concertId) {
        List<Repertoire> repertoires = null;
        try {
            repertoires = repertoireDao.getByConcertId(concertId);
            for(Repertoire repertoire : repertoires) {
                Concert concert = concertDao.getById(repertoire.getConcertId());
                repertoire.setConcert(concert);
                MusicalWork musicalWork = musicalWorkBiz.getMusicalWorkById(repertoire.getMusicalWorkId());
                repertoire.setMusicalWork(musicalWork);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return repertoires;
    }

    public long getCountByconId(long conId) {
        long rowCount = 0;
        try {
            rowCount = repertoireDao.getCountByConId(conId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowCount;
    }

    public int getPageCountByConId(int pageSize, long conId) {
        int pageCount = 0;
        try {
            long rowCount = repertoireDao.getCountByConId(conId);
            pageCount = (int) ((rowCount - 1) / pageSize + 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pageCount;
    }

    public int getCount() {
        int rowCount = 0;
        try {
            rowCount = repertoireDao.getCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowCount;
    }


}
