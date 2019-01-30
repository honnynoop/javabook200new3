package kr.co.infopub.chapter.num;
import java.io.File;
public class FileNumberMaining2 {
	public static void main(String[] args) {
			String s="s0"+96;
			File ff=new File("D:/javaeej3/workspace/billboardjsoup/src/kr/co/infopub/chapter/"+s);
			File[] ffs=ff.listFiles();
			for (File fff: ffs) {
				FileCommentsNumber fc=new FileCommentsNumber(fff.getAbsolutePath());
				fc.fileRWInAnyType();
			}
	}
}
