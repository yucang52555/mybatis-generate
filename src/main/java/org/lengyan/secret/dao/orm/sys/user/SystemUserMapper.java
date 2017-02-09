package org.lengyan.secret.dao.orm.sys.user;

import org.lengyan.secret.common.po.sys.user.SystemUser;

public interface SystemUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SystemUser record);

    int insertSelective(SystemUser record);

    SystemUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SystemUser record);

    int updateByPrimaryKey(SystemUser record);
}