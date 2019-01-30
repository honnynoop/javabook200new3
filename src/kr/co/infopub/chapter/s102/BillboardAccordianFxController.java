package kr.co.infopub.chapter.s102;
import java.io.File;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.ImageView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class BillboardAccordianFxController {
	
 @FXML
 private Accordion baccordina;
 @FXML
 private TreeView<String> youtrv;
 @FXML
 private WebView webview;
 @FXML
 private Button btnAf;
 @FXML
 private Button btnBf;
 @FXML
 private Label lbbill;
 
 ObservableList<BillbaordProperty> obsbills;
 ImageFXListRequest  request=new ImageFXListRequest();
 YoutupeParser parser=new YoutupeParser();
 TreeItem<String> root = new TreeItem<String>("Singer ");
 int count=0;
 @FXML
 void onClickBtnBf(ActionEvent event) {
	count++;
	baccordina.getPanes().clear(); //페인에 붙은 것들 제거 후
	getAllBillboard();  //다시 불러서
	showAllBillboard(); //붙임
 }
 @FXML
 void onClickBtnAf(ActionEvent event) {
	count=0;
	baccordina.getPanes().clear();//페인에 붙은 것들 제거 후
	getAllBillboard();  //다시 불러서
	showAllBillboard(); //붙임
 }
 
 @FXML
 void initialize() {
	getAllBillboard();
	showAllBillboard();
	youtrv.getSelectionModel().selectedItemProperty().addListener(
    		(observable, oldValue, newValue) -> {
    			if(newValue!=null){
    				final WebEngine webEngine = webview.getEngine();
    				 //https://www.youtube.com/watch?v=2vjPBrBU-TM
    				String ttt=String.format("https://www.youtube.com/watch?v=%s",
    						           ((TreeItem<String>)newValue).getValue());
    				webEngine.load(ttt);
    			}
    		});
	youtrv.setRoot(root);
 }
 public void loadTreeItems(String key){
	root.getChildren().clear();
	TreeItem<String> abs = new TreeItem<String>(key);
	root.getChildren().add(abs);
	root.setExpanded(true);
	ArrayList<Youtube> youlist=parser.getTitles(key);
	for(Youtube you:youlist){
		TreeItem<String> aa=new TreeItem<String>(you.getUrl());
		abs.getChildren().add(aa);
	   	System.out.println(you.getUrl()+"---------------------------->");
	}
 }
 public void getAllBillboard(){
	RequestFromBillboardHot rfw=new RequestFromBillboardHot();
	String a="https://www.billboard.com/charts/hot-100/";
	String rs=rfw.getTimeDate(a);
	rs=RestDay.toWantedDay(rs, count); //count 주 이전
	rfw.getBillboardData(a+rs);
	ArrayList<Billbaord> bills=rfw.getBillboards();
    request.getAllImages(bills);  //image
    obsbills= BillboardConvert.toObservBill(bills);
    lbbill.setText("Billboard Chat HOT 100 "+rs);
 }
 public void showAllBillboard(){
	//TitledPane firsttitle = new TitledPane();
	if(obsbills!=null){
		for(BillbaordProperty bp: obsbills){
			TitledPane mytitle = new TitledPane();
			mytitle.setText(bp.getRank()+". "+bp.getArtist());
    		ImageView theImage = new ImageView(request.loadImage(bp.getImagesrc()));
    		theImage.setOnMouseClicked(event -> {
    			if(mytitle.getText()!=null || mytitle.getText().indexOf(".")!=-1 ){
    				System.out.println(mytitle.getText()+"1----------------->>>");//ok
        			loadTreeItems(mytitle.getText());
    			}
            });
    		mytitle.setOnMouseClicked(event -> {
    			if(mytitle.getText()!=null || mytitle.getText().indexOf(".")!=-1 ){
    				System.out.println(mytitle.getText()+"2----------------->>>");//ok
        			loadTreeItems(mytitle.getText());
    			}
            });
    		theImage.setFitHeight(50);
    		theImage.setFitWidth(50);
    		theImage.setPreserveRatio (false);
    		mytitle.setContent(theImage);
    		baccordina.getPanes().add(mytitle);
		}
	}
 }
}
