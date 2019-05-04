package com.qhit.baseClass.service;

import java.util.List;
import com.qhit.baseClass.pojo.BaseClass;
/**
* Created by GeneratorCode on 2019/01/14
*/

public interface IBaseClassService {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object id);

    List findAll();

    BaseClass findById(Object id);

    List<BaseClass> search(BaseClass baseClass);

    List<BaseClass> findAlls();

    List<BaseClass> findAllj();
}