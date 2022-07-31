package team.wy.orchestra.biz;

import team.wy.orchestra.bean.ChurchConcert;
import team.wy.orchestra.dao.ChurchConcertDao;
import team.wy.orchestra.dao.ConcertDao;

import java.sql.SQLException;
import java.util.List;

/**
 * @className: ChurchConcertBiz
 * @description:
 * @author: YORE
 * @date: 2022/7/28
 **/
public class ChurchConcertBiz {

    ChurchConcertDao churchConcertDao = new ChurchConcertDao();
    ConcertBiz concertBiz = new ConcertBiz();

    public int add (long condId) {
        int count = 0;

        try {
            count = churchConcertDao.add(condId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

    public int remove(long id) {
        int count = 0;

        try {
            count = churchConcertDao.remove(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

    public int modify(long id, long conId) {
        int count = 0;

        try {
            count = churchConcertDao.modify(id, conId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

    public List<ChurchConcert> getByPage(int pageIndex, int pageSize) {
        List<ChurchConcert> churchConcerts = null;

        try {
            churchConcerts = churchConcertDao.getByPage(pageIndex, pageSize);
            for(ChurchConcert churchConcert : churchConcerts) {
                long conId = churchConcert.getConId();
                churchConcert.setConcert(concertBiz.getById(conId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return churchConcerts;
    }

    public int getPageCount(int pageSize) {
        int pageCount = 0;

        try {
            int rowCount = churchConcertDao.getCount();
            pageCount = (rowCount - 1) / pageSize + 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pageCount;
    }

    public ChurchConcert getById(int id) {
        ChurchConcert churchConcert = null;

        try {
            churchConcert = churchConcertDao.getById(id);
            long conId = churchConcert.getConId();
            churchConcert.setConcert(concertBiz.getById(conId));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return churchConcert;
    }

}
