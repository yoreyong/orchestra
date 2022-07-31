package team.wy.orchestra.biz;

import org.junit.Test;
import team.wy.orchestra.bean.PlaysInstr;
import team.wy.orchestra.dao.PlaysInstrDao;

import java.sql.SQLException;
import java.util.List;

/**
 * @className: PlaysInstrBizTest
 * @description:
 * @author: YORE
 * @date: 2022/7/31
 **/
public class PlaysInstrBizTest {

    PlaysInstrBiz playsInstrBiz = new PlaysInstrBiz();

    @Test
    public void addTest() {
        int count = playsInstrBiz.add("122-39-7652", 2);
        System.out.println(count);

    }

    @Test
    public void removeTest() {
        int count = playsInstrBiz.remove(2);
        System.out.println(count);
    }

    @Test
    public void modifyTest() {
        int count = playsInstrBiz.modify(3, "122-39-7652", 2);
        System.out.println(count);
    }

    @Test
    public void getAllTest() {
        List<PlaysInstr> playsInstrs = null;
        playsInstrs = playsInstrBiz.getAll();
        System.out.println(playsInstrs.size());
        for(PlaysInstr playsInstr : playsInstrs) {
            System.out.println(playsInstr);
        }
    }

    @Test
    public void getByIdTest() {
        PlaysInstr playsInstr = playsInstrBiz.getById(3);
        System.out.println(playsInstr);
    }

    @Test
    public void getCountTest() {
        long rowCount = playsInstrBiz.getCount();
        System.out.println(rowCount);
    }
}
