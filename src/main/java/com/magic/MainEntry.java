package com.magic;

import com.magic.processor.Magic163Processor;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;

public class MainEntry {

	public static void main(String[] args) {
		Spider.create(new Magic163Processor())
		.addPipeline(new ConsolePipeline())
		.addUrl("http://caipiao.163.com/award/kuai3/?gameEn=kuai3&date=20130515")
		.thread(1)
		.run();
	}

}
