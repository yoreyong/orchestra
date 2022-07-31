package team.wy.orchestra.biz;

import org.junit.Test;

/**
 * @className: RequireInstrumentBizTest
 * @description:
 * @author: YORE
 * @date: 2022/7/31
 **/
public class RequireInstrumentBizTest {

    RequireInstrumentBiz requireInstrumentBiz = new RequireInstrumentBiz();

    @Test
    public void addTest() {
        int count = requireInstrumentBiz.add(1, 11);
        System.out.println(count);
    }


}
