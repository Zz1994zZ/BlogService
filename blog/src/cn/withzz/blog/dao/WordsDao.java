package cn.withzz.blog.dao;

import cn.withzz.blog.pojos.Words;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Repository;

/**
 * Created by shmily_zz on 2017/3/23.
 */
@Repository
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class WordsDao extends BaseDaoImpl<Words>{

}
