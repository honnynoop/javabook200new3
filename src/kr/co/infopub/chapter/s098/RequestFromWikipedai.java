package kr.co.infopub.chapter.s098;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
public class RequestFromWikipedai {
	ArrayList<String> htmls=new ArrayList<String>();
	ArrayList<SovereignFlag> flags=new ArrayList<SovereignFlag>();
	public ArrayList<SovereignFlag> getFlags() {
		return flags;
	}
	public RequestFromWikipedai() {
		htmls.clear();
		flags.clear();
	}
	boolean isConnection=false;
	public void getAllHtml(String newUrls){
		htmls.clear();
		InputStream inputStream;
		URL url=null;
		try {
			url= new URL(newUrls);
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			inputStream = new BufferedInputStream(urlConnection.getInputStream());
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"), 8);
			String line = null;
			while ((line = reader.readLine()) != null)
			{
				if(!line.trim().equals("")){

					htmls.add(line.trim());
				}
			}
			inputStream.close();
			isConnection=true;

		} catch (Exception e) {
			isConnection = false;
			System.out.println(e);
		} 
	}
	public String __toStr(String msg){
		return msg.replaceAll("_", " ");
	}
	public String emptyto_(String msg){
		return msg.replaceAll(" ", "_");
	}
	public String replaceper(String msg){
		String ss=msg;
		return ss.trim();
	}

	public synchronized void getSevereign(String msg){
		int count=0;
		flags.clear();
		for (int i=0; i<htmls.size(); i++) {
			String ss=htmls.get(i);
			if(ss.contains(msg)){     
				if(ss.contains(".svg.png")){
					String korname=ss.substring(0,ss.lastIndexOf("</a></td>"));//
					korname=korname.substring(korname.lastIndexOf(">")+1);//
					String flag=ss.substring(0,ss.lastIndexOf(".svg.png")+".svg.png".length());//
					flag="https:"+flag.substring(flag.lastIndexOf("//upload.wikimedia.org/wikipedia"));//
					String name=flag.substring(flag.lastIndexOf("/")+1);
					name=name.substring(0,name.lastIndexOf(".svg.png"));//
					if(name.contains("Flag_of_the_")){
						name=name.substring(name.lastIndexOf("Flag_of_the_")+"Flag_of_the_".length());//
					}else if(name.contains("Flag_of_The_")){
						name=name.substring(name.lastIndexOf("Flag_of_The_")+"Flag_of_The_".length());//
					}else if(name.contains("Flag_of_")){
						name=name.substring(name.lastIndexOf("Flag_of_")+"Flag_of_".length());//
					}
					String code=htmls.get(i+1);
					code=code.substring(0,code.lastIndexOf("<"));
					code=code.substring(code.indexOf(">")+1);
					String shortname=htmls.get(i+3);  //2자=>3자 09.27수정  alpha-2
					shortname=shortname.substring(0,shortname.lastIndexOf("<"));
					shortname=shortname.substring(shortname.indexOf(">")+1);
					SovereignFlag sflag=new SovereignFlag(__toStr(name),shortname,code,flag,korname);
					flags.add(sflag);
				}
			}
		}
	}
	public void printHtml(){
		for (String dto : htmls) {
			System.out.println(dto);
		}
	}
	public void printFlags(){
		int count=1;
		for (SovereignFlag dto : flags) {
			System.out.println((count++)+"\t"+dto);
		}
	}
	public static void main(String[] args) {
		RequestFromWikipedai rfw=new RequestFromWikipedai();
		String a="https://ko.wikipedia.org/wiki/ISO_3166-1";
		String msg="srcset=\"//upload.wikimedia.org/wikipedia";
		rfw.getAllHtml(a);   
		//rfw.printHtml();
		rfw.getSevereign(msg);
		rfw.printFlags();
	}
}