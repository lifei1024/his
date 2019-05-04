package com.qhit.baseDept.dao.impl;

import com.qhit.baseDept.dao.IBaseDeptDao;
import com.qhit.utils.BaseDao;
import java.util.List;

/**
* Created by GeneratorCode on 2018/12/19
*/

public class BaseDeptDaoImpl extends BaseDao implements IBaseDeptDao {

    @Override 
    public List findAll() { 
        String sql = "select * from base_dept"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findById(Object id) { 
        String sql = "select * from base_dept where dept_id='"+id+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByDeptName(Object deptName) { 
        String sql = "select * from base_dept where dept_name='"+deptName+"'"; 
        return freeFind(sql); 
    } 




}