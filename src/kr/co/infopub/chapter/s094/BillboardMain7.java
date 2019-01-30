package kr.co.infopub.chapter.s094;
import java.io.FileReader;
import java.io.BufferedReader;
// csv
public class BillboardMain7 {
//rank=1 -> 1
 public static String cut(String msg){
	String val=msg.substring(msg.indexOf("=")+1);
	return val;
 }
/*	
   String[] msgs={"rank=1", 
	"song=Despacito", 
	"lastweek=1", 
	"imagesrc=http://www.billboard.com/images/pref_images/q61808osztw.jpg", 
	"artist=luis fonsi"}
*/
 public static void show(String msg){
	System.out.println("-------------------------------------");
	String[] msgs=msg.split(", ");
	String rank=cut(msgs[0]).trim();
	String song=cut(msgs[1]).trim();
	String lastweek=cut(msgs[2]).trim();
	String imagesrc=cut(msgs[3]).trim();
	String artist=cut(msgs[4]).trim();
	String sf=String.format("%s, %s, %s, %s, %s",rank, song,lastweek,imagesrc,artist);
	System.out.println(sf);
 }
 
 public static void main(String[] args) {
	RequestFromBillboardHot rfw=new RequestFromBillboardHot();
	String a="https://www.billboard.com/charts/hot-100/";
	String rs=rfw.getTimeDate(a);
	BufferedReader br=null;
	try {
		br=new BufferedReader(new FileReader("billboard\\"+rs+".csv"));
		String msg="";
		while((msg=br.readLine())!=null){
		    show(msg);
		}
	} catch (Exception e) {
		System.out.println(e);
	}
 }
}
