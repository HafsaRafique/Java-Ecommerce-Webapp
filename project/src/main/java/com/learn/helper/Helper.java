package com.learn.helper;


import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;


public class Helper {
public static String get10Words(String desc) {
	String[]strs= desc.split(" ");
	if(strs.length>10) {
		String res="";
	
		for(int i=0; i<10; i++) {
			res= res+strs[i]+" ";
		}
		return(res+"...more");
	}else {
		return(desc+ "...");
	}
}
public static Map<String, Long> getCounts(SessionFactory factory) {
	
	Session session= factory.openSession();
	String q1= "Select count(*) from User";
	Query<?> query1= session.createQuery(q1);
	Long userCount= (Long)query1.list().get(0);
	Map<String, Long> map= new HashMap<>();
	map.put("userCount", userCount);
	session.close();
	return map;
	
}


}
