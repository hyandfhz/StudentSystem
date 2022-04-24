## Teacher

***

- _**TeacherId**_
    - `BIGINT(15)`
    - `PrimaryKey`
- **_TeacherName_**
    - `VARCHAR(100)`
- **_LoginId_**
    - `VARCHAR(100)`
- **_PassWord_**
    - `VARCHAR(100)`
    - > MD5加密
- **_TeacherMobile_**
    - `VARCHAR(100)`
- **_CreateTime_**
    - `DATETIME`
    - > DEFAULT `CURRENT_TIMESTAMP`
- **_Status_**
    - `VARCHAR(20)`
    - > **NORMAL** 正常
      >
      > **DELETE** 删除
- **_Role_**
    - VARCHAR(20)
    - > **ADMIN**
      >  > - 增加老师
      >  >
      >  > - 增加学生，修改班级
      >  >
      >  > - 查询功能
      >
      > **HIGH**
      >  > - 增加学生，修改班级
      >  >
      >  > - 查询功能
      >
      > **USER**
      >  > - 查询功能