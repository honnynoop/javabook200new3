package kr.co.infopub.chapter.s099;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 
public class BillboardImageTest3 extends Application {
 
    public static void main(String[] args) {
        launch(args);
    }
    ImageFXListRequest  request=new ImageFXListRequest();
    RequestFromWikipedai rfw=new RequestFromWikipedai();
    
    @Override
    public void start(Stage primaryStage) {
    	String a="https://ko.wikipedia.org/wiki/ISO_3166-1";
    	String msg="srcset=\"//upload.wikimedia.org/wikipedia";
    	rfw.getAllHtml(a);   
    	//rfw.printHtml();
    	rfw.getSevereign(msg);
    	//rfw.printFlags();
    	ArrayList<SovereignFlag> flags=rfw.getFlags();
    	request.getAllImages(flags);  //image List
    	int col=25; 
		//계속 읽는 것을 방지
		request.getAllImages(flags);  //image를 맵에 저장
		ImageView nimageView = new ImageView();
		nimageView.setFitWidth(250);
		nimageView.setFitHeight(250);
		VBox root = new VBox(25);
 
        int row=flags.size()/col;
        for(int i=0; i<row; i++){
        	HBox hbox = new HBox(10);            // 한줄에 10개를 묶는다.
            hbox.setPadding(new Insets(5));
            hbox.setAlignment(Pos.CENTER);
        	for (int j = 0; j < col; j++) {      
        		SovereignFlag b=flags.get(i*col+j);  
            	ImageView imageView = new ImageView(request.loadImage(b.getFlag()));
            	imageView.setFitWidth(50);
            	imageView.setFitHeight(50);
            	imageView.setOnMouseClicked(ee->{
            		nimageView.setImage(request.loadImage(b.getFlag()));
            	});
            	hbox.getChildren().add(imageView);
			}
        	root.getChildren().add(hbox);        // 아래로 HBox를 붙인다. 
        }
        
        HBox hbox2 = new HBox(10);            // 한줄에 10개를 묶는다.
        hbox2.setPadding(new Insets(5));
        hbox2.setAlignment(Pos.CENTER);
        hbox2.getChildren().add(nimageView);
        root.getChildren().add(hbox2);
        
        primaryStage.setScene(new Scene(root, 55*col, 65*col+260));
        primaryStage.setTitle("Billboard Image");
        primaryStage.show();
    }
    
}

   