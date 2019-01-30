package kr.co.infopub.chapter.s096;
import org.jdom2.input.SAXBuilder;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
// jdom
public class BillboardMain9 {
	public static void main(String[] args) {
		 //2018-01-15 세줄 추가 /이번주 빌보드
		RequestFromBillboardHot rfw=new RequestFromBillboardHot();
		String a="https://www.billboard.com/charts/hot-100/";
		String rs=rfw.getTimeDate(a);
		
		SAXBuilder builder = new SAXBuilder();
        Document document = null;
    	try {
    		document= builder.build("billboard\\"+rs+".xml");
    		 Element root = document.getRootElement();
    		 List<Element> billboards = root.getChildren("billboard");
    		 for (Element ele: billboards) {
    			String rank=ele.getChildText("rank");
    			String song=ele.getChildText("song");
    			String lastweek=ele.getChildText("lastweek");
    			String imagesrc=ele.getChildText("imagesrc");
    			String artist=ele.getChildText("artist");
    			String sf=String.format("%s, %s, %s, %s, %s",
    					rank, song,lastweek,imagesrc,artist);
    			System.out.println(sf);
			 }
    	}catch (Exception e) {
			System.out.println( e);
		}
	}
}