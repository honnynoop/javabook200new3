package kr.co.infopub.chapter.s083;
import java.io.Serializable;
public class Billbaord implements Serializable {
	private int rank;         // 순위
	private String song;      // 곡명
	private int  lastweek;    // 전주 순위
	private String imagesrc;  // 가수사진
	private String artistsrc; // 가수정보
	private String artist;    // 가수이름
	
	public Billbaord() {}
	public Billbaord(int rank, String song, int lastweek, String imagesrc,
			String artistsrc, String artist) {
		super();
		this.rank = rank;
		this.song = song;
		this.lastweek = lastweek;
		this.imagesrc = imagesrc;
		this.artistsrc = artistsrc;
		this.artist = artist;
	}
	public Billbaord(int rank, String song, int lastweek, String imagesrc, String artist) {
		super();
		this.rank = rank;
		this.song = song;
		this.lastweek = lastweek;
		this.imagesrc = imagesrc;
		this.artist = artist;
	}
	@Override
	public String toString() {
		return "[rank=" + rank + ", song=" + song + ", lastweek="
				+ lastweek + ", imagesrc=" + imagesrc 
				 + ", artist=" + artist+"]";
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getSong() {
		return song;
	}
	public void setSong(String song) {
		this.song = song;
	}
	public int getLastweek() {
		return lastweek;
	}
	public void setLastweek(int lastweek) {
		this.lastweek = lastweek;
	}
	public String getImagesrc() {
		return imagesrc;
	}
	public void setImagesrc(String imagesrc) {
		this.imagesrc = imagesrc;
	}
	public String getArtistsrc() {
		return artistsrc;
	}
	public void setArtistsrc(String artistsrc) {
		this.artistsrc = artistsrc;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
}
