package com.bruse.webmagic.action;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.HashSet;
import java.util.List;

public class YoukuSpider implements PageProcessor{
    //专区网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site=Site.me().setRetryTimes(10).setSleepTime(1000);

	public Site getSite() {
		return this.site;
	}
	//process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
	public void process(Page page) {
		if(page.getUrl().regex("http://list\\.youku\\.com/category/show/").match()){
			List<String> list = page.getHtml().xpath("//ul[@class=\"panel\"]/li/div/div/a").links().all();
			//去重方法，先将list转为hashset 可以去除重复连接
			HashSet<String> hashSet = new HashSet<String>(list);
			//先将list里面元素移除
			list.clear();
			//再将去除重复后的元素补充回list
			list.addAll(hashSet);
			//将抽取到的链接又放入待抓取url队列中
			page.addTargetRequests(list);
//			System.out.println(page.getHtml());
		}else{
			List<String> name = page.getHtml().xpath("//div[@class=\"tvinfo\"]/h3/text()").all();
			List<String> hrefs = page.getHtml().xpath("//div/div[@name=\"tvlist\"]/a").links().all();
			List<String> titles = page.getHtml().xpath("//div/div[@name=\"tvlist\"]/@title").all();
			System.out.println(name.get(0));
			for (int i = 0; i < hrefs.size(); i++) {
				System.out.print(titles.get(i));
				System.out.println(hrefs.get(i));
			}
		}
	}

	public static void main(String[] args) {
		Spider.create(new YoukuSpider())
		//url入口
		.addUrl("http://list.youku.com/category/show/c_97_a_%E5%A4%A7%E9%99%86_s_1_d_1.html?spm=a2htv.20009910.m_86809.5~5~5~1~3~A")
		.thread(5)//开启5个线程
		.run();//启动爬虫
	}
}
