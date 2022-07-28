package team.wy.orchestra.biz;

import team.wy.orchestra.bean.ChurchConcert;
import team.wy.orchestra.bean.OutdoorParty;
import team.wy.orchestra.dao.OutdoorPartyDao;

import java.sql.SQLException;
import java.util.List;

/**
 * @className: OutdoorPartyBiz
 * @description:
 * @author: YORE
 * @date: 2022/7/28
 **/
public class OutdoorPartyBiz {

    OutdoorPartyDao outdoorPartyDao = new OutdoorPartyDao();
    ConcertBiz concertBiz = new ConcertBiz();

    public int add (long condId, String type) {
        int count = 0;
        try {
            count = outdoorPartyDao.add(condId, type);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int remove(long id) {
        int count = 0;
        try {
            count = outdoorPartyDao.remove(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int modify(long id, long conId, String type) {
        int count = 0;
        try {
            count = outdoorPartyDao.modify(id, conId, type);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public List<OutdoorParty> getByPage(int pageIndex, int pageSize) {
        List<OutdoorParty> outdoorParties = null;
        try {
            outdoorParties = outdoorPartyDao.getByPage(pageIndex, pageSize);
            for(OutdoorParty outdoorParty : outdoorParties) {
                long conId = outdoorParty.getConId();
                outdoorParty.setConcert(concertBiz.getById(conId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return outdoorParties;
    }

    public int getPageCount(int pageSize) {
        int pageCount = 0;
        try {
            int rowCount = outdoorPartyDao.getCount();
            pageCount = (rowCount - 1) / pageSize + 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pageCount;
    }

    public OutdoorParty getById(int id) {
        OutdoorParty outdoorParty = null;
        try {
            outdoorParty = outdoorPartyDao.getById(id);
            long conId = outdoorParty.getConId();
            outdoorParty.setConcert(concertBiz.getById(conId));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return outdoorParty;
    }


    public List<OutdoorParty> getByType(String type) {
        List<OutdoorParty> outdoorParties = null;
        try {
            outdoorParties = outdoorPartyDao.getByType(type);
            for(OutdoorParty outdoorParty : outdoorParties) {
                long conId = outdoorParty.getConId();
                outdoorParty.setConcert(concertBiz.getById(conId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return outdoorParties;
    }

}
