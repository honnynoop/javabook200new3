package kr.co.infopub.chapter.s092;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
public class RequestFromBillboardHot {
 ArrayList<String> htmls=new ArrayList<String>();
 boolean isConnection=false;
 public RequestFromBillboardHot() {
	htmls.clear();
 }
 public void getAllHtml(String newUrls){   //s89에서 설명
	htmls.clear();
	try {
		// 주소지에 빨대 꽂기
		BufferedReader reader = new BufferedReader(  
	              new FileReader(newUrls));
		String line = "";
		while ((line = reader.readLine()) != null){
			if(!line.trim().equals("")){
				htmls.add(line.trim());
			}
		}
		isConnection=true;    // 읽기 성공
	} catch (Exception e) {
		isConnection = false; // 읽기 실패
		System.out.println("Billboard Parsing error !!! ");
	} 
 }
 public void printHtml(){
	for (String ss : htmls) {
		System.out.println(ss);
	}
 }
 //<button class="chart-detail-header__date-selector-button"> 
 //September 15, 2018 
 //<span class="chart-detail-header__date-selector-caret fa fa-caret-down">
 //</span> </button>
 //에서 September 15, 2018을 얻고 2018-09-15로 변환
 public String getTimeDate(String aurl) {  //s091에서 설명
	Document doc;
	String sdate=null;
    try {
        doc = Jsoup.connect(aurl).get();
        Element first = doc
          .select("button.chart-detail-header__date-selector-button")
          .first();
        sdate=first.text(); // September 15, 2018
    } catch (IOException e) {
        System.out.println(e);
    }
	return sdate!=null?
			RestDay.saturday(sdate): RestDay.saturday();
 }
 public static void main(String[] args) {
	RequestFromBillboardHot rfw=new RequestFromBillboardHot();
	String a="https://www.billboard.com/charts/hot-100/";
	String rs=rfw.getTimeDate(a);
	System.out.println("이번 주 "+rs);
	//rs=RestDay.toWantedDay(rs, 1);  //1주전
	String fnames="billboard/"+rs+".html";
	//-----여기서 
	File f=new File(fnames);
	BillboardDriver billdriver=null;
	if(!f.exists()){   //파일이 존재하지 않으면
		billdriver=new BillboardDriver();
		fnames=billdriver.saveBillboard100(rs,a);
	}
	//-----여기까지 추가
	System.out.println(fnames);
	rfw.getAllHtml(fnames);
	rfw.printHtml();
 }
}