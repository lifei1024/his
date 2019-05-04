package com.qhit.telvisit.dao;

import com.qhit.utils.BaseDao;
import java.util.List;

/**
* Created by GeneratorCode on 2018/12/05
*/

public interface ITelvisitDao {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object object);

    List freeFind(String sql);

    List findAll();

    List findById(Object id);

    boolean freeUpdate(String sql);

    List findByTelname(Object telname);

    List findByTeltime(Object teltime);

    List findByVisitreason(Object visitreason);

    List findByVisitreturn(Object visitreturn);

    List findByVisittype(Object visittype);

    List findByCid(Object cid);

}