package com.qhit.baseClass.service.impl;

import com.qhit.baseClass.service.IBaseClassService;
import java.util.List;
import com.qhit.baseClass.dao.IBaseClassDao;
import com.qhit.baseClass.pojo.BaseClass;
import org.springframework.stereotype.Service;
import javax.annotation.Resource; 

/**
* Created by GeneratorCode on 2019/01/14
*/

@Service 
public class BaseClassServiceImpl  implements IBaseClassService {

    @Resource 
    IBaseClassDao dao;

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
        BaseClass baseClass = findById(id); 
        return dao.delete(baseClass); 
    } 


    @Override 
    public List findAll() { 
        return dao.findAll(); 
    } 


    @Override 
    public BaseClass findById(Object id) { 
        List<BaseClass> list = dao.findById(id); 
        return  list.get(0); 
    } 


    @Override 
    public List<BaseClass> search(BaseClass baseClass) { 
        return dao.search(baseClass); 
    }

    @Override
    public List<BaseClass> findAlls() {
        return dao.findAlls();
    }

    @Override
    public List<BaseClass> findAllj() {
        return dao.findAllj();
    }


}