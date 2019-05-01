package cn.jastz.mycatdemo.dao;

import cn.jastz.mycatdemo.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    int add(User user);
}
