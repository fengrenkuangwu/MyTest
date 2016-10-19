package com.leaf.IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Map;
import java.util.Properties;

import org.junit.Test;

public class UsedThings {


	/**
	 * 把gbk的文本文档复制为utf8的文本文档
	 * @throws IOException
	 */
	@Test
	public void TestChCopy() throws IOException{
		File src = new File("c:/poem_gbk.txt");
		File des = new File("c:/poem_UTF-8.txt");

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream(src), "GBK"));
		FileOutputStream fos = new FileOutputStream(des);
		FileChannel channelOut = fos.getChannel();

		ByteBuffer buf;
		String line;

		while ((line = reader.readLine()) != null) {
			buf = ByteBuffer.wrap(line.getBytes("UTF-8"));
			channelOut.write(buf);
			channelOut.write(ByteBuffer.wrap(new byte[] { '\r', '\n' }));
		}

		channelOut.close();
		fos.flush();
		fos.close();
		reader.close();
	}
	
}
