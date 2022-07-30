package team.wy.orchestra.biz;

import org.junit.Test;
import team.wy.orchestra.bean.ChurchConcert;

import java.util.List;

/**
 * @className: ChurchConcertBizTest
 * @description:
 * @author: YORE
 * @date: 2022/7/28
 **/
public class ChurchConcertBizTest {

    ChurchConcertBiz churchConcertBiz = new ChurchConcertBiz();

    @Test
    public void addTest() {
        int count = churchConcertBiz.add(18,"Cathedral");
        System.out.println(count);
    }

    @Test
    public void removeTest() {
        int count = churchConcertBiz.remove(11);
        System.out.println(count);
    }

    @Test
    public void modifyTest() {
        int count = churchConcertBiz.modify(10, 18, "Cathedral 2nd");
        System.out.println(count);
    }

    @Test
    public void getByPageTest() {
        List<ChurchConcert> churchConcerts = null;

        churchConcerts = churchConcertBiz.getByPage(1, 5);
        System.out.println(churchConcerts.size());
        for(ChurchConcert churchConcert : churchConcerts) {
            System.out.println(churchConcert);
        }
    }

    @Test
    public void getPageCountTest() {
        int pageCount = 0;
        pageCount = churchConcertBiz.getPageCount(5);
        System.out.println(pageCount);
    }

    @Test
    public void getByIdTest() {
        ChurchConcert churchConcert = churchConcertBiz.getById(1);
        System.out.println(churchConcert);
    }

}
