package kr.co.infopub.chapter.s082;
// 기본타입과 문자열
public class BillboardMain1 {
	public static void main(String[] args) {
		//변수-Data를 저장하는 임서저장공간 
		int rank=1;                 //정수를 저장
		String song="Despacito";    //문자열을 저장
		//Data를 그릇에 담는다.
		int lastweek=1;             
		String imagesrc="https://www.billboard.com/images/pref_images/q61808osztw.jpg";
		String artist="luis fonsi";
		String sf=String.format("%d, %s, %d, %s, %s",rank, song,lastweek,imagesrc,artist);
		System.out.println(sf);
	}
}
