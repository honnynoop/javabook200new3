package kr.co.infopub.chapter.s085;
import java.util.ArrayList;
public class BillboardArrayMain {
 public static void main(String[] args) {
	ArrayList<Billbaord> bills=new ArrayList<Billbaord>();
	bills.add(new Billbaord(1,"Despacito",1,
		"https://www.billboard.com/images/pref_images/q61808osztw.jpg","luis fonsi"));
	bills.add(new Billbaord(2,"That's What I Like",2,
		"https://www.billboard.com/images/pref_images/q59725qvpol.jpg","bruno mars"));
	bills.add(new Billbaord(3,"I'm The One",3,
		"https://www.billboard.com/images/pref_images/q64532pl64x.jpg","dj khaled"));
	System.out.println(bills.size());   // 3 
	showAbout(bills.get(0));  // 0번째 Billbaord 객체
	bills.remove(1);          // 1번쩨 삭제             
	System.out.println(bills.size());   // 2
	System.out.println("----------------------");
	for(Billbaord bb : bills){
		showAbout(bb);
	}
 }
 public static void showAbout(Billbaord bb ){//객체를 전달하여 출력
 	String sf=String.format("%d, %s, %d, %s, %s",
			bb.getRank(), bb.getSong(),bb.getLastweek(),bb.getImagesrc(),bb.getArtist());
	System.out.println(sf);
 }
}
