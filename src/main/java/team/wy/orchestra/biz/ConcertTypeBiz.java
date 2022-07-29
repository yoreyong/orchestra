package team.wy.orchestra.biz;

import team.wy.orchestra.bean.Concert;
import team.wy.orchestra.bean.ConcertType;
import team.wy.orchestra.dao.ConcertDao;
import team.wy.orchestra.dao.ConcertTypeDao;

import java.awt.print.Book;
import java.sql.SQLException;
import java.util.List;

/**
 * @className: ConcertTypeBiz
 * @description:
 * @author: YORE
 * @date: 2022/7/28
 **/
public class ConcertTypeBiz {

    ConcertTypeDao concertTypeDao = new ConcertTypeDao();

    public int add(String name, long parentId) {
        int count = 0;
        try {
            count = concertTypeDao.add(name, parentId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int remove(long id) throws Exception {
        int count = 0;
        // 如果有子项，不能执行删除操作
        ConcertDao concertDao = new ConcertDao();
        try {
            List<Concert> concerts = concertDao.getByTypeId(id);
            if(concerts.size() > 0) {
                // 不能删除
                throw new Exception("Foreign key exists. Failed to delete!");
            }
            count = concertTypeDao.remove(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int modify(long id, String name, long parentId) {
        int count = 0;
        try {
            count = concertTypeDao.modify(id, name, parentId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public List<ConcertType> getAll() {
        List<ConcertType> types = null;
        try {
            types = concertTypeDao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return types;
    }

    public ConcertType getById(long typeId) {
        ConcertType type = null;
        try {
            type = concertTypeDao.geyById(typeId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return type;
    }

}
