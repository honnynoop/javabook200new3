package kr.co.infopub.chapter.s094;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

//2018-09-05 modified 3rd
public class RequestFromBillboardHot {
	boolean isConnection=false;
	
	ArrayList<Billbaord> billboards=new ArrayList<Billbaord>();

	public ArrayList<Billbaord> getBillboards() {
		return billboards;
	}
	public RequestFromBillboardHot(){
		billboards.clear();
	}
	
	public synchronized void getBillboardData(String newUrls){
		 billboards.clear();
		 Document doc=null;
		 String fnames="billboard/";
		 String ss="";
		 
	     try {
	    	 doc = Jsoup.connect(newUrls).get(); //GET
	    	 String firstsong="";
	    	 String firstartist="";
	    	 //첫번째 엘리먼트 
	    	 //<div class='chart-number-one__title'>text</div>
	    	 Element firsttitle = doc.select("div.chart-number-one__title").first();
	    	 firstsong=firsttitle.text();
	    	 //System.out.println("1--------------"+firstsong);
	    	 //<div class='chart-number-one__artist'>text</div>
	    	 Element efirstartist = doc.select("div.chart-number-one__artist").first();
	    	 firstartist=efirstartist.text();
	    	 //System.out.println("2--------------"+firstartist);
	    	 
	    	 Billbaord board=new Billbaord(
	 				1, replace(firstsong),
	 				0, //1등은 지난 주를 찾기힘듬
	 				"", replace(firstartist), replace(firstartist));
	 		        billboards.add(board);
	 		        
             //div.chart-list-item 모든 엘리먼트
	 		 //<div class='chart-list-item'>  </div> 여러개 
	    	 Elements links = doc.select("div.chart-list-item");
	         for (Element link : links) {
	        	 Element erank=link.selectFirst("div.chart-list-item__rank");
	             String srank=erank.text();
	             //System.out.println("rank---"+srank);
	             //<span class='chart-list-item__title-text'>text</div>
	             Element esong=link.selectFirst("span.chart-list-item__title-text");
	             String song=esong.text();
	             //System.out.println("song---"+song);
	             Element eartist=link.selectFirst("div.chart-list-item__artist");
	             String artist=eartist.text();
	             //System.out.println("artist---"+artist);
	             String lastweek="101";
	             try{
	            	 Element estate=link.selectFirst("div.chart-list-item__last-week");
	            	 if(estate!=null){  // 지난주 랭킹이 있다. 
	            		 lastweek=__toStr(estate.text());
	            		 //System.out.println("--------->>>"+lastweek);
	            	 }else{
	            		 //<div class='chart-list-item__last-week'>text</div>
	            		 //이 없을때 101으로 설정(100등 밖)
	            		 //System.out.println("<<<---------"+lastweek);
	            	 }
	             }catch(Exception ee){
	            	 System.out.println(ee);
	             }
	             
	             Billbaord board1=new Billbaord(
	 	 				toInt(srank), replace(song),
	 	 				toInt(lastweek), //1등은 지난 주를 찾기힘듬
	 	 				"", replace(artist), replace(artist));
	 	 		        billboards.add(board1);	 	 		     
	         }

	     } catch (IOException e) {
			System.out.println(e);
		 }
	}
	public String replace(String msg){
		String ss=msg;
		ss=ss.replaceAll("&#039;", "'");
		ss=ss.replaceAll("&amp;", "&");
		ss=ss.replaceAll("&quot;", "\"");
		return ss.trim();
	}

	private String __toStr(String lastweek){
		return lastweek.contains("-")?101+"":lastweek;
	}
	private int toInt(String msg){
		return Integer.parseInt(msg==null ?"-1":msg.trim());
	}
	public String toArtis(String msg){
		return msg.replaceAll("-", " ");
	}

	public void printBillboard(){
		for (Billbaord dto : billboards) {
			System.out.println(dto);
		}
	}
    //<button class='chart-detail-header__date-selector-button'>
	//===> button.chart-detail-header__date-selector-button
	public String getTimeDate(String aurl) {
		Document doc;
		String sdate=null;
	    try {
	        doc = Jsoup.connect(aurl).get();
	        Element first = doc.select("button.chart-detail-header__date-selector-button").first();
	        sdate=first.text(); // September 15, 2018
	    } catch (IOException e) {
	        System.out.println(e);
	    }
		return sdate!=null?RestDay.toDay(sdate): RestDay.saturday();
	}
	public static void main(String[] args) {
		RequestFromBillboardHot rfw=new RequestFromBillboardHot();
		String a="https://www.billboard.com/charts/hot-100/";
		String rs=rfw.getTimeDate(a);

		rfw.getBillboardData(a+rs);
        rfw.printBillboard();
	}
}
