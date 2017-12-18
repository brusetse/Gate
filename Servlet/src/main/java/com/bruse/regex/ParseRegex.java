package com.bruse.regex;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ParseRegex {

	public static List<String> regexHtml(String input,String regex){
		List<String> list = new ArrayList<String>(); 
		Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(input);
		while(matcher.find()){
			list.add(matcher.group());
		}
		return list;
		
	}
	public static List<String> findFirstChild(String input,String regex){
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(input);
		List<String> list = new ArrayList<String>();
		if (matcher.find()) {
			for (int i = 0; i <= matcher.groupCount(); i++) {
				list.add(matcher.group(i));
			}
		}
		return list;	
	}
	
	
	public static String spiderHtml(String link){
		String str = null;
		try {
			Document doc = Jsoup.connect(link)
					.data("query", "Java")
					.userAgent("Mozilla")
					.referrer(link)
					.cookie("auth", "token")
					.timeout(3000)
					.post();
			
			str = doc.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}
	
	public static List<String> handleClick(String html){
		List<String> list = new ArrayList<String>();
		Document doc = Jsoup.parse(html);
		Element tab = doc.getElementById("zySeriesTab");
		if(tab!=null){
			Elements lis = tab.select("li[data]");
			for (int i = 0; i < lis.size(); i++) {
				list.add(lis.get(i).attr("data"));
			}
		}
		return list;
	}
	
	public static List<String> handleHaveClick(String html){
		List<String> list = new ArrayList<String>();
		try {
			Document doc = Jsoup.connect(html)
					.userAgent("Mozilla")
					.referrer(html)
					.timeout(3000)
					.post();
			Elements lis = doc.select("li a");
			for (int i = 0; i < lis.size(); i++) {
				list.add(lis.get(i).attr("href"));
				list.add(lis.get(i).attr("title"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static List<String> handleNoClick(String input){
		List<String> list = new ArrayList<String>();
		String regextvname = "(?<=title=\")(.*)\\s\\d{2}(?=\"\\s+charset)";
		List<String> all = findFirstChild(input, regextvname);
		String tvname = all.get(1).toString().trim();
		String regex = "((?<=title=\")"+tvname+
				"\\s\\d{2}(?=\"\\s+charset))|((?<=<a\\s{1,10}href=\")"
				+ ".*(?=\"\\stitle=\""+tvname+"\\s\\d{2}\"))";
		list = regexHtml(input, regex);
		return list;
	}
	
	public static void main(String[] args) {
		
		String urllink = "http://www.youku.com/show_page/"
				+ "id_z9cd2277647d311e5b692.html?spm=a2h0j.8191423.sMain.5~5~A!2";
		String spiderHtml = spiderHtml(urllink);
//		List<String> regexHtml = regexHtml(spiderHtml, "((?<=title=\")微微一笑很倾城\\s\\d{2}(?=\"\\s+charset))|((?<=<a\\s{1,10}href=\").*(?=\"\\stitle=\"微微一笑很倾城\\s\\d{2}\"))");
//		for (int i = 0; i < regexHtml.size(); i++) {
//			System.out.println(regexHtml.get(i));
//		}
		List<String> datas = handleClick(urllink);
		if(datas.size()>0){
			String taburllink = urllink.replace("show_page", "show_episode");
			String clicklink = taburllink.substring(0, taburllink.indexOf("?"));
			for (int i = 0; i < datas.size(); i++) {
				String clickdata = clicklink+"?dt=json&divid="+datas.get(i);
				List<String> list = handleHaveClick(clickdata);
				System.out.println(list);
			}
		}else{
			List<String> list = handleNoClick(spiderHtml);
			System.out.println(list);
		}
		
	}
}
