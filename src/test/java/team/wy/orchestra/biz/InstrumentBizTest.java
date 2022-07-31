package team.wy.orchestra.biz;

import org.junit.Test;
import team.wy.orchestra.bean.Instrument;

import java.util.List;

/**
 * @className: InstrumentBizTest
 * @description: TODO 类描述
 * @author: YORE
 * @date: 2022/7/31
 **/
public class InstrumentBizTest {

    InstrumentBiz instrumentBiz = new InstrumentBiz();

    @Test
    public void addTest() {
        int count = instrumentBiz.add("guitar", "strings", false);
        System.out.println(count);
    }

    @Test
    public void removeTest() {
        int count = instrumentBiz.remove(7);
        System.out.println(count);
    }

    @Test
    public void modifyTest() {
        int count = instrumentBiz.modify(8,"guitar", "strings", true);
        System.out.println(count);
    }

    @Test
    public void getAllTest() {
        List<Instrument> instruments = null;
        instruments = instrumentBiz.getAll();
        System.out.println(instruments.size());
        for(Instrument instrument : instruments) {
            System.out.println(instrument);
        }
    }

    @Test
    public void geyCountTest() {
        long rowCount = instrumentBiz.getCount();
        System.out.println(rowCount);
    }

    @Test
    public void getByIdTest() {
        Instrument instrument = instrumentBiz.getById(1);
        System.out.println(instrument);
    }

    @Test
    public void getByNameTest() {
        List<Instrument> instruments = instrumentBiz.getByName("guitar");
        System.out.println(instruments.size());
        for(Instrument instrument : instruments) {
            System.out.println(instrument);
        }
    }

    @Test
    public void getCountByNameTest() {
        long rowCount = instrumentBiz.getCountByName("guitar");
        System.out.println(rowCount);
    }


}
