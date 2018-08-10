package com.wisestar.elastic.entity;

import java.io.Serializable;

/**
* @Class 	CompanyQuotedPrice.java
* @Author 	作者姓名:刘兴 
* @Version	1.0
* @Date		创建时间：2018年8月1日 下午4:42:53
* @Copyright Copyright by 刘兴
* @Direction 类说明			材料数据承载对象
*/
public class CompanyQuotedPrice  implements Serializable {
	
	
	private static final long serialVersionUID = 1L;


	private String id;					// 材料索引ID
	private String bswName;				// 材料 名称 标签	【铜芯聚氯乙烯绝缘软电线】
	private String bswSpecify;			// 材料 规格 标签	【型号 : BVR | 芯数 : 1 | 标称截面(mm²) : 6 | 规格型号 : BVR-1×6】
	private String bswBrand;			// 材料 品牌 标签	【易初】
	private String bswUnit;				// 材料 单位 标签	【m】     米
	private String bswIncluPrice;		// 材料 含税市场价 标签	【23.32】     RMB
	private String bswTariffPrice;		// 材料 含税面价 标签 	【23.32】     RMB
	private String bswTaxRate;			// 材料 税率 标签 	【16%】   
	private String bswQuoTime;			// 材料 报价时间 标签 	【2018/09/12】   
	private String bswQuoArea;			// 材料 报价所在城市 标签 	【长沙市】   
	private String bswSupplier;			// 材料 供应商 标签 	【 湖南常德天铭混凝土有限公司 】   
	private String bswContact;			// 材料 供应商联系人 标签 	【 张维民:13507369256 】   
	private String bswContactPhone;		// 材料 供应商联系电话 标签 	【 13507369256 】   
	private String bswAddr;				// 材料 供应商地址 标签 	【 湖南省常德市武陵区芙蓉街道办事处落路口社区沅安路2068号 】   
	private String bswDuty;				// 材料 供应商纳税类型 标签 	【一般纳税人 】   
	
	public String getBswBrand() {
		return bswBrand;
	}
	public void setBswBrand(String bswBrand) {
		this.bswBrand = bswBrand;
	}
	public String getBswUnit() {
		return bswUnit;
	}
	public void setBswUnit(String bswUnit) {
		this.bswUnit = bswUnit;
	}
	public String getBswIncluPrice() {
		return bswIncluPrice;
	}
	public void setBswIncluPrice(String bswIncluPrice) {
		this.bswIncluPrice = bswIncluPrice;
	}
	public String getBswTariffPrice() {
		return bswTariffPrice;
	}
	public void setBswTariffPrice(String bswTariffPrice) {
		this.bswTariffPrice = bswTariffPrice;
	}
	public String getBswTaxRate() {
		return bswTaxRate;
	}
	public void setBswTaxRate(String bswTaxRate) {
		this.bswTaxRate = bswTaxRate;
	}
	public String getBswQuoTime() {
		return bswQuoTime;
	}
	public void setBswQuoTime(String bswQuoTime) {
		this.bswQuoTime = bswQuoTime;
	}
	public String getBswQuoArea() {
		return bswQuoArea;
	}
	public void setBswQuoArea(String bswQuoArea) {
		this.bswQuoArea = bswQuoArea;
	}
	public String getBswSupplier() {
		return bswSupplier;
	}
	public void setBswSupplier(String bswSupplier) {
		this.bswSupplier = bswSupplier;
	}
	public String getBswContact() {
		return bswContact;
	}
	public void setBswContact(String bswContact) {
		this.bswContact = bswContact;
	}
	public String getBswContactPhone() {
		return bswContactPhone;
	}
	public void setBswContactPhone(String bswContactPhone) {
		this.bswContactPhone = bswContactPhone;
	}
	public String getBswAddr() {
		return bswAddr;
	}
	public void setBswAddr(String bswAddr) {
		this.bswAddr = bswAddr;
	}
	public String getBswDuty() {
		return bswDuty;
	}
	public void setBswDuty(String bswDuty) {
		this.bswDuty = bswDuty;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBswName() {
		return bswName;
	}
	public void setBswName(String bswName) {
		this.bswName = bswName;
	}
	public String getBswSpecify() {
		return bswSpecify;
	}
	public void setBswSpecify(String bswSpecify) {
		this.bswSpecify = bswSpecify;
	}
	
	
}
