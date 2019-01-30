package kr.co.infopub.chapter.s087;
//파일 리더
import java.io.BufferedReader;
import java.io.FileReader;
public class BillFileReader {
	public static void main(String[] args) {
		try(BufferedReader br=new BufferedReader(
				      new FileReader("billboard\\bill.csv"))) {
			String msg="";
			while((msg=br.readLine())!=null){
			    System.out.println(msg);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}