package com.magic;

import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;

import com.magic.processor.Magic163Processor;
import com.magic.utils.DateCountDownUtils;

public class MainEntry {
	static String url="http://caipiao.163.com/award/kuai3/?gameEn=kuai3&date=";

	public static void main(String[] args) throws InterruptedException {
		Calendar start = DateCountDownUtils.getStartDate();
		String dateStr ="";
		for (int i = 1; i < 200; i++) {
			int sleep = new Random().nextInt(10);
			System.out.println("sleep..."+sleep);
			TimeUnit.SECONDS.sleep(sleep);
			dateStr = DateCountDownUtils.countDown(start.get(Calendar.YEAR),
					start.get(Calendar.MONTH), start.get(Calendar.DAY_OF_MONTH),
					i);
			if(StringUtils.isNotEmpty(dateStr)){
				Spider.create(new Magic163Processor())
				.addPipeline(new ConsolePipeline())
				.addUrl("http://caipiao.163.com/award/kuai3/?gameEn=kuai3&date="+dateStr)
				.thread(1)
				.run();
			}
		}
	}

}
