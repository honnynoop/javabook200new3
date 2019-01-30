package kr.co.infopub.chapter.s101;
import java.io.Serializable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
// (key, value)
public class BillbaordProperty implements Serializable {
    private IntegerProperty rank;
    private StringProperty artist;
    private StringProperty song;
    private StringProperty imagesrc;
    private IntegerProperty lastweek;
	public BillbaordProperty() {
        this.rank = new SimpleIntegerProperty();
        this.artist = new SimpleStringProperty();
        this.song = new SimpleStringProperty();
        this.imagesrc = new SimpleStringProperty();
        this.lastweek = new SimpleIntegerProperty();
	}
	public IntegerProperty rankProperty() {
		return rank;
	}
	public StringProperty artistProperty() {
		return artist;
	}
	public StringProperty songProperty() {
		return song;
	}
	public StringProperty imagesrcProperty() {
		return imagesrc;
	}
	public IntegerProperty lastweekProperty() {
		return lastweek;
	}
	public int getRank() {
		return rank.getValue();
	}
	public void setRank(int v) {
		this.rank.setValue(v);
	}
	public String getArtist() {
		return artist.getValue();
	}
	public void setArtist(String v) {
		this.artist.setValue(v);
	}
	public String getSong() {
		return song.getValue();
	}
	public void setSong(String song) {
		this.song.setValue(song);
	}
	public String getImagesrc() {
		return imagesrc.getValue();
	}
	public void setImagesrc(String imagesrc) {
		this.imagesrc.setValue(imagesrc);
	}
	public int getLastweek() {
		return lastweek.getValue();
	}
	public void setLastweek(int lastweek) {
		this.lastweek.setValue(lastweek);
	}
	@Override
	public String toString() {
		return "[rank=" + rank.getValue() + ", artist=" + artist.getValue() + ", "
				+ "song=" + song.getValue() + ", imagesrc=" + imagesrc.getValue()
				+ ", lastweek=" + lastweek.getValue() + "]";
	}
}
