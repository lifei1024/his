package com.qhit.doctorVisitRecordinfo.dao;

import org.springframework.stereotype.Repository;
import com.qhit.doctorVisitRecordinfo.pojo.DoctorVisitRecordinfo;
import java.util.List;

/**
* Created by GeneratorCode on 2018/12/27
*/

@Repository  
public interface IDoctorVisitRecordinfoDao {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object object);


    List findAll();

    List findById(Object id);



    List<DoctorVisitRecordinfo> search(DoctorVisitRecordinfo doctorVisitRecordinfo);

    List findByVrId(Object vrId);

    List findByCodeId(Object codeId);

    List findByAmt(Object amt);

}