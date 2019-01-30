package kr.co.infopub.chapter.s102;

public class Youtube {
	private String title;
	private String url;
	private String img;

	public Youtube() {
		
	}
	public Youtube(String title, String url, String img) {
		super();
		this.title = title;
		this.url = url;
		this.img = img;
	}
	@Override
	public String toString() {
		return "Youtube [title=" + title + ", url=" + url + ", img=" + img + "]";
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getVname() {
		return toUrl(this.url);
	}
	//2017.4.12 /watch?v=PCaKey131NQ PCaKey131NQ 만 얻음
	public String toUrl(String msg){
		String tt="";
		if(msg.indexOf("=")==-1){//없다면
			tt=msg;
		}else{
			tt=msg.substring(msg.indexOf("=")+1);
		}
		return tt;
	}
}
