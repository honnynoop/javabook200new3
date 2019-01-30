package kr.co.infopub.chapter.s097;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.web.WebView;
public class BillboardfxController {
	@FXML
	private TableView<Billbaord> billobardTable;
    @FXML
    private TableColumn<Billbaord, String> song;
    @FXML
    private TableColumn<Billbaord, String> artist;
    @FXML
    private TableColumn<Billbaord, Integer> lastweek;
    @FXML
    private TableColumn<Billbaord, Integer> rank;
    @FXML
    private TableColumn<Billbaord, String> imagesrc;
    @FXML
    private WebView billwebview;
    @FXML
    private Button btnAf;
    @FXML
    private Button btnBf;
    @FXML
    private Label lbbill;

    @FXML
    void onClickBtnBf(ActionEvent event) {}
    @FXML
    void onClickBtnAf(ActionEvent event) {}
    @FXML
    void initialize() {}
}
