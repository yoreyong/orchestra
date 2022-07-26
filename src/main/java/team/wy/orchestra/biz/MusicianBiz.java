package team.wy.orchestra.biz;

import team.wy.orchestra.bean.Musician;
import team.wy.orchestra.bean.Participate;
import team.wy.orchestra.bean.PlaysInstr;
import team.wy.orchestra.dao.MusicianDao;
import team.wy.orchestra.dao.ParticipateDao;
import team.wy.orchestra.dao.PlaysInstrDao;

import java.sql.SQLException;
import java.util.List;

/**
 * @className: MusicianBiz
 * @description:
 * @author: YORE
 * @date: 2022/7/18
 **/
public class MusicianBiz {
    MusicianDao musicianDao = new MusicianDao();

    /**
     * Get musician by SSN number
     * @param SSN
     * @return musician
     */
    public Musician getMusicianBySSN(String SSN) {
        try {
            return musicianDao.getMusicianBySSN(SSN);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Get musicians by gender
     * @param gender - M: man F: Female
     * @return List<Musician> musicians
     */
    public List<Musician> getMusiciansByGender(String gender) {
        try {
            return musicianDao.getMusiciansByGender(gender);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Add a new musician.
     * @param
     * @return count - 1:success, 0:failed
     */
    public int add(String SSN, long accountId, String fname, String lname, String gender, String phoneNum,
                   String state, String city, String address,  String zip, String pic) {
        int count = 0;
        try {
            count = musicianDao.add(SSN, accountId, fname, lname, gender, phoneNum,
                    state, city, address, zip, pic);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * Add a new musician.
     * @param musician - class musician
     * @return count - 1:success, 0:failed
     */
    public int add(Musician musician) {
        int count = 0;
        try {
            count = musicianDao.add(musician.getSSN(), musician.getAccountId(), musician.getFname(),
                    musician.getLname(), musician.getGender(), musician.getPhoneNum(), musician.getState(),
                    musician.getCity(), musician.getAddress(), musician.getZip(), musician.getPic());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * Remove a musician from database.
     * @param SSN - SSN number
     * @return count - 1:success, 0:failed
     */
    public int remove(String SSN) throws Exception {
        ParticipateDao participateDao = new ParticipateDao();
        PlaysInstrDao playsInstrDao = new PlaysInstrDao();

        try {
            List<Participate> participates = participateDao.getBySSN(SSN);
            if(participates.size() > 0) {
                throw new Exception("Cannot delete the musician, a foreign key constraint fails");
            }

            List<PlaysInstr> playsInstrs = playsInstrDao.getBySSN(SSN);
            if(playsInstrs.size() > 0) {
                throw new Exception("Cannot delete the musician, a foreign key constraint fails");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        int count = 0;
        try {
            count = musicianDao.remove(SSN);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * @param
     * @return count - 1:success, 0:failed
     */
    public int modify(String SSN, long accountId, String fname, String lname, String gender, String phoneNum,
                      String state, String city, String address,  String zip, String pic) {
        int count = 0;
        try {
            count = musicianDao.modify(SSN, accountId, fname, lname, gender, phoneNum, state,
                    city, address, zip, pic);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     *
     * @param musician
     * @return
     */
    public int modify(Musician musician) {
        int count = 0;
        try {
            count = musicianDao.modify(musician.getSSN(), musician.getAccountId(), musician.getFname(), musician.getLname(),
                    musician.getGender(), musician.getPhoneNum(), musician.getState(),
                    musician.getCity(), musician.getAddress(), musician.getZip(), musician.getPic());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

        /**
     * TODO - 后面可能还要增加指向User的Foreign key实体
     * @param pageIndex -
     * @param pageSize -
     * @return - List<Musician> musicians
     */
    public List<Musician> getMusiciansByPage(int pageIndex, int pageSize) {
        List<Musician> musicians = null;
        try {
            musicians = musicianDao.getMusiciansByPage(pageIndex, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return musicians;
    }

    /**
     * Get page numbers based on row number
     * @param pageSize -
     * @return pageCount - number of pages
     */
    public int getMusicianPageCount(int pageSize) {
        int pageCount = 0;
        try {
            int rowCount = musicianDao.getMusicianCount();
            pageCount = (rowCount - 1) / pageSize + 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pageCount;
    }

    /**
     *
     * @param fname
     * @param lname
     * @return
     */
    public List<Musician> getMusicianByName(String fname, String lname) {
        List<Musician> musicians = null;
        try {
            musicians = musicianDao.getMusiciansByName(fname, lname);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return musicians;
    }

}
