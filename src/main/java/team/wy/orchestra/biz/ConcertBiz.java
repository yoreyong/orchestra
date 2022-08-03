package team.wy.orchestra.biz;

import team.wy.orchestra.bean.Concert;
import team.wy.orchestra.bean.Participate;
import team.wy.orchestra.bean.Repertoire;
import team.wy.orchestra.dao.ConcertDao;
import team.wy.orchestra.dao.ConcertTypeDao;
import team.wy.orchestra.dao.ParticipateDao;
import team.wy.orchestra.dao.RepertoireDao;

import java.sql.SQLException;
import java.util.List;

/**
 * @className: ConcertBiz
 * @description:
 * @author: YORE
 * @date: 2022/7/28
 **/
public class ConcertBiz {

    ConcertDao concertDao = new ConcertDao();
    // ConcertTypeBiz concertTypeBiz = new ConcertTypeBiz();
    ConcertTypeDao concertTypeDao = new ConcertTypeDao();


    public int add(String concertName, String place, String concertDate, String startTime,
                   String desc, long typeId, double price) {
        int count = 0;
        try {
            count = concertDao.add(concertName, place, concertDate, startTime, desc, typeId, price);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int remove(long id) throws Exception {
        ParticipateDao participateDao = new ParticipateDao();
        RepertoireDao repertoireDao = new RepertoireDao();

        try {
            List<Participate> participates = participateDao.getByConId(id);
            if(participates.size() > 0) {
                throw new Exception("Cannot delete the concert, a foreign key constraint fails");
            }

            List<Repertoire> repertoires = repertoireDao.getByConcertId(id);
            if(repertoires.size() > 0) {
                throw new Exception("Cannot delete the concert, a foreign key constraint fails");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        int count = 0;
        try {
            count = concertDao.remove(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int modify(long id, String concertName, String place, String concertDate, String startTime,
                      String desc, long typeId, double price) {
        int count = 0;
        try {
            count = concertDao.modify(id, concertName, place, concertDate, startTime, desc, typeId, price);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public List<Concert> getAll() {
        List<Concert> concerts = null;
        try {
            concerts = concertDao.getAll();
            for(Concert concert : concerts) {
                long typeId = concert.getTypeId();
                // ConcertType type = concertTypeBiz.getById(typeId);
                concert.setConcertType(concertTypeDao.getById(typeId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return concerts;
    }

    public List<Concert> getByPage(int pageIndex, int pageSize) {
        // ConcertTypeDao
        List<Concert> concerts = null;
        try {
            concerts = concertDao.getByPage(pageIndex, pageSize);
            for(Concert concert : concerts) {
                long typeId = concert.getTypeId();
                // ConcertType type = concertTypeBiz.getById(typeId);
                concert.setConcertType(concertTypeDao.getById(typeId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return concerts;
    }

    public Concert getById(long id) {
        // ConcertTypeDao
        Concert concert = null;
        try {
            concert = concertDao.getById(id);
            long typeId = concert.getTypeId();
            concert.setConcertType(concertTypeDao.getById(typeId));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return concert;
    }

    public int getPageCount(int pageSize) {
        int pageCount = 0;
        try {
            int rowCount = concertDao.getCount();
            pageCount = (rowCount - 1) / pageSize + 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pageCount;
    }

    public List<Concert> getByName(String concertName) {
        // ConcertTypeDao
        List<Concert> concerts = null;
        try {
            concerts = concertDao.getByName(concertName);
            for(Concert concert : concerts) {
                long typeId = concert.getTypeId();
                // ConcertType type = concertTypeBiz.getById(typeId);
                concert.setConcertType(concertTypeDao.getById(typeId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return concerts;
    }

    public List<Concert> getByTypeId(long typeId) {
        // ConcertTypeDao
        List<Concert> concerts = null;
        try {
            concerts = concertDao.getByTypeId(typeId);
            for(Concert concert : concerts) {
                long concertTypeId = concert.getTypeId();
                // ConcertType type = concertTypeBiz.getById(typeId);
                concert.setConcertType(concertTypeDao.getById(typeId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return concerts;
    }
}
