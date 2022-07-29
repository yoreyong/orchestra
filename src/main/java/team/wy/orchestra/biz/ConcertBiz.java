package team.wy.orchestra.biz;

import team.wy.orchestra.bean.Concert;
import team.wy.orchestra.bean.ConcertType;
import team.wy.orchestra.dao.ConcertDao;
import team.wy.orchestra.dao.ConcertTypeDao;

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
    ConcertTypeBiz concertTypeBiz = new ConcertTypeBiz();


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

    public int remove(long id) {
        int count = 0;
        try {
            count = concertDao.remove(id);
            // TODO - 此处后续需要增加对Foreign Key判断
            // 返回页面提示
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

    public List<Concert> getByPage(int pageIndex, int pageSize) {
        // ConcertTypeDao
        List<Concert> concerts = null;
        try {
            concerts = concertDao.getByPage(pageIndex, pageSize);
            for(Concert concert : concerts) {
                long typeId = concert.getTypeId();
                // ConcertType type = concertTypeBiz.getById(typeId);
                concert.setConcertType(concertTypeBiz.getById(typeId));
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
            concert.setConcertType(concertTypeBiz.getById(typeId));
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
                concert.setConcertType(concertTypeBiz.getById(typeId));
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
                concert.setConcertType(concertTypeBiz.getById(concertTypeId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return concerts;
    }
}
