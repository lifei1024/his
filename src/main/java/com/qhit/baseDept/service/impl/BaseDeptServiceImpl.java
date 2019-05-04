package com.qhit.baseDept.service.impl;

import com.qhit.baseDept.service.IBaseDeptService;
import java.util.List;
import com.qhit.baseDept.dao.IBaseDeptDao;
import com.qhit.baseDept.dao.impl.BaseDeptDaoImpl;
import com.qhit.baseDept.pojo.BaseDept;

/**
* Created by GeneratorCode on 2018/12/19
*/

public class BaseDeptServiceImpl  implements IBaseDeptService {

    IBaseDeptDao dao = new BaseDeptDaoImpl();

    @Override 
    public boolean insert(Object object) { 
        return dao.insert(object); 
    } 


    @Override 
    public boolean update(Object object) { 
        return dao.update(object); 
    } 


    @Override 
    public boolean updateSelective(Object object) { 
        return dao.updateSelective(object); 
    } 


    @Override 
    public boolean delete(Object id) { 
        BaseDept baseDept = findById(id); 
        return dao.delete(baseDept); 
    } 


    @Override 
    public List findAll() { 
        return dao.findAll(); 
    } 


    @Override 
    public BaseDept findById(Object id) { 
        List<BaseDept> list = dao.findById(id); 
        return  list.get(0); 
    } 


    @Override 
    public boolean freeUpdate(String sql) {
        return dao.freeUpdate(sql);
    }


    @Override 
    public List<BaseDept> search(BaseDept baseDept) {
            String sql = "select * from base_dept where 1=1 "; 
            if (baseDept.getDeptName()!=null && !"".equals(baseDept.getDeptName())){        
                sql+=" and dept_name like '%"+baseDept.getDeptName()+"%' ";        
            } 
            List<BaseDept> list = dao.freeFind(sql);        
            return list;        
    }


}