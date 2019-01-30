package kr.co.infopub.chapter.s089;
import java.io.BufferedReader;
import java.io.FileReader;
public class BillboardMain3 {
 public static void main(String[] args) {
	 String newUrls="https://www.billboard.com/charts/hot-100/";
	 BillboardDriver billdriver=new BillboardDriver();
	 String fnames=billdriver.saveBillboard100(newUrls);
     //today billboard/2018-09-14.txt 읽기
     try {
 		BufferedReader reader = new BufferedReader(  
 				              new FileReader(fnames));
 		String line = null;
 		while ((line = reader.readLine()) != null){  // 한줄씩 읽어서 
 			if(!line.trim().equals("")){             // 공백이 아니면 출력한다.
 				System.out.println(line.trim());
 			}
 		}
 	} catch (Exception e) {
 		System.out.println("Billboard Parsing error !!! ");
 	} 
 }
}
