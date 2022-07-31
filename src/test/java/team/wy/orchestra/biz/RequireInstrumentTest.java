package team.wy.orchestra.biz;

import org.junit.Test;
import team.wy.orchestra.bean.RequireInstrument;

import java.util.List;

/**
 * @className: RequireInstrumentTest
 * @description:
 * @author: YORE
 * @date: 2022/7/31
 **/
public class RequireInstrumentTest {

    RequireInstrumentBiz requireInstrumentBiz = new RequireInstrumentBiz();

    @Test
    public void addTest() {
        int count = requireInstrumentBiz.add(1, 5);
        System.out.println(count);
    }

    @Test
    public void removeTest() {
        int count = requireInstrumentBiz.remove(1);
        System.out.println(count);
    }

    @Test
    public void modifyTest() {
        int count = requireInstrumentBiz.modify(2, 2, 5);
        System.out.println(count);
    }

    @Test
    public void getAllTest() {
        List<RequireInstrument> requireInstruments = null;
        requireInstruments = requireInstrumentBiz.getAll();
        System.out.println(requireInstruments.size());
        for(RequireInstrument requireInstrument : requireInstruments) {
            System.out.println(requireInstrument);
        }
    }

    @Test
    public void getByIdTest() {
        RequireInstrument requireInstrument = null;
        requireInstrument = requireInstrumentBiz.getById(10);
        System.out.println(requireInstrument);
    }

    @Test
    public void getCOuntTest() {
        long rowCount = 0;
        rowCount = requireInstrumentBiz.getCount();
        System.out.println(rowCount);
    }

    @Test
    public void getByInstrumentTest() {
        List<RequireInstrument> requireInstruments = null;
        requireInstruments = requireInstrumentBiz.getByInstrument(1);
        System.out.println(requireInstruments.size());
        for(RequireInstrument requireInstrument : requireInstruments) {
            System.out.println(requireInstrument);
        }
    }

    @Test
    public void getCountByInstrumentTest() {
        long rowCount = requireInstrumentBiz.getCountByInstrument(1);
        System.out.println(rowCount);
    }

    @Test
    public void getByMusicalWorkTest() {
        List<RequireInstrument> requireInstruments = null;
        requireInstruments = requireInstrumentBiz.getByMusicalWork(5);
        System.out.println(requireInstruments.size());
        for(RequireInstrument requireInstrument : requireInstruments) {
            System.out.println(requireInstrument);
        }
    }

    @Test
    public void getCountByMusicalWorkTest() {
        long rowCount = requireInstrumentBiz.getCountByMusicalWork(5);
        System.out.println(rowCount);
    }

}
