package team.wy.orchestra.biz;

import org.junit.Test;
import team.wy.orchestra.bean.Concert;
import team.wy.orchestra.bean.Instrument;
import team.wy.orchestra.dao.InstrumentDao;

import java.sql.SQLException;
import java.util.List;

/**
 * @className: InstrumentBiz
 * @description:
 * @author: YORE
 * @date: 2022/7/31
 **/
public class InstrumentBiz {

    InstrumentDao instrumentDao = new InstrumentDao();

    public int add(String name, String type, boolean status) {
        int count = 0;
        try {
            count = instrumentDao.add(name, type, status);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Test
    public void addTest() {
        int count = add("pinao", "keyboard", true);
        System.out.println(count);
    }

    public int remove(long id) {
        int count = 0;
        try {
            count = instrumentDao.remove(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int modify(long id, String name, String type, boolean status) {
        int count = 0;
        try {
            count = instrumentDao.modify(id, name, type, status);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public List<Instrument> getAll() {
        List<Instrument> instruments = null;
        try {
            instruments = instrumentDao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return instruments;
    }

    public long getCount() {
        long rowCount = 0;
        try {
            rowCount = instrumentDao.getCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowCount;
    }

    public List<Instrument> getByPage(int pageIndex, int pageSize) {
        List<Instrument> instruments = null;
        try {
            instruments = instrumentDao.getByPage(pageIndex, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return instruments;
    }

    public long getPageCount(int pageSize) {
        long pageCount = 0;
        try {
            long rowCount = instrumentDao.getCount();
            pageCount = (rowCount - 1) / pageSize + 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pageCount;
    }


    public Instrument getById(long id) {
        Instrument instrument = null;
        try {
            instrument = instrumentDao.getById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return instrument;
    }

    public List<Instrument> getByName(String name) {
        List<Instrument> instruments = null;
        try {
            instruments = instrumentDao.getByName(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return instruments;
    }

    public long getCountByName(String name) {
        long rowCount = 0;
        try {
            rowCount = instrumentDao.getCountByName(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowCount;
    }

    public List<Instrument> getByType(String type) {
        List<Instrument> instruments = null;
        try {
            instruments = instrumentDao.getByType(type);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return instruments;
    }

    public long getCountByType(String type) {
        long rowCount = 0;
        try {
            rowCount = instrumentDao.getCountByType(type);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowCount;
    }

    public List<Instrument> getByStatus(boolean status) {
        List<Instrument> instruments = null;
        try {
            instruments = instrumentDao.getByStatus(status);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return instruments;
    }

    public long getCountByStatus(boolean status) {
        long rowCount = 0;
        try {
            rowCount = instrumentDao.getCountByStatus(status);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowCount;
    }

}
