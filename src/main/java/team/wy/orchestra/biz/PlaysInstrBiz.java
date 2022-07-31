package team.wy.orchestra.biz;

import team.wy.orchestra.bean.PlaysInstr;
import team.wy.orchestra.dao.InstrumentDao;
import team.wy.orchestra.dao.MusicianDao;
import team.wy.orchestra.dao.PlaysInstrDao;

import java.sql.SQLException;
import java.util.List;

/**
 * @className: PlaysInstrBiz
 * @description:
 * @author: YORE
 * @date: 2022/7/31
 **/
public class PlaysInstrBiz {
    PlaysInstrDao playsInstrDao = new PlaysInstrDao();
    MusicianDao musicianDao = new MusicianDao();
    InstrumentDao instrumentDao = new InstrumentDao();


    public int add(String SSN, long instrNum) {
        int count = 0;
        try {
            count = playsInstrDao.add(SSN, instrNum);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int remove(long id) {
        int count = 0;
        try {
            count = playsInstrDao.remove(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int modify(long id, String SSN, long instrNum) {
        int count = 0;
        try {
            count = playsInstrDao.modify(id, SSN, instrNum);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public List<PlaysInstr> getAll() {
        List<PlaysInstr> playsInstrs = null;
        try {
            playsInstrs = playsInstrDao.getAll();
            for(PlaysInstr playsInstr : playsInstrs) {
                String SSN = playsInstr.getSSN();
                playsInstr.setMusician(musicianDao.getMusicianBySSN(SSN));
                long instrNum = playsInstr.getInstrNum();
                playsInstr.setInstrument(instrumentDao.getById(instrNum));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return playsInstrs;
    }

    public PlaysInstr getById(int id) {
        PlaysInstr playsInstr = null;
        try {
            playsInstr = playsInstrDao.getById(id);
            String SSN = playsInstr.getSSN();
            playsInstr.setMusician(musicianDao.getMusicianBySSN(SSN));
            long instrNum = playsInstr.getInstrNum();
            playsInstr.setInstrument(instrumentDao.getById(instrNum));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return playsInstr;
    }

    public long getCount() {
        long rowCount = 0;
        try {
            rowCount = playsInstrDao.getCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowCount;
    }

    public List<PlaysInstr> getBySSN(String SSN) {
        List<PlaysInstr> playsInstrs = null;
        try {
            playsInstrs = playsInstrDao.getBySSN(SSN);
            for(PlaysInstr playsInstr : playsInstrs) {
                playsInstr.setMusician(musicianDao.getMusicianBySSN(SSN));
                long instrNum = playsInstr.getInstrNum();
                playsInstr.setInstrument(instrumentDao.getById(instrNum));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return playsInstrs;
    }

    public long getCountBySSN(String SSN) {
        long rowCount = 0;
        try {
            rowCount = playsInstrDao.getCountBySSN(SSN);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowCount;
    }

    public List<PlaysInstr> getByInstrNum(long instrNum) {
        List<PlaysInstr> playsInstrs = null;
        try {
            playsInstrs = playsInstrDao.getByInstrNum(instrNum);
            for(PlaysInstr playsInstr : playsInstrs) {
                String SSN = playsInstr.getSSN();
                playsInstr.setMusician(musicianDao.getMusicianBySSN(SSN));
                playsInstr.setInstrument(instrumentDao.getById(instrNum));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return playsInstrs;
    }

    public long getCountByInstrNum(long instrNum) {
        long rowCount = 0;
        try {
            rowCount = playsInstrDao.getCountByInstrNum(instrNum);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowCount;
    }
}
