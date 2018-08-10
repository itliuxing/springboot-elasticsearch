package com.wisestar.elastic.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wisestar.elastic.conf.ElasticSearchProperties;
import com.wisestar.elastic.entity.CompanyQuotedPrice;
import com.wisestar.elastic.service.MaterialQuotedService;

/**
* @Class 	MaterialController.java
* @Author 	作者姓名:刘兴 
* @Version	1.0
* @Date		创建时间：2018年8月9日 下午4:57:10
* @Copyright Copyright by 刘兴
* @Direction 类说明			一个简单的使用版本，后期的复杂查询要建立在数据量大的基础上
*/
@RestController
public class MaterialController {
	
	
	@Autowired
	private ElasticSearchProperties conf ;				// 配置文件，引用配置参数使用
	
	@Autowired
    private MaterialQuotedService materialRepository;	// 调用我们的接口与elasticsearch通讯
	
	// 本接口的数据来源是爬虫爬出来的数据写入搜索引擎
	//http://localhost:8008/save
    @PostMapping("save")
    public String save(CompanyQuotedPrice material ){
    	try {
			ObjectMapper mapper =new ObjectMapper(); 
			String json  =mapper.writeValueAsString( material );
			String result = materialRepository.saveIndex(conf.getEsMainIndex(), conf.getEsMainType(), json);
			if( result == null ) {
				System.out.println( "存储失败 ......" );
			}
			return "success";
		} catch (JsonProcessingException e) {
			return "false";
		}
    }

    //http://localhost:8008/delete?id=AWUfPMRENSdSGyKuqpga
    @GetMapping("delete")
    public String delete(String id){
    	boolean result = materialRepository.deleteIndexById( conf.getEsMainIndex(), conf.getEsMainType(), id);
    	return result + "" ;
    }

    //http://localhost:8008/update?id=1525417362754&name=修改&description=修改
    @GetMapping("update")
    public String update( CompanyQuotedPrice material  ){
    	try {
			ObjectMapper mapper =new ObjectMapper(); 
			String json  =mapper.writeValueAsString( material );
			materialRepository.UpdateIndexById( conf.getEsMainIndex(), conf.getEsMainType(), material.getId() , json);
			return "success";
		} catch ( Exception e) {
			return "false";
		}
    }

    //http://localhost:8008/getOne?id=1525417362754
    @GetMapping("getOne")
    public String getOne(String id){
    	return materialRepository.getIndexTypeById(conf.getEsMainIndex(), conf.getEsMainType(), id) ;
    }


    //http://localhost:8008/getGoodsList?query=商品
    //http://localhost:8008/getGoodsList?query=商品&pageNumber=1
    //根据关键字"商品"去查询列表，name或者description包含的都查询
/*    @GetMapping("getGoodsList")
    public List<CompanyQuotedPrice> getList(Integer pageNumber,String query){
        if(pageNumber==null) pageNumber = 0;
        //es搜索默认第一页页码是0
        SearchQuery searchQuery=getEntitySearchQuery(pageNumber,PAGESIZE,query);
        Page<CompanyQuotedPrice> goodsPage = materialRepository.search(searchQuery);
        return goodsPage.getContent();
    }*/


   /* private SearchQuery getEntitySearchQuery(int pageNumber, int pageSize, String searchContent) {
        FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery()
                .add(QueryBuilders.matchPhraseQuery("name", searchContent),
                        ScoreFunctionBuilders.weightFactorFunction(100))
                .add(QueryBuilders.matchPhraseQuery("description", searchContent),
                        ScoreFunctionBuilders.weightFactorFunction(100))
                //设置权重分 求和模式
                .scoreMode("sum")
                //设置权重分最低分
                .setMinScore(10);

        // 设置分页
        Pageable pageable = new PageRequest(pageNumber, pageSize);
        return new NativeSearchQueryBuilder()
                .withPageable(pageable)
                .withQuery(functionScoreQueryBuilder).build();
    }*/
	

}
