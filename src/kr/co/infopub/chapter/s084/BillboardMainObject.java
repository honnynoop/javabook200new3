package kr.co.infopub.chapter.s084;
public class BillboardMainObject {
   public static void main(String[] args) {
	Billbaord b1 =new Billbaord(1,"Despacito",1,
			"https://www.billboard.com/images/pref_images/q61808osztw.jpg","luis fonsi");
	Billbaord b2 =new Billbaord(2,"That's What I Like",2,
			"https://www.billboard.com/images/pref_images/q59725qvpol.jpg","bruno mars");
	Billbaord b3 =new Billbaord(3,"I'm The One",3,
			"https://www.billboard.com/images/pref_images/q64532pl64x.jpg","dj khaled");
	showAbout(b1);         // 1개 객체
	showAbout(b2);         // 1개 객체
	showAbout(b1,b2);      // 2개 객체
	showAbout(b1,b2,b3);   // 3개 객체
	Billbaord[] b=new Billbaord[3];
	b[0]=new Billbaord(1,"Despacito",1,
			"https://www.billboard.com/images/pref_images/q61808osztw.jpg","luis fonsi");
	b[1]=b2;  //생성해도 좋고 , 생성된 객체를 받아도 된다.
	b[2]=b3;
	showAbout(b[0],b[1]);   // 2개 객체
	showAbout(b);           // 배열->3개 객체
 }
 public static void showAbout(Billbaord bb ){//객체를 전달하여 출력
	System.out.println("1----------------------");
	String sf=String.format("%d, %s, %d, %s, %s",
			bb.getRank(), bb.getSong(),bb.getLastweek(),bb.getImagesrc(),bb.getArtist());
	System.out.println(sf);
 }
 public static void showAbout(Billbaord ... b ){//객체를 전달하여 출력
	System.out.println("2======================>");
	for(Billbaord bill : b){
		showAbout(bill);  // 1
	}
	System.out.println("<======================2");
 }
}
