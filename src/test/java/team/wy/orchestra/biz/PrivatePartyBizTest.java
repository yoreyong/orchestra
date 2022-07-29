package team.wy.orchestra.biz;

import org.junit.Test;
import team.wy.orchestra.bean.PrivateParty;

import java.util.List;

/**
 * @className: PrivatePartyBizTest
 * @description: TODO 类描述
 * @author: YORE
 * @date: 2022/7/28
 **/
public class PrivatePartyBizTest {

    PrivatePartyBiz privatePartyBiz = new PrivatePartyBiz();

    @Test
    public void addTest() {
        int count = privatePartyBiz.add(18,"B-day");
        System.out.println(count);
    }


    @Test
    public void removeTest() {
        int count = privatePartyBiz.remove(11);
        System.out.println(count);
    }

    @Test
    public void modifyTest() {
        int count = privatePartyBiz.modify(10, 18, "Cathedral 2nd");
        System.out.println(count);
    }

    @Test
    public void getByPageTest() {
        List<PrivateParty> privateParties = null;

        privateParties = privatePartyBiz.getByPage(1, 5);
        System.out.println(privateParties.size());
        for(PrivateParty privateParty : privateParties) {
            System.out.println(privateParty);
        }
    }

    @Test
    public void getPageCountTest() {
        int pageCount = 0;
        pageCount = privatePartyBiz.getPageCount(5);
        System.out.println(pageCount);
    }

    @Test
    public void getByIdTest() {
        PrivateParty privateParty = privatePartyBiz.getById(1);
        System.out.println(privateParty);
    }

    @Test
    public void getByChurchNameTest() {
        List<PrivateParty> privateParties = privatePartyBiz.getByTheme("B-day");
        System.out.println(privateParties.size());
        for(PrivateParty privateParty : privateParties) {
            System.out.println(privateParty);
        }
    }
}
