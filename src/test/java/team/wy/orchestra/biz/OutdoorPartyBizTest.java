package team.wy.orchestra.biz;

import org.junit.Test;
import team.wy.orchestra.bean.OutdoorParty;
import team.wy.orchestra.bean.PrivateParty;

import java.util.List;

/**
 * @className: OutdoorPartyBizTest
 * @description:
 * @author: YORE
 * @date: 2022/7/28
 **/
public class OutdoorPartyBizTest {

    OutdoorPartyBiz outdoorPartyBiz = new OutdoorPartyBiz();

    @Test
    public void addTest() {
        int count = outdoorPartyBiz.add(18,"Blue");
        System.out.println(count);
    }

    @Test
    public void removeTest() {
        int count = outdoorPartyBiz.remove(11);
        System.out.println(count);
    }

    @Test
    public void modifyTest() {
        int count = outdoorPartyBiz.modify(10, 18, "Cathedral 2nd");
        System.out.println(count);
    }

    @Test
    public void getByPageTest() {
        List<OutdoorParty> outdoorParties = null;

        outdoorParties = outdoorPartyBiz.getByPage(1, 5);
        System.out.println(outdoorParties.size());
        for(OutdoorParty outdoorParty : outdoorParties) {
            System.out.println(outdoorParty);
        }
    }

    @Test
    public void getPageCountTest() {
        int pageCount = 0;
        pageCount = outdoorPartyBiz.getPageCount(5);
        System.out.println(pageCount);
    }

    @Test
    public void getByIdTest() {
        OutdoorParty outdoorParty = outdoorPartyBiz.getById(1);
        System.out.println(outdoorParty);
    }

}
