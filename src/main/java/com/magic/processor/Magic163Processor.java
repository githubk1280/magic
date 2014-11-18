package com.magic.processor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

public class Magic163Processor implements PageProcessor {

	private Site site = Site
			.me()
			.setRetryTimes(5)
			.setSleepTime(5000)
			.setCharset("utf-8")
			.setUserAgent(
					"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2062.94 Safari/537.36");
	
	public void process(Page page) {
		System.out.println(getValue(page.getHtml(), "/html/body/article/section/div[1]/table/tbody/tr[2]/td[2]"));
	}

	public Site getSite() {
		return site;
	}
	
	private String getValue(Html html, String xpath) {
		try {
			Selectable selector = html.xpath(xpath);
			if (selector != null) {
				return selector.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

}
