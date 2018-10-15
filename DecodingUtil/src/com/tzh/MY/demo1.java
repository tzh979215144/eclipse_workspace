package com.tzh.MY;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.BufferedInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
public class demo1 {
	
	private File Srcpath;
	private File Destpath ;
	public void start() throws IOException {
		getPath(Srcpath,Destpath);
	}
	public demo1(String srcPath,String destPath) {
		// TODO Auto-generated constructor stub
		this.Srcpath=new File(srcPath);
		this.Destpath=new File(destPath);
	}
	/**
	 * 文件读取+遍历
	 * @param path
	 * @param dest
	 * @throws IOException
	 */
	public void getPath(File src,File dest) throws IOException {
	//读取文件
		File[] sub;
		File nowDir= dest ;
		String dirName=null;
		if(!src.isDirectory()&&src!=null) {
			dest=new File(dest.getAbsolutePath()+"/"+src.getName());
			changeDecoding(src, dest);
		}
		else {
			//如果是文件夹，在目标目录下创建此文件夹，保持与被复制文件夹目录一致性
			dirName =nowDir.getAbsolutePath()+"/"+src.getName();
			System.out.println(dirName);
			nowDir = new File(dirName);
			//确保一致性,当前所在目标文件夹
			nowDir.mkdirs();
			//System.out.println(dirName);
			
			//遍历文件夹下的内容
			sub = src.listFiles();
			for(File temp:sub) {
				getPath(temp, nowDir);
			}
		}
	}
		/**
		 * 文件复制
		 * 转换编码
		 * @param src
		 * @param dest
		 * @throws IOException
		 */
		public void changeDecoding(File src,File realdest)  {
			System.out.println(realdest.getName());
			//用字节流读取-->转换为字符流,设置编码码编码符
			BufferedReader bis=null;
			BufferedWriter bos=null ;
			try {
				//不设置，默认使用平台解码，此处是UTF-8，我的目标文件是GBK的
				bis = new BufferedReader( new InputStreamReader(new BufferedInputStream(new FileInputStream(src)),"GBK"));
				bos = new BufferedWriter(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(realdest)),"utf-8"));
			} catch (UnsupportedEncodingException | FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String temp=null;
			try {
				temp = bis.readLine();
				while(null!=temp) {
					bos.write(temp);
					//System.out.println(temp);
					bos.newLine();
					bos.flush();
					temp = bis.readLine();
				}
				bos.close();
				bis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
}
