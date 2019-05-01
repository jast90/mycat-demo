package cn.jastz.mycatdemo;

import cn.jastz.mycatdemo.bean.User;
import cn.jastz.mycatdemo.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MycatDemoApplication.class)
public class MycatDemoApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    public void contextLoads() {
        User user = new User();
        user.setUserName("jast");
        System.out.println(userDao.add(user));
    }

}
