package com.wisestar.elastic.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
* @Class 	ElasticSearchProperties.java
* @Author 	作者姓名:刘兴 
* @Version	1.0
* @Date		创建时间：2018年8月10日 上午10:04:34
* @Copyright Copyright by 刘兴
* @Direction 类说明		多个索引建立等信息到时候全部读取配置文件
*/
@Component
@Configuration
@PropertySource("classpath:elasticsearch.properties")
public class ElasticSearchProperties {

	
	@Value("${es.main.index}")
	private String esMainIndex;			// 主索引【可能我们会建立多张索引库】
	
	@Value("${es.main.type}")
	private String esMainType;			// 主索引的type

	public String getEsMainIndex() {
		return esMainIndex;
	}

	public void setEsMainIndex(String esMainIndex) {
		this.esMainIndex = esMainIndex;
	}

	public String getEsMainType() {
		return esMainType;
	}

	public void setEsMainType(String esMainType) {
		this.esMainType = esMainType;
	}
	
}
