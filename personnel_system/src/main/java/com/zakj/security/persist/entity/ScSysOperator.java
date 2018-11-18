package com.zakj.security.persist.entity;

import java.io.Serializable;

public class ScSysOperator implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer cmsoid; // 键主
	private String cmsologinname; // 登陆用户名
	private String cmsopassword; // 陆登密码
	private Integer cmsosex; // 性别。0:男;1:女
	private Integer cmsoage; // 龄年
	private String cmsorealname; // 实真姓名
	private String cmsoaddress; // 地址
	private String cmsophone; // 电话
	private String cmsoemail; // 邮箱地址
	private Integer cmsocompanyid; // 所属公司id
	private Integer cmsoflag; // 0:正常;1:删除
	private String cmsotoken; // 成功登录时，系统生成的令牌
	private String cmsocreatetime; // 创建时间
	private String cmsotokenupdatetime; // token更新时间
	private Integer cmsologinflag; // 是否成功登陆标记。0:未登录;1:成功登陆
	private String cmsoupdatetime; // 用户信息更新时间
	private Integer cmsotype; // 用户类型 0:普通登录人员1黄牛,2:检测员
	private String cmsoshopname;// 店铺名称
	private String ssshopname; // 店铺名称
	private String sssigndate; // 签约日期
	private String sssingname; // 签约人
	private int logintype; // 0//黄牛1系统操作人员
	private Integer ssstatus; // 0:正常;1:封停2:吊销
	private int ssselfflg;// 0:黄牛 1：翰都车辆登记人员
	private int cmsoweixindepartid;
	private String cmspipe;
	private String cmsbirthday;
	
	public String getCmsbirthday() {
		return cmsbirthday;
	}

	public void setCmsbirthday(String cmsbirthday) {
		this.cmsbirthday = cmsbirthday;
	}

	public Integer getCmsoid() {
		return cmsoid;
	}

	public void setCmsoid(Integer cmsoid) {
		this.cmsoid = cmsoid;
	}

	public String getCmsologinname() {
		return cmsologinname;
	}

	public void setCmsologinname(String cmsologinname) {
		this.cmsologinname = cmsologinname;
	}

	public String getCmsopassword() {
		return cmsopassword;
	}

	public void setCmsopassword(String cmsopassword) {
		this.cmsopassword = cmsopassword;
	}

	public Integer getCmsosex() {
		return cmsosex;
	}

	public void setCmsosex(Integer cmsosex) {
		this.cmsosex = cmsosex;
	}

	public Integer getCmsoage() {
		return cmsoage;
	}

	public void setCmsoage(Integer cmsoage) {
		this.cmsoage = cmsoage;
	}

	public String getCmsorealname() {
		return cmsorealname;
	}

	public void setCmsorealname(String cmsorealname) {
		this.cmsorealname = cmsorealname;
	}

	public String getCmsoaddress() {
		return cmsoaddress;
	}

	public void setCmsoaddress(String cmsoaddress) {
		this.cmsoaddress = cmsoaddress;
	}

	public String getCmsophone() {
		return cmsophone;
	}

	public void setCmsophone(String cmsophone) {
		this.cmsophone = cmsophone;
	}

	public String getCmsoemail() {
		return cmsoemail;
	}

	public void setCmsoemail(String cmsoemail) {
		this.cmsoemail = cmsoemail;
	}

	public Integer getCmsocompanyid() {
		return cmsocompanyid;
	}

	public void setCmsocompanyid(Integer cmsocompanyid) {
		this.cmsocompanyid = cmsocompanyid;
	}

	public Integer getCmsoflag() {
		return cmsoflag;
	}

	public void setCmsoflag(Integer cmsoflag) {
		this.cmsoflag = cmsoflag;
	}

	public String getCmsotoken() {
		return cmsotoken;
	}

	public void setCmsotoken(String cmsotoken) {
		this.cmsotoken = cmsotoken;
	}

	public String getCmsocreatetime() {
		return cmsocreatetime;
	}

	public void setCmsocreatetime(String cmsocreatetime) {
		this.cmsocreatetime = cmsocreatetime;
	}

	public Integer getCmsologinflag() {
		return cmsologinflag;
	}

	public void setCmsologinflag(Integer cmsologinflag) {
		this.cmsologinflag = cmsologinflag;
	}

	public String getCmsoupdatetime() {
		return cmsoupdatetime;
	}

	public void setCmsoupdatetime(String cmsoupdatetime) {
		this.cmsoupdatetime = cmsoupdatetime;
	}

	public Integer getCmsotype() {
		return cmsotype;
	}

	public void setCmsotype(Integer cmsotype) {
		this.cmsotype = cmsotype;
	}

	public String getCmsotokenupdatetime() {
		return cmsotokenupdatetime;
	}

	public void setCmsotokenupdatetime(String cmsotokenupdatetime) {
		this.cmsotokenupdatetime = cmsotokenupdatetime;
	}

	public String getCmsoshopname() {
		return cmsoshopname;
	}

	public void setCmsoshopname(String cmsoshopname) {
		this.cmsoshopname = cmsoshopname;
	}

	public String getSsshopname() {
		return ssshopname;
	}

	public void setSsshopname(String ssshopname) {
		this.ssshopname = ssshopname;
	}

	public String getSssigndate() {
		return sssigndate;
	}

	public void setSssigndate(String sssigndate) {
		this.sssigndate = sssigndate;
	}

	public String getSssingname() {
		return sssingname;
	}

	public void setSssingname(String sssingname) {
		this.sssingname = sssingname;
	}

	public int getLogintype() {
		return logintype;
	}

	public void setLogintype(int logintype) {
		this.logintype = logintype;
	}

	public Integer getSsstatus() {
		return ssstatus;
	}

	public void setSsstatus(Integer ssstatus) {
		this.ssstatus = ssstatus;
	}

	public int getSsselfflg() {
		return ssselfflg;
	}

	public void setSsselfflg(int ssselfflg) {
		this.ssselfflg = ssselfflg;
	}

	public int getCmsoweixindepartid() {
		return cmsoweixindepartid;
	}

	public void setCmsoweixindepartid(int cmsoweixindepartid) {
		this.cmsoweixindepartid = cmsoweixindepartid;
	}

	public String getCmspipe() {
		return cmspipe;
	}

	public void setCmspipe(String cmspipe) {
		this.cmspipe = cmspipe;
	}

}