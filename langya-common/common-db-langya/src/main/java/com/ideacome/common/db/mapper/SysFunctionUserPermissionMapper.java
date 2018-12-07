package com.ideacome.common.db.mapper;

import com.ideacome.common.db.domain.SysFunctionUserPermission;
import com.ideacome.common.db.domain.SysFunctionUserPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysFunctionUserPermissionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_function_user_permisssion
     *
     * @mbggenerated Fri Dec 07 10:29:52 CST 2018
     */
    int countByExample(SysFunctionUserPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_function_user_permisssion
     *
     * @mbggenerated Fri Dec 07 10:29:52 CST 2018
     */
    int deleteByExample(SysFunctionUserPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_function_user_permisssion
     *
     * @mbggenerated Fri Dec 07 10:29:52 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_function_user_permisssion
     *
     * @mbggenerated Fri Dec 07 10:29:52 CST 2018
     */
    int insert(SysFunctionUserPermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_function_user_permisssion
     *
     * @mbggenerated Fri Dec 07 10:29:52 CST 2018
     */
    int insertSelective(SysFunctionUserPermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_function_user_permisssion
     *
     * @mbggenerated Fri Dec 07 10:29:52 CST 2018
     */
    List<SysFunctionUserPermission> selectByExample(SysFunctionUserPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_function_user_permisssion
     *
     * @mbggenerated Fri Dec 07 10:29:52 CST 2018
     */
    SysFunctionUserPermission selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_function_user_permisssion
     *
     * @mbggenerated Fri Dec 07 10:29:52 CST 2018
     */
    int updateByExampleSelective(@Param("record") SysFunctionUserPermission record, @Param("example") SysFunctionUserPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_function_user_permisssion
     *
     * @mbggenerated Fri Dec 07 10:29:52 CST 2018
     */
    int updateByExample(@Param("record") SysFunctionUserPermission record, @Param("example") SysFunctionUserPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_function_user_permisssion
     *
     * @mbggenerated Fri Dec 07 10:29:52 CST 2018
     */
    int updateByPrimaryKeySelective(SysFunctionUserPermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_function_user_permisssion
     *
     * @mbggenerated Fri Dec 07 10:29:52 CST 2018
     */
    int updateByPrimaryKey(SysFunctionUserPermission record);
}