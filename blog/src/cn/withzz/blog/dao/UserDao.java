package cn.withzz.blog.dao;

import cn.withzz.blog.pojos.User;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by shmily_zz on 2017/3/23.
 */
@Repository
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class UserDao extends BaseDaoImpl<User>{

}
