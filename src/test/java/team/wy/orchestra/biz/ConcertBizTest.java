package team.wy.orchestra.biz;

import org.junit.Test;
import team.wy.orchestra.bean.Concert;

import java.util.List;

/**
 * @className: ConcertBizTest
 * @description:
 * @author: YORE
 * @date: 2022/7/29
 **/
public class ConcertBizTest {

    ConcertBiz concertBiz = new ConcertBiz();

    @Test
    public void getByTypeId() {
        List<Concert> concerts = concertBiz.getByTypeId(1);
        System.out.println(concerts.size());
        for(Concert concert : concerts) {
            System.out.println(concert);
        }
    }
}
