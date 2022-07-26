package team.wy.orchestra.biz;

import team.wy.orchestra.bean.MusicalWorkType;
import team.wy.orchestra.dao.MusicalWorkTypeDao;

import java.sql.SQLException;
import java.util.List;

/**
 * @className: MusicalWorkTypeBiz
 * @description:
 * @author: YORE
 * @date: 2022/7/26
 **/
public class MusicalWorkTypeBiz {

    MusicalWorkTypeDao musicalWorkTypeDao = new MusicalWorkTypeDao();

    public int add(String name, long parentId) {
        int count = 0;
        try {
            count = musicalWorkTypeDao.add(name,parentId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int remove(long id) {
        int count = 0;
        try {
            count = musicalWorkTypeDao.remove(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int modify(long id, String name, long parentId) {
        int count = 0;
        try {
            count = musicalWorkTypeDao.modify(id, name, parentId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public List<MusicalWorkType> getAllTypes() {
        List<MusicalWorkType> musicalWorkTypes = null;
        try {
            musicalWorkTypes = musicalWorkTypeDao.getAllTypes();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return musicalWorkTypes;
    }

    public MusicalWorkType getTypeById(long typeId) {
        MusicalWorkType musicalWorkType = null;
        try {
            musicalWorkType = musicalWorkTypeDao.getTypeById(typeId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return musicalWorkType;
    }
}
