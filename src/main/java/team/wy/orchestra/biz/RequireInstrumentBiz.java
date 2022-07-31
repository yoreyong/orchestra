package team.wy.orchestra.biz;

import team.wy.orchestra.bean.RequireInstrument;
import team.wy.orchestra.dao.InstrumentDao;
import team.wy.orchestra.dao.MusicalWorkDao;
import team.wy.orchestra.dao.RequireInstrumentDao;

import java.sql.SQLException;
import java.util.List;

/**
 * @className: RequireInstrumentBiz
 * @description:
 * @author: YORE
 * @date: 2022/7/30
 **/
public class RequireInstrumentBiz {
    RequireInstrumentDao requireInstrumentDao = new RequireInstrumentDao();
    MusicalWorkDao musicalWorkDao = new MusicalWorkDao();
    InstrumentDao instrumentDao = new InstrumentDao();

    public int add (long settingNum, long MWorkNum) {
        int count = 0;
        try {
            count = requireInstrumentDao.add(settingNum, MWorkNum);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int remove(long id) {
        int count = 0;
        try {
            count = requireInstrumentDao.remove(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int modify(long id, long settingNum, long MWorkNum) {
        int count = 0;
        try {
            count = requireInstrumentDao.modify(id, settingNum, MWorkNum);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public List<RequireInstrument> getAll() {
        List<RequireInstrument> requireInstruments = null;
        try {
            requireInstruments = requireInstrumentDao.getAll();
            for(RequireInstrument requireInstrument : requireInstruments) {
                long instrumentId = requireInstrument.getSettingNum();
                requireInstrument.setInstrument(instrumentDao.getById(instrumentId));
                long MWorkId = requireInstrument.getMWorkNum();
                requireInstrument.setMusicalWork(musicalWorkDao.getMusicalWorkById(MWorkId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return requireInstruments;
    }

    public RequireInstrument getById(long id) {
        RequireInstrument requireInstrument = null;
        try {
            requireInstrument = requireInstrumentDao.getById(id);
            long instrumentId = requireInstrument.getSettingNum();
            requireInstrument.setInstrument(instrumentDao.getById(instrumentId));
            long MWorkId = requireInstrument.getMWorkNum();
            requireInstrument.setMusicalWork(musicalWorkDao.getMusicalWorkById(MWorkId));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return requireInstrument;
    }

    public long getCount() {
        long rowCount = 0;
        try {
            rowCount = requireInstrumentDao.getCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowCount;
    }

    public List<RequireInstrument> getByInstrument(long settingNum) {
        List<RequireInstrument> requireInstruments = null;
        try {
            requireInstruments = requireInstrumentDao.getByInstrument(settingNum);
            for(RequireInstrument requireInstrument : requireInstruments) {
                long instrumentId = requireInstrument.getSettingNum();
                requireInstrument.setInstrument(instrumentDao.getById(instrumentId));
                long MWorkId = requireInstrument.getMWorkNum();
                requireInstrument.setMusicalWork(musicalWorkDao.getMusicalWorkById(MWorkId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return requireInstruments;
    }

    public long getCountByInstrument(long settingNum) {
        long rowCount = 0;
        try {
            rowCount = requireInstrumentDao.getCountByInstrument(settingNum);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowCount;
    }

    public  List<RequireInstrument> getByMusicalWork(long MWorkNum) {
        List<RequireInstrument> requireInstruments = null;
        try {
            requireInstruments = requireInstrumentDao.getByMusicalWork(MWorkNum);
            for(RequireInstrument requireInstrument : requireInstruments) {
                long instrumentId = requireInstrument.getSettingNum();
                requireInstrument.setInstrument(instrumentDao.getById(instrumentId));
                long MWorkId = requireInstrument.getMWorkNum();
                requireInstrument.setMusicalWork(musicalWorkDao.getMusicalWorkById(MWorkId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return requireInstruments;
    }

    public long getCountByMusicalWork(long MWorkNum) {
        long rowCount = 0;
        try {
            rowCount = requireInstrumentDao.getCountByMusicalWork(MWorkNum);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowCount;
    }

}
