package com.bruse.regex;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class TestJsoup {
	
	public static void test01(){
		String html = "<html><head><title>Parse</title></head><body>"
				+ "<p>parse a document</p>"
				+ "<p>1111</p>"
				+ "<p>2222</p>"
				+ "<p>3333</p>"
				+ "<div class='cl'>aaaa</div>"
				+ "<div class='cl'>bbbb</div>"
				+ "<div id='tid'><div>testtest</div></div>"
				+ "</body></html>";
		Document doc = Jsoup.parse(html);
		Element tid = doc.getElementById("tid");
		System.out.println(tid.html());
		Elements tagp = doc.getElementsByTag("p");
		System.out.println(tagp);
		Element element = tagp.get(1);
		System.out.println(element);
		Elements select = doc.select("div[class='cl']");
		System.out.println(select);
		Elements select2 = doc.select("p");
		System.out.println("---"+select2);
		Elements select3 = doc.select("#tid");
		System.out.println(select3);
	}
	
	public static void test02(){
		try {
			Document doc = Jsoup.connect("http://www.gzsxt.cn")
//					.data("query", "Java")
					.userAgent("Mozilla")
					.referrer("http://www.gzsxt.cn")
//					.cookie("auth", "token")
					.timeout(3000)
					.post();
			System.out.println(doc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
//		test01();
		test02();
	}
	
}
