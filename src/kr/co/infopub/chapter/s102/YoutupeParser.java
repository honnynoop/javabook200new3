package kr.co.infopub.chapter.s102;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import java.net.MalformedURLException;

import java.net.URL;

import java.net.URLDecoder;

import java.net.URLEncoder;

import java.util.ArrayList;

public class YoutupeParser{
	
	public static void main(String[] args) {
		YoutupeParser parser=new YoutupeParser();
		ArrayList<Youtube> youlist=parser.getTitles("sia");
		for(Youtube you:youlist){
			System.out.println(you);
		}
	}
	ArrayList<String> htmls = new ArrayList<>();
	
	public  ArrayList<String> search(String s)
	{
		String urls = "https://www.youtube.com/results?search_query=";
		htmls.clear();
		BufferedReader br = null;
		try 
		{
			String ss = URLEncoder.encode(s, "utf-8");
			System.out.println(ss);
			URL url = new URL(urls + ss);
			br = new BufferedReader(new InputStreamReader(url.openStream(), "utf-8"));
			String msg = "";
			while ((msg = br.readLine()) != null){// EOF
				if (msg.trim().contains("class=\"yt-uix-tile-link yt-ui-ellipsis yt-ui-ellipsis-2 yt-uix-sessionlink")) {
					htmls.add(msg.trim());
				}
			}
		} 
		catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return htmls;
	}
	//2017.4.12 /watch?v=PCaKey131NQ&dafdsfasd에서 & 제거
	public String toUrl(String msg){
		String tt="";
		if(msg.indexOf("&")==-1){//없다면
			tt=msg;
		}else{
			tt=msg.substring(0, msg.indexOf("&"));
		}
		return tt;
	}
	public String toUrl2(String msg){
		String tt="";
		if(msg.indexOf("=")==-1){//없다면
			tt=msg;
		}else{
			tt=msg.substring(msg.indexOf("=")+1);
		}
		return tt;
	}
	public String toUrl3(String msg){
		String tt="";
		if(msg.indexOf(";")==-1){//없다면
			tt=msg;
		}else{
			tt=msg.substring(0,msg.indexOf(";"));
		}
		return tt;
	}
	// 제목
	public ArrayList<Youtube> getTitles(String key) {
		
		ArrayList<Youtube> af = new ArrayList<Youtube>();
		int i = 0;
		ArrayList<String> asd = search(key);

		for(int j=0; j<asd.size(); j++){
			try{
				String[] fu = asd.get(i).split("\"");
				String url = URLDecoder.decode(fu[5], "EUC-KR");
				System.out.println("---------------------->"+url);
				String title = URLDecoder.decode(fu[11], "EUC-KR");
				//String ing =img.get(i);
				Youtube f = new Youtube(title,toUrl3(toUrl2(url)),"");
				//Youtube f = new Youtube(title,url,"");
				//private String title;
				//private String url;
				//private String img;
				af.add(f);
			} 
			catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			i++;
		}
		return af;

	}

}
