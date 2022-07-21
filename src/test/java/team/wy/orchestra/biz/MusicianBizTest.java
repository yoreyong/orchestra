package team.wy.orchestra.biz;

import org.junit.Test;
import team.wy.orchestra.bean.Musician;

import java.util.List;

/**
 * @className: MusicianBiz
 * @description:
 * @author: YORE
 * @date: 2022/7/18
 **/
public class MusicianBizTest {

    @Test
    public void getMusicianPageCountTest() {
        MusicianBiz musicianBiz = new MusicianBiz();
        List<Musician> musicians = musicianBiz.getMusiciansByPage(1, 3);
        for(Musician musician : musicians) {
            System.out.println(musician);
        }
    }

}
