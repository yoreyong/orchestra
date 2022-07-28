package team.wy.orchestra.biz;

import team.wy.orchestra.bean.Concert;
import team.wy.orchestra.dao.ConcertDao;

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
            // TODO - 需要等concert type相关函数完成后方可使用
            // for(Concert concert : concerts) {
            //     long typeId = concert.getTypeId();
            //     Type type = ConcertTypeDao.getById(typeId);
            //     concert.setConcertType(type);
            // }
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
            // concert.setConcertType(ConcertTypeDao.getById(typeId));
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
            // TODO - 需要等concert type相关函数完成后方可使用
            // for(Concert concert : concerts) {
            //     long typeId = concert.getTypeId();
            //     Type type = ConcertTypeDao.getById(typeId);
            //     concert.setConcertType(type);
            // }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return concerts;
    }

    public List<Concert> getConcertsByTypeId(long typeId) {
        // ConcertTypeDao
        List<Concert> concerts = null;
        try {
            concerts = concertDao.getByTypeId(typeId);
            // TODO - 需要等concert type相关函数完成后方可使用
            // for(Concert concert : concerts) {
            //     long typeId = concert.getTypeId();
            //     Type type = ConcertTypeDao.getById(typeId);
            //     concert.setConcertType(type);
            // }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return concerts;
    }
}
