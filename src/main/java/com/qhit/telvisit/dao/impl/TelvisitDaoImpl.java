package com.qhit.telvisit.dao.impl;

import com.qhit.telvisit.dao.ITelvisitDao;
import com.qhit.utils.BaseDao;
import java.util.List;

/**
* Created by GeneratorCode on 2018/12/05
*/

public class TelvisitDaoImpl extends BaseDao implements ITelvisitDao {

    @Override 
    public List findAll() { 
        String sql = "select * from telvisit"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findById(Object id) { 
        String sql = "select * from telvisit where tvid='"+id+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByTelname(Object telname) { 
        String sql = "select * from telvisit where telname='"+telname+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByTeltime(Object teltime) { 
        String sql = "select * from telvisit where teltime='"+teltime+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByVisitreason(Object visitreason) { 
        String sql = "select * from telvisit where visitreason='"+visitreason+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByVisitreturn(Object visitreturn) { 
        String sql = "select * from telvisit where visitreturn='"+visitreturn+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByVisittype(Object visittype) { 
        String sql = "select * from telvisit where visittype='"+visittype+"'"; 
        return freeFind(sql); 
    } 


    @Override 
    public List findByCid(Object cid) { 
        String sql = "select * from telvisit where cid='"+cid+"'"; 
        return freeFind(sql); 
    } 




}