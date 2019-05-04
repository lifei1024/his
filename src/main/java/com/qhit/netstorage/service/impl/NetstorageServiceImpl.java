package com.qhit.netstorage.service.impl;

import com.qhit.netstorage.service.INetstorageService;
import java.util.List;
import com.qhit.netstorage.dao.INetstorageDao;
import com.qhit.netstorage.pojo.Netstorage;
import org.springframework.stereotype.Service;
import javax.annotation.Resource; 

/**
* Created by GeneratorCode on 2018/12/24
*/

@Service 
public class NetstorageServiceImpl  implements INetstorageService {

    @Resource 
    INetstorageDao dao;

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
        Netstorage netstorage = findById(id); 
        return dao.delete(netstorage); 
    } 


    @Override 
    public List findAll() { 
        return dao.findAll(); 
    } 


    @Override 
    public Netstorage findById(Object id) { 
        List<Netstorage> list = dao.findById(id); 
        return  list.get(0); 
    } 


    @Override 
    public List<Netstorage> search(Netstorage netstorage) { 
        return dao.search(netstorage); 
    }

    @Override
    public void deleteBantch(String[] fileids) {
        dao.deleteBantch(fileids);
    }


}