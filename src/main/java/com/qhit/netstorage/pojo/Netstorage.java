package com.qhit.netstorage.pojo;


import com.qhit.baseUser.pojo.BaseUser;

/**
* Created by GeneratorCode on 2018/12/24
*/
public class Netstorage {

    private Integer fileid;    //id
    private String filename;    //文件名
    private String filesize;    //文件长度
    private String uploaddate;    //上传时间
    private Integer uid;    //用户id
    private BaseUser baseUser;

    public BaseUser getBaseUser() {
        return baseUser;
    }

    public void setBaseUser(BaseUser baseUser) {
        this.baseUser = baseUser;
    }

    public Integer getFileid() {
        return fileid;
    }
 
    public void setFileid(Integer fileid) { 
        this.fileid = fileid;
    }
 
    public String getFilename() { 
        return filename;
    }
 
    public void setFilename(String filename) { 
        this.filename = filename;
    }
 
    public String getFilesize() { 
        return filesize;
    }
 
    public void setFilesize(String filesize) { 
        this.filesize = filesize;
    }
 
    public String getUploaddate() { 
        return uploaddate;
    }
 
    public void setUploaddate(String uploaddate) { 
        this.uploaddate = uploaddate;
    }
 
    public Integer getUid() { 
        return uid;
    }
 
    public void setUid(Integer uid) { 
        this.uid = uid;
    }
 

 }