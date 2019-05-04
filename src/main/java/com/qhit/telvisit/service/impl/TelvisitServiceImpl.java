package com.qhit.telvisit.service.impl;

import com.qhit.telvisit.service.ITelvisitService;
import java.util.List;
import com.qhit.telvisit.dao.ITelvisitDao;
import com.qhit.telvisit.dao.impl.TelvisitDaoImpl;
import com.qhit.telvisit.pojo.Telvisit;

/**
* Created by GeneratorCode on 2018/12/05
*/

public class TelvisitServiceImpl  implements ITelvisitService {

    ITelvisitDao dao = new TelvisitDaoImpl();

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
        Telvisit telvisit = findById(id); 
        return dao.delete(telvisit); 
    } 


    @Override 
    public List findAll() { 
        return dao.findAll(); 
    } 


    @Override 
    public Telvisit findById(Object id) { 
        List<Telvisit> list = dao.findById(id); 
        return  list.get(0); 
    } 


    @Override 
    public boolean freeUpdate(String sql) {
        return dao.freeUpdate(sql);
    }


    @Override 
    public List<Telvisit> search(Telvisit telvisit) {
            String sql = "select * from telvisit where 1=1 "; 
            if (telvisit.getTelname()!=null && !"".equals(telvisit.getTelname())){        
                sql+=" and telname like '%"+telvisit.getTelname()+"%' ";        
            } 
            if (telvisit.getTeltime()!=null && !"".equals(telvisit.getTeltime())){        
                sql+=" and teltime like '%"+telvisit.getTeltime()+"%' ";        
            } 
            if (telvisit.getVisitreason()!=null && !"".equals(telvisit.getVisitreason())){        
                sql+=" and visitreason like '%"+telvisit.getVisitreason()+"%' ";        
            } 
            if (telvisit.getVisitreturn()!=null && !"".equals(telvisit.getVisitreturn())){        
                sql+=" and visitreturn like '%"+telvisit.getVisitreturn()+"%' ";        
            } 
            if (telvisit.getVisittype()!=null && !"".equals(telvisit.getVisittype())){        
                sql+=" and visittype like '%"+telvisit.getVisittype()+"%' ";        
            } 
            if (telvisit.getCid()!=null && !"".equals(telvisit.getCid())){        
                sql+=" and cid like '%"+telvisit.getCid()+"%' ";        
            } 
            List<Telvisit> list = dao.freeFind(sql);        
            return list;        
    }

    @Override
    public List<Telvisit> findByCid(Integer cid) {
        String sql ="select * from telvisit where cid="+cid+" order by teltime desc";
        return dao.freeFind(sql);
    }


}