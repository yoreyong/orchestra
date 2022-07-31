package team.wy.orchestra.biz;

import org.junit.Test;
import team.wy.orchestra.bean.Participate;

import java.util.List;

/**
 * @className: ParticipateBizTest
 * @description: TODO 类描述
 * @author: YORE
 * @date: 2022/7/31
 **/
public class ParticipateBizTest {

    ParticipateBiz participateBiz = new ParticipateBiz();

    @Test
    public void addTest() {
        int count = participateBiz.add("223-13-9316", 2);
        System.out.println(count);
    }

    @Test
    public void removetest() {
        int count = participateBiz.remove(1);
        System.out.println(count);
    }

    @Test
    public void modifyTest() {
        int count = participateBiz.modify(7, "758-71-5199", 2);
        System.out.println(count);
    }

    @Test
    public void getAllTest() {
        List<Participate> participates = null;
        participates = participateBiz.getAll();
        System.out.println(participates.size());
        for(Participate participate : participates) {
            System.out.println(participate);
        }
    }

    @Test
    public void getByIdTest() {
        Participate participate = null;
        participate = participateBiz.getById(2);
        System.out.println(participate);
    }

    @Test
    public void getCountTest() {
        System.out.println(participateBiz.getCount());
    }

    @Test
    public void getBySSNTest() {
        List<Participate> participates = null;
        participates = participateBiz.getBySSN("223-13-9316");
        System.out.println(participates.size());
        for(Participate participate : participates) {
            System.out.println(participate);
        }
    }
    @Test
    public void getCountByconIdTest() {
        System.out.println(participateBiz.getCountByconId(2));
    }

}
