package com.andy.main.common;

import java.util.HashMap;
import java.util.Map;

public class JsonData {
private boolean result;
private String message;
private Object data;
public boolean isResult() {
	return result;
}
public void setResult(boolean result) {
	this.result = result;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public Object getData() {
	return data;
}
public void setData(Object data) {
	this.data = data;
}
public JsonData(boolean result) {
	super();
	this.result = result;
}

public static JsonData success() {
	JsonData jsonData = new JsonData(true);
	return jsonData;
}
public static JsonData success(Object data) {
	JsonData jsonData = new JsonData(true);
	jsonData.setData(data);
	return jsonData;
}	
public static JsonData fail(String message) {
	JsonData jsonData = new JsonData(false);
	jsonData.setMessage(message);
	return jsonData;
}	
public Map<String,Object> toMap(){
	Map<String,Object> map = new HashMap<String,Object>();
	map.put("result", result);
	map.put("message", message);
	map.put("data", data);
	
	return map;
}
public JsonData() {
	super();
	// TODO Auto-generated constructor stub
}

}
