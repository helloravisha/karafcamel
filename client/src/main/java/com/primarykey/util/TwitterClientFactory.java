package com.primarykey.util;

public class TwitterClientFactory {
        public static   TwitterRestInterface getTwitterRestInterface(String interfaceName,String hostName,String portNumber){
        	  if(interfaceName == "JERSEY_REST_CLIENT"){
        		  return new JerseyRestClient(hostName,portNumber);
        	  }else{
        		  return null;
        	  }
        }
}
