package kr.co.infopub.chapter.s091;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
public class BillboardTimeMain {
 public static void main(String[] args) {
	 String newUrls="https://www.billboard.com/charts/hot-100/";
	 Document doc=null;
	 String ss="";
     try {
    	 doc = Jsoup.connect(newUrls).get(); //GET
    	 //<button class='chart-detail-header__date-selector-button' 포함
    	 //첫번째 엘리먼트
    	 Element bDay = doc
    			 .select("button.chart-detail-header__date-selector-button")
    			 .first();
    	 ss=bDay.text();      // November 3, 2018
    	 ss=ss!=null?RestDay.saturday(ss): RestDay.saturday();
     } catch (Exception e) {
		System.out.println(e);
	 }
    System.out.println("이번 빌보드 차트 날짜 : "+ss.trim());
 }
}
