package com.luv2code.springboot.demo.mycoolapp;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;

import java.io.IOException;

public class dataDelivery {
	
	public SolrDocumentList get_data() throws SolrServerException, IOException{
		
		String urlString = "http://localhost:8983/solr/techproducts";
	
		SolrClient Solr = new HttpSolrClient.Builder(urlString).build();  
	      
	      //Preparing Solr query 
	      SolrQuery query = new SolrQuery();  
	      query.setQuery("*:*");  
	   
	      //Adding the field to be retrieved 
	      query.addField("*");  
	   
	      //Executing the query 
	      QueryResponse queryResponse = Solr.query(query);  
	   
	      //Storing the results of the query 
	      SolrDocumentList list = queryResponse.getResults();
	      System.out.println(list);
	      
	         
	      //Saving the operations 
	      Solr.commit();
	      return list;
	}
}
