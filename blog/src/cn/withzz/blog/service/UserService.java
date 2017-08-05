package cn.withzz.blog.service;

import cn.withzz.blog.dao.UserDao;
import cn.withzz.blog.pojos.User;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by shmily_zz on 2017/3/23.
 */
@Service
public class UserService {
    @Resource(name = "userDao")
    private UserDao userDao;
    public User login(User user){
        User u=userDao.findOne(user.getUsername());
                if(u!=null){
                    if(u.getPassword().equals(user.getPassword()))
                        return u;
                }
                return null;
    }
    public boolean register(User user){
        return userDao.add(user)==null? false:true;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
