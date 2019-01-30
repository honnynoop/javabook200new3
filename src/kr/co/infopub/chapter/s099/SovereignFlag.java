package kr.co.infopub.chapter.s099;

import java.io.Serializable;

public class SovereignFlag implements Serializable{

	private String name;
	private String shortname;
	private String code;
	private String flag;
	private String korname;
	//for android
	private int rid;
	
	

	public SovereignFlag() {
	}
	
	public SovereignFlag(String name, String shortname, String code,
			String korname, int rid) {
		super();
		this.name = name;
		this.shortname = shortname;
		this.code = code;
		this.korname = korname;
		this.rid = rid;
	}

	public SovereignFlag(String name, String shortname, String code,
			String flag, String korname) {
		super();
		this.name = name;
		this.shortname = shortname;
		this.code = code;
		this.flag = flag;
		this.korname = korname;
	}

	public SovereignFlag(String name, String shortname, String code, String flag) {
		super();
		this.name = name;
		this.shortname = shortname;
		this.code = code;
		this.flag = flag;
	}
	public SovereignFlag(String name, String shortname, String code) {
		super();
		this.name = name;
		this.shortname = shortname;
		this.code = code;
	}

	public String getKorname() {
		return korname;
	}

	public void setKorname(String korname) {
		this.korname = korname;
	}

	@Override
	public String toString() {
		return "SovereignFlag [name=" + name + ", shortname=" + shortname
				+ ", code=" + code + ", flag=" + flag + ", korname=" + korname
				+ "]";
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShortname() {
		return shortname;
	}
	public void setShortname(String shortname) {
		this.shortname = shortname;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}
}
