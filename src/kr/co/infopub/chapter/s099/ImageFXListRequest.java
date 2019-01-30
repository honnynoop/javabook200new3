package kr.co.infopub.chapter.s099;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javafx.scene.image.Image;

public class ImageFXListRequest {
 private Map<String, Image> images;
 public ImageFXListRequest() {
	images= Collections
	  .synchronizedMap(new LinkedHashMap<String, Image>(10, 1.53f, true));
 }
 public synchronized Image loadImage(String imagesrc) {
	Image mimage=null;
	if (images.containsKey(imagesrc)) {
		mimage= images.get(imagesrc);
	} else {
		if(imagesrc!=null && !imagesrc.contains("q_____")){
			try{
				mimage= new Image(imagesrc,50,55,true,true);
			}catch (Exception e) {
				mimage=null;;
			}
		}
	}
	return mimage==null ? new Image(getClass()
			              .getResourceAsStream("billboard.jpg")):mimage;
 } 
 public synchronized void getAllImages(ArrayList<SovereignFlag> bills){
	images.clear(); 
	List<SovereignFlag> newbills=Collections.synchronizedList(bills);
	for(SovereignFlag bb: newbills){
		new Thread(() ->{
			if(!images.containsKey(bb.getFlag())){
				images.put(bb.getFlag(),loadImage(bb.getFlag()));
		        System.out.println(bb.getFlag()+"---->>>>>>");  
			}
		}).start();
	}
 }
 public synchronized void printImage(){
	 System.out.println(images.size());
	 Iterator<String> imagekeys=images.keySet().iterator();
	 int i=1;
	 while(imagekeys.hasNext()){
		 String key=imagekeys.next();
		 //Image val=images.get(key);
		 System.out.printf("key=%s\n",key); // 키만 출력
		 if(i>=30){break;}
		 i++;
	 }
 }
 public static void main(String[] args) {
	    ImageFXListRequest  request=new ImageFXListRequest();
	    RequestFromWikipedai rfw=new RequestFromWikipedai();
		String a="https://ko.wikipedia.org/wiki/ISO_3166-1";
		String msg="srcset=\"//upload.wikimedia.org/wikipedia";
		rfw.getAllHtml(a);   
		//rfw.printHtml();
		rfw.getSevereign(msg);
		//rfw.printFlags();
		
		request.getAllImages(rfw.getFlags());  //image를 맵에 저장
		request.printImage();
 }
}