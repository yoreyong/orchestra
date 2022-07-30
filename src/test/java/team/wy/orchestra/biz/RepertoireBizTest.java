package team.wy.orchestra.biz;

import org.junit.Test;
import team.wy.orchestra.bean.Repertoire;

import java.util.List;

/**
 * @className: RepertoireBizTest
 * @description:
 * @author: YORE
 * @date: 2022/7/30
 **/
public class RepertoireBizTest {

    RepertoireBiz repertoireBiz = new RepertoireBiz();

    @Test
    public void addTest() {
        int count = repertoireBiz.add(1, 2);
        System.out.println(count);
    }

    @Test
    public void removeTest() {
        int count = repertoireBiz.remove(11);
        System.out.println(count);
    }

    @Test
    public void modifyTest() {
        int count = repertoireBiz.modify(10, 2, 5);
        System.out.println(count);
    }

    @Test
    public void getAllTest() {
        List<Repertoire> repertoires = repertoireBiz.getAll();
        System.out.println(repertoires.size());
        for(Repertoire repertoire : repertoires) {
            System.out.println(repertoire);
        }
    }

    @Test
    public void getByIdTest() {
        Repertoire repertoire = repertoireBiz.getById(10);
        System.out.println(repertoire);
    }

    @Test
    public void getByConcertIdTest() {
        List<Repertoire> repertoires = repertoireBiz.getByConcertId(1);
        System.out.println(repertoires.size());
        for(Repertoire repertoire : repertoires) {
            System.out.println(repertoire);
        }
    }

}
