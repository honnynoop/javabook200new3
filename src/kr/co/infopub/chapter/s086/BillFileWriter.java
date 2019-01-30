package kr.co.infopub.chapter.s086;
import java.io.File;
//���� ����
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
public class BillFileWriter {
 public static void main(String[] args) {
	Billbaord b1 =new Billbaord(1,"Despacito",1,
			"https://www.billboard.com/images/pref_images/q61808osztw.jpg","luis fonsi");
	Billbaord b2 =new Billbaord(2,"That's What I Like",2,
			"https://www.billboard.com/images/pref_images/q59725qvpol.jpg","bruno mars");
	Billbaord b3 =new Billbaord(3,"I'm The One",3,
			"https://www.billboard.com/images/pref_images/q64532pl64x.jpg","dj khaled");
	ArrayList<Billbaord> bblist=new ArrayList<Billbaord>();
	bblist.add(b1);
	bblist.add(b2);
	bblist.add(b3);
	File f=new File("billboard");
	if(!f.exists()){ f.mkdirs(); }
	try (PrintWriter pw=new PrintWriter(new FileWriter("billboard\\bill.csv",false),true)){
		for(Billbaord bb : bblist){
			pw.println(bb);
		}
	} catch (IOException e) {
		System.out.println(e);
	}
 }
}