package team.wy.orchestra.biz;

import team.wy.orchestra.bean.Participate;
import team.wy.orchestra.dao.ConcertDao;
import team.wy.orchestra.dao.MusicianDao;
import team.wy.orchestra.dao.ParticipateDao;
import team.wy.orchestra.util.DBHelper;

import java.sql.SQLException;
import java.util.List;

/**
 * @className: ParticipateBiz
 * @description: TODO 类描述
 * @author: YORE
 * @date: 2022/7/30
 **/
public class ParticipateBiz {

    ParticipateDao participateDao = new ParticipateDao();
    MusicianDao musicianDao = new MusicianDao();
    ConcertDao concertDao = new ConcertDao();

    public int add (String SSN, long conId) {
        int count = 0;
        try {
            count = participateDao.add(SSN, conId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int add(List<String> SSNs, long concertId) {
        //启动事务
        try {
            DBHelper.beginTransaction();

            for(String SSN : SSNs) {
                participateDao.add(SSN, concertId);
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
            count = participateDao.remove(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int modify(long id, String SSN, long conId) {
        int count = 0;
        try {
            count = participateDao.modify(id, SSN, conId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public List<Participate> getAll() {
        List<Participate> participates = null;
        try {
            participates = participateDao.getAll();
            for(Participate participate : participates) {
                String SSN = participate.getSSN();
                participate.setMusician(musicianDao.getMusicianBySSN(SSN));
                long conId = participate.getConId();
                participate.setConcert(concertDao.getById(conId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return participates;
    }

    public Participate getById(int id) {
        Participate participate = null;
        try {
            participate = participateDao.getById(id);
            String SSN = participate.getSSN();
            participate.setMusician(musicianDao.getMusicianBySSN(SSN));
            long conId = participate.getConId();
            participate.setConcert(concertDao.getById(conId));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return participate;
    }

    public long getCount() {
        long rowCount = 0;
        try {
            rowCount = participateDao.getCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowCount;
    }

    public long getCountBySSN(String SSN) {
        long rowCount = 0;
        try {
            rowCount = participateDao.getCountBySSN(SSN);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowCount;
    }

    public List<Participate> getBySSN(String SSN) {
        List<Participate> participates = null;
        try {
            participates = participateDao.getBySSN(SSN);
            for(Participate participate : participates) {
                participate.setMusician(musicianDao.getMusicianBySSN(SSN));
                long conId = participate.getConId();
                participate.setConcert(concertDao.getById(conId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return participates;
    }

    public long getCountByconId(long conId) {
        long rowCount = 0;
        try {
            rowCount = participateDao.getCountByConId(conId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowCount;
    }

    public List<Participate> getByConId(long conId) {
        List<Participate> participates = null;
        try {
            participates = participateDao.getByConId(conId);
            for(Participate participate : participates) {
                String SSN = participate.getSSN();
                participate.setMusician(musicianDao.getMusicianBySSN(SSN));
                participate.setConcert(concertDao.getById(conId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return participates;
    }

}
