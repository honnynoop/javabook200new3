package kr.co.infopub.chapter.s088;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Date;
// 파일
public class BillFiles {
	public static void main(String[] args) {
		File f=new File("billboard");    // billboard 디렉토리
		File[] fd=f.listFiles();         // 바로 아래 파일들(자식파일)
		for (File ff : fd) {
			String fname=ff.getName();   // 파일명
			String post=fname.substring(fname.lastIndexOf(".")+1); 
			System.out.println(fname+"  "+post);  // 이름, 확장자
			System.out.println(ff.getAbsolutePath());  // 전체경로
			System.out.println(new Date(ff.lastModified()));  //수정일
			try(BufferedReader br=new BufferedReader(
				      new FileReader(ff.getAbsolutePath()))) {
				String msg="";
				while((msg=br.readLine())!=null){
				    System.out.println(msg);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			System.out.println("--------------------------------------");
		}
	}
}