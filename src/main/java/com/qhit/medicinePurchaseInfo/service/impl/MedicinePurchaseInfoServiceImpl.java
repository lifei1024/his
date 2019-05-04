package com.qhit.medicinePurchaseInfo.service.impl;

import com.qhit.baseUser.pojo.BaseUser;
import com.qhit.medicinePurchaseInfo.service.IMedicinePurchaseInfoService;

import java.beans.Transient;
import java.util.List;
import com.qhit.medicinePurchaseInfo.dao.IMedicinePurchaseInfoDao;
import com.qhit.medicinePurchaseInfo.dao.impl.MedicinePurchaseInfoDaoImpl;
import com.qhit.medicinePurchaseInfo.pojo.MedicinePurchaseInfo;
import com.qhit.medicineReqPlan.pojo.MedicineReqPlan;

import javax.servlet.http.HttpSession;

/**
* Created by GeneratorCode on 2018/12/10
*/

public class MedicinePurchaseInfoServiceImpl  implements IMedicinePurchaseInfoService {

    IMedicinePurchaseInfoDao dao = new MedicinePurchaseInfoDaoImpl();

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
        MedicinePurchaseInfo medicinePurchaseInfo = findById(id); 
        return dao.delete(medicinePurchaseInfo); 
    } 


    @Override 
    public List findAll() { 
        return dao.findAll(); 
    } 


    @Override 
    public MedicinePurchaseInfo findById(Object id) { 
        List<MedicinePurchaseInfo> list = dao.findById(id); 
        return  list.get(0); 
    } 


    @Override 
    public boolean freeUpdate(String sql) {
        return dao.freeUpdate(sql);
    }


    @Override 
    public List<MedicinePurchaseInfo> search(MedicinePurchaseInfo medicinePurchaseInfo) {
            String sql = "select * from medicine_purchase_info where 1=1 "; 
            if (medicinePurchaseInfo.getMedicineCodeid()!=null && !"".equals(medicinePurchaseInfo.getMedicineCodeid())){        
                sql+=" and MEDICINE_CODEID like '%"+medicinePurchaseInfo.getMedicineCodeid()+"%' ";        
            } 
            if (medicinePurchaseInfo.getManCode()!=null && !"".equals(medicinePurchaseInfo.getManCode())){        
                sql+=" and MAN_CODE like '%"+medicinePurchaseInfo.getManCode()+"%' ";        
            } 
            if (medicinePurchaseInfo.getPchAmt()!=null && !"".equals(medicinePurchaseInfo.getPchAmt())){        
                sql+=" and PCH_AMT like '%"+medicinePurchaseInfo.getPchAmt()+"%' ";        
            } 
            if (medicinePurchaseInfo.getPchPrice()!=null && !"".equals(medicinePurchaseInfo.getPchPrice())){        
                sql+=" and PCH_PRICE like '%"+medicinePurchaseInfo.getPchPrice()+"%' ";        
            } 
            if (medicinePurchaseInfo.getPchTotal()!=null && !"".equals(medicinePurchaseInfo.getPchTotal())){        
                sql+=" and PCH_TOTAL like '%"+medicinePurchaseInfo.getPchTotal()+"%' ";        
            } 
            if (medicinePurchaseInfo.getStatus()!=null && !"".equals(medicinePurchaseInfo.getStatus())){        
                sql+=" and STATUS like '%"+medicinePurchaseInfo.getStatus()+"%' ";        
            } 
            if (medicinePurchaseInfo.getPchUserid()!=null && !"".equals(medicinePurchaseInfo.getPchUserid())){        
                sql+=" and PCH_USERID like '%"+medicinePurchaseInfo.getPchUserid()+"%' ";        
            } 
            if (medicinePurchaseInfo.getPchDate()!=null && !"".equals(medicinePurchaseInfo.getPchDate())){        
                sql+=" and PCH_DATE like '%"+medicinePurchaseInfo.getPchDate()+"%' ";        
            } 
            if (medicinePurchaseInfo.getApprvUserid()!=null && !"".equals(medicinePurchaseInfo.getApprvUserid())){        
                sql+=" and APPRV_USERID like '%"+medicinePurchaseInfo.getApprvUserid()+"%' ";        
            } 
            if (medicinePurchaseInfo.getApprvDate()!=null && !"".equals(medicinePurchaseInfo.getApprvDate())){        
                sql+=" and APPRV_DATE like '%"+medicinePurchaseInfo.getApprvDate()+"%' ";        
            } 
            List<MedicinePurchaseInfo> list = dao.freeFind(sql);        
            return list;        
    }

    @Override
    public void purchaseInfo(HttpSession session) {
        BaseUser sessionUser = (BaseUser) session.getAttribute("sessionUser");
        String sql1 = "SELECT * ,CAST(SUM(mrp.REQAMT) AS CHAR) AS count\n" +
                "from medicine_req_plan mrp JOIN medicine_code mc ON mrp.MEDICINE_CODEID=mc.code_id and mrp.STATUS=2 GROUP BY MEDICINE_CODEID";
        String sql2 = "UPDATE medicine_req_plan SET STATUS=3 WHERE STATUS=2";
        List<MedicineReqPlan> list = dao.freeFind(sql1);
        if (list!=null&&list.size()>0){
            dao.freeUpdate(sql2);
            MedicinePurchaseInfoServiceImpl service = new MedicinePurchaseInfoServiceImpl();
            MedicinePurchaseInfo medicinePurchaseInfo = new MedicinePurchaseInfo();
            for (MedicineReqPlan plan:list){
                medicinePurchaseInfo.setPchUserid(sessionUser.getUserId());
                medicinePurchaseInfo.setStatus(3);
                medicinePurchaseInfo.setPchAmt(Integer.valueOf(plan.getCount()));
                medicinePurchaseInfo.setMedicineCodeid(plan.getMedicineCodeid());
                service.insert(medicinePurchaseInfo);
            }
        }
    }

    @Override
    public List<MedicinePurchaseInfo> find(Integer userId) {
        String sql = "SELECT * from medicine_purchase_info mpi \n" +
                "JOIN medicine_code mc ON mpi.MEDICINE_CODEID=mc.code_id\n" +
                "LEFT JOIN base_manufacturer bm ON mpi.MAN_CODE=bm.man_Code\n" +
                "LEFT JOIN base_user bu ON mpi.APPRV_USERID=bu.user_id\n" +
                "AND mpi.PCH_USERID="+userId;
        return dao.freeFind(sql);
    }

    @Override
    public List<MedicinePurchaseInfo> apprvList() {
        String sql = "SELECT * from medicine_purchase_info mpi \n" +
                "JOIN medicine_code mc ON mpi.MEDICINE_CODEID=mc.code_id\n" +
                "LEFT JOIN base_manufacturer bm ON mpi.MAN_CODE=bm.man_Code\n" +
                "JOIN base_user bu ON mpi.PCH_USERID=bu.user_id\n";
        return dao.freeFind(sql);
    }

    @Override
    public void Update() {
        String sql ="UPDATE medicine_req_plan SET STATUS=4 WHERE STATUS=3";
        dao.freeUpdate(sql);
    }
    @Transient
    @Override
    public void UpdateStu(String pchid) {
        String sql = "UPDATE medicine_purchase_info SET STATUS=5 WHERE PCH_ID="+pchid;
        dao.freeUpdate(sql);
    }


}