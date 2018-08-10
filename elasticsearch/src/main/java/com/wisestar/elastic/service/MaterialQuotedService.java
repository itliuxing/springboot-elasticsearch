package com.wisestar.elastic.service;

import java.util.Map;

/***
 * 
 * @Class 	MaterialQuotedService.java
 * @Author 	作者姓名:Liuxing
 * @Version	1.0
 * @Date	创建时间：2018年8月9日 下午9:42:34
 * @Copyright Copyright by Liuxing
 * @Direction 类说明			提供调用elasticsearch的接口服务类
 */
public interface MaterialQuotedService {
	
	public String getIndexTypeById( String indexname ,String type , String id);
	
	public String saveIndex( String indexname ,String type , String json ) ;

	Map<String,Object> getInfoByIndex( String indexname ,String type , String id ) ;
	
	 boolean deleteIndexById( String indexname ,String type , String id ) ;
	
	 boolean UpdateIndexById( String indexname ,String type , String id , String doc ) throws Exception ;
	
}
