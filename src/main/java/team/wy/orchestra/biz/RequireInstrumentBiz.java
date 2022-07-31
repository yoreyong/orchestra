package team.wy.orchestra.biz;

import team.wy.orchestra.bean.Instrument;
import team.wy.orchestra.bean.RequireInstrument;
import team.wy.orchestra.dao.MusicalWorkDao;
import team.wy.orchestra.dao.RequireInstrumentDao;

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

    public int add (long settingNum, long MWorkNum) {
        int count = 0;

        return count;
    }

    public int remove(long id) {
        int count = 0;

        return count;
    }

    public int modify(long id, long settingNum, long MWorkNum) {
        int count = 0;

        return count;
    }

    public List<RequireInstrument> getAll() {
        List<RequireInstrument> requireInstruments = null;

        return requireInstruments;
    }

    public RequireInstrument getById(int id) {
        RequireInstrument requireInstrument = null;

        return requireInstrument;
    }

    public int getCount() {
        int rowCount = 0;

        return rowCount;
    }

    public List<RequireInstrument> getByInstrument(long settingNum) {
        List<RequireInstrument> requireInstruments = null;

        return requireInstruments;
    }

    public int getCountBySSN(long settingNum) {
        int rowCount = 0;

        return rowCount;
    }

    public  List<RequireInstrument> getByMusicalWork(long MWorkNum) {
        List<RequireInstrument> requireInstruments = null;

        return requireInstruments;
    }

    public int getCountByConId(long MWorkNum) {
        int rowCount = 0;

        return rowCount;
    }


}
