package com.qhit.baseClass.dao;

import org.springframework.stereotype.Repository;
import com.qhit.baseClass.pojo.BaseClass;
import java.util.List;

/**
* Created by GeneratorCode on 2019/01/14
*/

@Repository  
public interface IBaseClassDao {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object object);

    List freeFind(String sql);

    List findAll();

    List findById(Object id);

    boolean freeUpdate(String sql);

    List<BaseClass> search(BaseClass baseClass);

    List findByClassName(Object className);

    List<BaseClass> findAlls();

    List<BaseClass> findAllj();
}