package com.leaf.Spider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

public class SpiderTest {

	@Test
	public void getResderFromURL() throws Exception {
		URL url = new URL("http://www.zhihu.com/question/31427895");
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null)
			System.out.println(inputLine);
		in.close();
	}
	
	@Test
	public void getContext() throws IOException{
		String url ="http://www.zhihu.com/question/31427895";
		Connection conn = Jsoup.connect(url);
		Document doc = conn.timeout(100000).get();
		Elements results = doc.getElementsByTag("body");
		for (Element result : results)
		{
			Elements links = result.getElementsByTag("div");
			for(Element link :links){
				System.out.println(link.text());
			}
		}
	}
	
	
	
}
