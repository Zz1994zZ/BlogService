package cn.withzz.blog.dao;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.List;
/**
 * Created by shmily_zz on 2017/3/23.
 */
@MappedSuperclass
public interface BaseDao<T> {
    //添加
    public Serializable add(T t);
    //删除
    public void delete(T t);
    //更新
    public void update(T t);
    //根据id查询
    public T findOne(Serializable id);
    //查询所有
    public List<T> findAll();
}
