package kr.co.infopub.chapter.num;
import java.io.File;

public class FileNumberMaining {

	
	public static void main(String[] args) {
		for(int i=62; i< 64 ;i++){
			String s="s0"+i;
			File ff=new File("D:/java200book/workspace/java200book/src/kr/co/infopub/chapter/"+s);
			File[] ffs=ff.listFiles();
			for (File fff: ffs) {
				FileCommentsNumber fc=new FileCommentsNumber(fff.getAbsolutePath());
				fc.fileRWInAnyType();//Ȯ���ڰ� �ְ� ����,  java, txt�̶� �ȴ�.
				//System.out.println(fff.getAbsolutePath());
			}
		}
		
	}

}
