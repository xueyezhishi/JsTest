package com.zucc.tool.export.txt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

public class ReadWriteTxt_origin {
	public static BufferedReader bufRead = null;
	// 指定文件路径和名称
	private static String path = "D:/aaa.txt";
	private static File filename = new File(path);
	private static String readStr = "";

	/**
	 * 创建文本文件.
	 * 
	 * @throws IOException
	 */
	public static void creatTxtFile(String fPath) throws IOException {
		if (fPath == null || "".equals(fPath.trim())) {
			System.err.println("参数传递出错,未知的文件路径!");
			return;
		}
		File file = new File(fPath);
		if (!file.exists()) {
			file.createNewFile();
			System.err.println(filename + "已创建！");
		}
	}

	/**
	 * 读取文本文件.
	 * 
	 */
	public static String readTxtFile(String fPath) {
		String read = null;
		FileReader fileRead = null;
		try {
			File file = new File(fPath);
			fileRead = new FileReader(file);
			bufRead = new BufferedReader(fileRead);
			try {
				while ((read = bufRead.readLine()) != null) {
					readStr = readStr + read + "\r\n";
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("文件内容是:" + "\r\n" + readStr);
		return readStr;
	}

	/**
	 * 写文件.
	 * 
	 */
	public static void writeTxtFile(String fPath, String newStr)
			throws IOException {
		// 先读取原有文件内容，然后进行写入操作
		String fileIn = newStr + "\r\n" + readStr + "\r\n";
		RandomAccessFile mm = null;
		try {
			File file = new File(fPath);
			mm = new RandomAccessFile(file, "rw");
			mm.writeBytes(fileIn);
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			if (mm != null) {
				try {
					mm.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		}
	}

	/**
	 * 将文件中指定内容的第一行替换为其它内容.
	 * 
	 * @param oldStr
	 *            查找内容
	 * @param replaceStr
	 *            替换内容
	 */
	public static void replaceTxtByStr(String oldStr, String replaceStr) {
		String temp = "";
		try {
			File file = new File(path);
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			StringBuffer buf = new StringBuffer();

			// 保存该行前面的内容
			for (int j = 1; (temp = br.readLine()) != null
					&& !temp.equals(oldStr); j++) {
				buf = buf.append(temp);
				buf = buf.append(System.getProperty("line.separator"));
			}

			// 将内容插入
			buf = buf.append(replaceStr);

			// 保存该行后面的内容
			while ((temp = br.readLine()) != null) {
				buf = buf.append(System.getProperty("line.separator"));
				buf = buf.append(temp);
			}

			br.close();
			FileOutputStream fos = new FileOutputStream(file);
			PrintWriter pw = new PrintWriter(fos);
			pw.write(buf.toString().toCharArray());
			pw.flush();
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * main方法测试
	 * 
	 * @param s
	 * @throws IOException
	 */
	public static void main(String[] s) throws IOException {
/*		creatTxtFile(path);
		// readTxtFile();
		writeTxtFile(path,"20080808:12:13");*/
		File file = new File(path);
		file.delete();
		// ReadWriteFile.replaceTxtByStr("eeeeeee", "rrrrrttte");
	}
}
