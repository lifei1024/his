package com.qhit.netstorage.dao;

import org.springframework.stereotype.Repository;
import com.qhit.netstorage.pojo.Netstorage;
import java.util.List;

/**
* Created by GeneratorCode on 2018/12/24
*/

@Repository  
public interface INetstorageDao {

    boolean insert(Object object);

    boolean  update(Object object);

    boolean  updateSelective(Object object);

    boolean delete(Object object);



    List findAll();

    List findById(Object id);



    List<Netstorage> search(Netstorage netstorage);

    List findByFilename(Object filename);

    List findByFilesize(Object filesize);

    List findByUploaddate(Object uploaddate);

    List findByUid(Object uid);

    void deleteBantch(String[] fileids);
}