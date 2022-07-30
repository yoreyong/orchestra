package team.wy.orchestra.biz;

import team.wy.orchestra.bean.Concert;
import team.wy.orchestra.bean.MusicalWork;
import team.wy.orchestra.bean.Repertoire;
import team.wy.orchestra.dao.ConcertDao;
import team.wy.orchestra.dao.MusicalWorkDao;
import team.wy.orchestra.dao.RepertoireDao;

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
    MusicalWorkDao musicalWorkDao = new MusicalWorkDao();

    public int add(long concertId, long musicalWorkId) {
        int count = 0;
        try {
            count = repertoireDao.add(concertId, musicalWorkId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
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
                MusicalWork musicalWork = musicalWorkDao.getMusicalWorkById(repertoire.getMusicalWorkId());
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
            MusicalWork musicalWork = musicalWorkDao.getMusicalWorkById(repertoire.getMusicalWorkId());
            repertoire.setMusicalWork(musicalWork);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return repertoire;
    }

    public List<Repertoire> getByConcertId(long concertId) {
        List<Repertoire> repertoires = null;
        try {
            repertoires = repertoireDao.getByConcertId(concertId);
            for(Repertoire repertoire : repertoires) {
                Concert concert = concertDao.getById(repertoire.getConcertId());
                repertoire.setConcert(concert);
                MusicalWork musicalWork = musicalWorkDao.getMusicalWorkById(repertoire.getMusicalWorkId());
                repertoire.setMusicalWork(musicalWork);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return repertoires;
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
