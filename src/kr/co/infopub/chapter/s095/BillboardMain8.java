package kr.co.infopub.chapter.s095;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileReader;
import java.io.BufferedReader;
// json
public class BillboardMain8 {
	public static void main(String[] args) {
		 //2018-01-15 세줄 추가 /이번주 빌보드
		RequestFromBillboardHot rfw=new RequestFromBillboardHot();
		String a="https://www.billboard.com/charts/hot-100/";
		String rs=rfw.getTimeDate(a);
		BufferedReader br=null;
		try {
			br=new BufferedReader(new FileReader("billboard\\"+rs+".json"));
			StringBuffer sb=new StringBuffer();
			String msg="";
			while((msg=br.readLine())!=null){
				sb.append(msg);
			}
			JSONObject billboards=new JSONObject(sb.toString());
			JSONArray bills=billboards.getJSONArray("billboard");
			for(int i=0; i< bills.length() ;i++){
				System.out.println("------------------------------------");
				JSONObject bill=bills.getJSONObject(i);
				String rank=bill.getString("rank");
    			String song=bill.getString("song");
    			String lastweek=bill.getString("lastweek");
    			String imagesrc=bill.getString("imagesrc");
    			String artist=bill.getString("artist");
    			String sf=String.format("%s, %s, %s, %s, %s",
    					                rank, song,lastweek,imagesrc,artist);
    			System.out.println(sf);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
	  
