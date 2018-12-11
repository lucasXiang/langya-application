package com.ideacome.common.db.mapper;

import com.ideacome.common.db.domain.SysFunction;
import com.ideacome.common.db.domain.SysFunctionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysFunctionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_function
     *
     * @mbggenerated Tue Dec 11 13:49:36 CST 2018
     */
    int countByExample(SysFunctionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_function
     *
     * @mbggenerated Tue Dec 11 13:49:36 CST 2018
     */
    int deleteByExample(SysFunctionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_function
     *
     * @mbggenerated Tue Dec 11 13:49:36 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_function
     *
     * @mbggenerated Tue Dec 11 13:49:36 CST 2018
     */
    int insert(SysFunction record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_function
     *
     * @mbggenerated Tue Dec 11 13:49:36 CST 2018
     */
    int insertSelective(SysFunction record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_function
     *
     * @mbggenerated Tue Dec 11 13:49:36 CST 2018
     */
    List<SysFunction> selectByExample(SysFunctionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_function
     *
     * @mbggenerated Tue Dec 11 13:49:36 CST 2018
     */
    SysFunction selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_function
     *
     * @mbggenerated Tue Dec 11 13:49:36 CST 2018
     */
    int updateByExampleSelective(@Param("record") SysFunction record, @Param("example") SysFunctionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_function
     *
     * @mbggenerated Tue Dec 11 13:49:36 CST 2018
     */
    int updateByExample(@Param("record") SysFunction record, @Param("example") SysFunctionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_function
     *
     * @mbggenerated Tue Dec 11 13:49:36 CST 2018
     */
    int updateByPrimaryKeySelective(SysFunction record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_function
     *
     * @mbggenerated Tue Dec 11 13:49:36 CST 2018
     */
    int updateByPrimaryKey(SysFunction record);
}