package team.wy.orchestra.biz;

import org.junit.Test;
import team.wy.orchestra.bean.ConcertType;
import team.wy.orchestra.dao.ConcertTypeDao;

import java.sql.SQLException;
import java.util.List;


/**
 * @className: ConcertTypeBizTest
 * @description:
 * @author: YORE
 * @date: 2022/7/28
 **/
public class ConcertTypeBizTest {

    ConcertTypeBiz concertTypeBiz = new ConcertTypeBiz();

    @Test
    public void addTest() {
        int count = concertTypeBiz.add("Lucky Concert", 0);
        System.out.println(count);
    }

    @Test
    public void removeTest() {

        try {
            int count = concertTypeBiz.remove(1);
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void modifyTest() {
        int count = concertTypeBiz.modify(5, "Uptown Funk", 0);
        if(count > 0) {
            System.out.println(count);
        } else {
            System.out.println("Failed to modify!");
        }
        System.out.println(count);
    }

    @Test
    public void getAllTest() {
        List<ConcertType> concertTypes = concertTypeBiz.getAll();
        for(ConcertType concertType : concertTypes) {
            System.out.println(concertType);
        }
    }

    @Test
    public void getByIdTest() {
        ConcertType concertType = concertTypeBiz.geyById(1);
        System.out.println(concertType);
    }
}
