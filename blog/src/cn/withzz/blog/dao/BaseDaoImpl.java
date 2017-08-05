package cn.withzz.blog.dao;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by shmily_zz on 2017/3/23.
 */
@MappedSuperclass
public class BaseDaoImpl<T> implements BaseDao<T> {
    private Class clazzP;
    private SessionFactory sessionFactory;
    public BaseDaoImpl(){
        //目的：得到实际类型参数
        //得到当前运行对象
        Class clazz = this.getClass();
        //得到当前对象父类的参数化类型,一般使用type子接口ParameterizedType
        Type type = clazz.getGenericSuperclass();
        ParameterizedType ptype=(ParameterizedType)type;
        //得到实际类型参数
        Type[] types = ptype.getActualTypeArguments();
        Class clazzParameter=(Class)types[0];
        this.clazzP=clazzParameter;
    }


    @Resource(name="sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    //添加
    public Serializable add(T t){
        return sessionFactory.getCurrentSession().save(t);
    }
    //删除
    public void delete(T t){
        sessionFactory.getCurrentSession().delete(t);
    }
    //更新
    public void update(T t){
        sessionFactory.getCurrentSession().update(t);
    }
    //根据id查询
    public T findOne(Serializable id){
        return (T)sessionFactory.getCurrentSession().get(clazzP, id);
    }
    //查询所有
    public List<T> findAll(){
        return (List<T>) sessionFactory.getCurrentSession().createQuery("from "+clazzP.getSimpleName().toLowerCase()).list();
    }

}
