package com.zy.ioc.pojo;

import java.util.List;
import java.util.Map;

import org.zy.fluorite.core.annotation.Component;
import org.zy.fluorite.core.annotation.ConfigurationProperties;
import org.zy.fluorite.core.annotation.NestedConfigurationProperty;

@Component
@ConfigurationProperties(prefix = "account", ignoreInvalidFields = false)
public class Account {
	private List<Integer> list;
	private Map<String,String> map;
	private Map<String, List<String>> mapOfList;
	
	@NestedConfigurationProperty
	private Admin admin;
	
	public List<Integer> getList() {
		return list;
	}
	public void setList(List<Integer> list) {
		this.list = list;
	}
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	public Map<String, List<String>> getMapOfList() {
		return mapOfList;
	}
	public void setMapOfList(Map<String, List<String>> mapOfList) {
		this.mapOfList = mapOfList;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	@Override
	public String toString() {
		return "Account [list=" + list + ", map=" + map
				+ ", mapOfList=" + mapOfList + ", admin=" + admin + "]";
	}
}
