package com.zakj.security.dao;

import com.zakj.security.persist.bean.ScSysOperatorBean;
import com.zakj.security.persist.entity.ScSysOperator;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**/

/**/

@Repository
public interface ScSysOperatorDao {
	@Select("select count(1) from sc_sys_operator ${filter} ")
	int queryScSysOperatorListSize(@Param("filter") String filter);

	@Select("select *,date_format(cmsbirthday,'%Y-%m-%d') cmsbirthdaydisp from sc_sys_operator ${filter} ")
	List<ScSysOperatorBean> queryScSysOperatorList(@Param("filter") String filter);

	int queryUserCount(@Param("filterSql") String filterSql);
	List<ScSysOperatorBean> queryUserList(@Param("filterSql") String filterSql);




	@Select("select * from sc_sys_operator where cmsoid=#{cmsoid} limit 1 ")
	ScSysOperatorBean getScSysOperator(@Param("cmsoid") int cmsoid);

	@Update("update sc_sys_operator set cmsologinname=#{cmsologinname},cmsopassword=#{cmsopassword},cmsosex=#{cmsosex},cmsoage=#{cmsoage}, "
			+ " cmsorealname=#{cmsorealname},cmsoaddress=#{cmsoaddress},cmsophone=#{cmsophone},cmsoemail=#{cmsoemail},cmsbirthday=#{cmsbirthday} where cmsoid=#{cmsoid} ")
	int updateOperator(ScSysOperator operator);

	@Insert("insert into sc_sys_operator (cmsologinname,cmsopassword,cmsosex,cmsoage,cmsorealname,cmsoaddress,cmsophone,cmsoemail,cmsbirthday) "
			+ "                   values(#{cmsologinname},#{cmsopassword},#{cmsosex},#{cmsoage},#{cmsorealname},#{cmsoaddress},#{cmsophone},#{cmsoemail},#{cmsbirthday})")
	@Options(useGeneratedKeys=true, keyProperty="cmsoid")
	int insertOperator(ScSysOperator operator);

	@Delete("delete from sc_sys_operator where cmsoid=#{cmsoid} ")
	void delOperatorBycmsoid(@Param("cmsoid") int cmsoid);

	@Delete("delete from sc_sys_operator where cmsoid in (${cmsoids}) ")
	void delOperatorBycmsoids(@Param("cmsoids") String cmsoids);

}
