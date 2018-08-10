package com.wisestar.elastic.service.impl;

import java.util.Map;

import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wisestar.elastic.service.MaterialQuotedService;

/**
* @Class 	MaterialQuotedServiceImpl.java
* @Author 	作者姓名:刘兴 
* @Version	1.0
* @Date		创建时间：2018年8月9日 下午9:45:13
* @Copyright Copyright by 刘兴
* @Direction 类说明				实际操作，这里只做了简单的操作，后面比如说复杂查询还需要封装
*/
@Service
public class MaterialQuotedServiceImpl implements MaterialQuotedService {
	
	@Autowired
	private TransportClient client;
	
	/****
	 * 查询返回String
	 */
	public String getIndexTypeById( String indexname ,String type , String id){
		GetResponse response=client.prepareGet( indexname, type , id ).get();
		return response.getSourceAsString();
	}

	/***
	 * 保存文档
	 */
	public String saveIndex( String indexname ,String type , String json ) {
		try {
			IndexResponse response=client.prepareIndex( indexname, type ).setSource(json).get();
			//创建成功 反会的状态码是201
			if(response.status().getStatus()==201){
				return response.getId();
			}
		} catch (Exception e) {
			System.out.println( "不符合索引的数据存储，数据源为：" + json );
		}
		return null ;
	}

	/****
	 * 查询返回Map
	 */
	public Map<String,Object> getInfoByIndex( String indexname ,String type , String id ) {
		GetResponse response=client.prepareGet( indexname , type , id ).get();
		return response.getSource();
	}
	
	/***
	 * 删除文档
	 */
	public boolean deleteIndexById( String indexname ,String type , String id ) {
		DeleteResponse response=client.prepareDelete(  indexname , type , id ).get();
		if(response.status().getStatus()==200){
			return true ;
		}
		return false ;
	}
	
	/***
	 * 跟新文档
	 */
	public boolean UpdateIndexById( String indexname ,String type , String id , String doc ) throws Exception{
		UpdateRequest updateRequest = new UpdateRequest(indexname, type, id).doc(doc);
		UpdateResponse response = client.update(updateRequest).get();
		if (response.status().getStatus() == 200) {
			return true;
		}
		return false;
	}
	
}
