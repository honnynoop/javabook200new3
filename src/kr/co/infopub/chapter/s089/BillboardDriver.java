package kr.co.infopub.chapter.s089;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class BillboardDriver {
	public String saveBillboard100(String today, String newUrls){
		 Document doc=null;
		 String fnames="billboard/";
		 String ss="";
	     try {
	    	 doc = Jsoup.connect(newUrls+today).get(); //GET으로 요청
	    	 //.post() POST로 요청
	    	 //<button class='chart-detail-header__date-selector-button' 포함
	    	 //첫번째 엘리먼트
	    	 Element bDay = doc
	    		.select("button.chart-detail-header__date-selector-button")
	    		.first();
	    	 ss+=bDay.outerHtml()+"\n";
	    	 System.out.println("1--------------");
	    	 //<div class='chart-number-one__info' 포함
	    	 //첫번째 엘리먼트
	    	 Element first = doc.select("div.chart-number-one__info").first();
	    	 ss+=first.outerHtml()+"\n";
	    	 System.out.println("2--------------");
             //<div class='chart-list-item' 모든 엘리먼트
	    	 Elements links = doc.select("div.chart-list-item");
	         for (Element link : links) {
	        	 ss+=link.outerHtml()+"\n";
	             System.out.println("---------------------------------------");
	         }
		     //billboard/년-월-일.html 에 저장
		     fnames=fnames+today+".html";
			 PrintWriter pw=new PrintWriter(
						    new FileWriter(fnames));
		     pw.print(ss);
		     pw.close();
	     } catch (IOException e) {
			System.out.println(e);
		 }
	     return fnames;  //저장 파일 이름
	}
	//오버로딩 saveBillboard100(today,  newUrls)
	public String saveBillboard100(String newUrls){
	     //billboard/yyyy-MM-dd.txt 저장
	     SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	     String today=sdf.format(new Date());
	     return saveBillboard100(today,newUrls);
	}
}
