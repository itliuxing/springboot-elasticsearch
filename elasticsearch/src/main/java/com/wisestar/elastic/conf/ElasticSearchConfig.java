package com.wisestar.elastic.conf;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
* @Class 	ElasticSearchConfig.java
* @Author 	作者姓名:刘兴 
* @Version	1.0
* @Date		创建时间：2018年8月9日 下午9:16:02
* @Copyright Copyright by 刘兴
* @Direction 类说明		这个主要是封装生成：TransportClient 这个是elasticsearch的客户端调用接口
*/
@Configuration
@PropertySource("classpath:elasticsearch.properties")
public class ElasticSearchConfig {

	@Value("${es.hosts}")
	private String esHosts;
	
	@Value("${cluster.name}")
	private String clusterName;
	
	@Bean
	public TransportClient geTransportClient() throws UnknownHostException{
		Settings settings=Settings.builder().put("cluster.name",clusterName).build();
		TransportClient client=new PreBuiltTransportClient(settings);
		String[] hosts=esHosts.split(",");
		for(String host:hosts){
			// 如果我们配置多个host，自动识别配置多个节点
			client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host),9300));
		}
		return client;
	}
	
}
