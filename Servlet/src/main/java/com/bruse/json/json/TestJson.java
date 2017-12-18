package com.bruse.json.json;

import com.bruse.json.org.json.JSONArray;
import com.bruse.json.org.json.JSONObject;
import com.bruse.json.vo.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TestJson {

	public static void main(String[] args) {
		//字符串转json
		String str = "{name:'laoxia',age:18}";
		JSONObject json1 = new JSONObject(str);
		System.out.println(json1.get("name"));
		json1.put("email", "1234567@qq.com");
		System.out.println(json1);
		//对象转json
		User u = new User();
		u.setName("laolian");
		u.setAge(30);
		Map<String,String> map = new HashMap<String,String>();
		map.put("first", "bj");
		map.put("second", "sh");
		u.setCity(map);
		List<String> list = new ArrayList<String>();
		list.add("1111");
		list.add("2222");
		u.setF(list);
		JSONObject json2 = new JSONObject(u);
		System.out.println(json2);
		//json取map值
		JSONObject jsonObject = json2.getJSONObject("city");
		String first = jsonObject.getString("first");
		System.out.println(first);
		//json取list值 
		JSONArray jsonArray = json2.getJSONArray("f");
		for (int i = 0; i < jsonArray.length(); i++) {
			System.out.println(jsonArray.get(i));
		}
	}
}
