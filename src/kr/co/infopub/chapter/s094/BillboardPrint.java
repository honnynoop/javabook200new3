package kr.co.infopub.chapter.s094;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
public class BillboardPrint {
/*	public static void printToHTML(List<String> slist, String fname){
		try (PrintWriter pw=new PrintWriter(new FileWriter(fname,false),true)){
				for(String sts : slist){
					pw.println(sts);
				}
		} catch (IOException e) {
		}
	}*/
	public static void printToCSV(List<Billbaord> bblist, String fname) {
		try (PrintWriter pw=new PrintWriter(new FileWriter(fname,false),true)){
			for(Billbaord bb : bblist){
				pw.println(bb);
			}
		} catch (IOException e) {
		}
	}
	/*public static void printToJSON(List<Billbaord> bblist, String fname){
		try (PrintWriter pw=new PrintWriter(new FileWriter(fname,false),true)){
			pw.println("{\"billboard\": [");
			for(int i=0; i<bblist.size()-1 ;i++){
				Billbaord bb=bblist.get(i);
				pw.println(pair(bb)+",");
			}
			pw.println(pair(bblist.get(bblist.size()-1 )));
			pw.println("]}");
		} catch (IOException e) {
		}
	}/*
	public static void printToObject(List<Billbaord> bblist, String fname) {
		try (PrintWriter pw=new PrintWriter(new FileWriter(fname,false),true)){
			for(Billbaord bb : bblist){
					pw.println(String.format("Billbaord b%d =new Billbaord(%d,\"%s\","
							+ "%d,\"%s\",\"%s\");", 
					bb.getRank(), bb.getRank(), bb.getSong(),
					bb.getLastweek(),bb.getImagesrc(),bb.getArtist()));
				}
		} catch (IOException e) {
		}
	}
	public static void printToXML(List<Billbaord> bblist, String fname){
		try (PrintWriter pw=new PrintWriter(new FileWriter(fname,false),true)){
			pw.println("<?xml version='1.0' encoding='utf-8'?>");
			pw.println("<billboards>");
			for(Billbaord bb : bblist){
					pw.println(pairxs(bb));
			}
			pw.println("</billboards>");
		} catch (IOException e) {
		}
	}
	private static String rp(String msg){
		String st=msg;
		st=st.replaceAll("&", "&amp;");
		st=st.replaceAll(">", "&gt;");
		st=st.replaceAll("<", "&lt;");
		st=st.replaceAll("\'", "&apos;");
		st=st.replaceAll("\"", "&quot;");
		return st;
	}
	// <key>value</key>
	private static String pairx(String key, String value){
		String ss=String.format("<%s>%s</%s>", key,value,key);
		return ss;
	}
	private static String pairxs(Billbaord bb){
		String rank=pairx("rank",rp(bb.getRank()+""));
		String song=pairx("song",rp(bb.getSong()+""));
		String lastweek=pairx("lastweek",rp(bb.getLastweek()+""));
		String imagesrc=pairx("imagesrc",rp(bb.getImagesrc()+""));
		String artist=pairx("artist",rp(bb.getArtist()+""));
		return String.format("<billboard>\n%s %s %s %s %s\n</billboard>",
				rank, song,lastweek,imagesrc,artist);
	}
	private static String pair(Billbaord bb){
		String rank=pair("rank",bb.getRank()+"");
		String song=pair("song",bb.getSong()+"");
		String lastweek=pair("lastweek",bb.getLastweek()+"");
		String imagesrc=pair("imagesrc",bb.getImagesrc()+"");
		String artist=pair("artist",bb.getArtist()+"");
		return String.format("{%s,%s,%s,%s,%s}",rank, song,lastweek,imagesrc,artist);
	}
	// "key":"value"
	private static String pair(String key, String value){
		String ss=String.format("\"%s\":\"%s\"", key,value);
		return ss;
	}
	// {"key":"value"}
	private static String pairs(String key, String value){
		String ss=String.format("{\"%s\":\"%s\"}", key,value);
		return ss;
	}*/
}
