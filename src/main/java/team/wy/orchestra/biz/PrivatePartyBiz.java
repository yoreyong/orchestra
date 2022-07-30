package team.wy.orchestra.biz;

import team.wy.orchestra.bean.ChurchConcert;
import team.wy.orchestra.bean.PrivateParty;
import team.wy.orchestra.dao.PrivatePartyDao;

import java.sql.SQLException;
import java.util.List;

/**
 * @className: PrivatePartyBiz
 * @description:
 * @author: YORE
 * @date: 2022/7/28
 **/
public class PrivatePartyBiz {

    PrivatePartyDao privatePartyDao = new PrivatePartyDao();
    ConcertBiz concertBiz = new ConcertBiz();

    public int add (long condId, String theme) {
        int count = 0;
        try {
            count = privatePartyDao.add(condId, theme);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int remove(long id) {
        int count = 0;
        try {
            count = privatePartyDao.remove(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int modify(long id, long conId, String theme) {
        int count = 0;
        try {
            count = privatePartyDao.modify(id, conId, theme);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public List<PrivateParty> getByPage(int pageIndex, int pageSize) {
        List<PrivateParty> privateParties = null;

        try {
            privateParties = privatePartyDao.getByPage(pageIndex, pageSize);
            for(PrivateParty privateParty : privateParties) {
                long conId = privateParty.getConId();
                privateParty.setConcert(concertBiz.getById(conId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return privateParties;
    }

    public int getPageCount(int pageSize) {
        int pageCount = 0;
        try {
            int rowCount = privatePartyDao.getCount();
            pageCount = (rowCount - 1) / pageSize + 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pageCount;
    }

    public PrivateParty getById(int id) {
        PrivateParty privateParty = null;

        try {
            privateParty = privatePartyDao.getById(id);
            long conId = privateParty.getConId();
            privateParty.setConcert(concertBiz.getById(conId));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return privateParty;
    }

}
