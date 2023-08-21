package my.day16.ex01;

import java.util.Date;

//게시물
public class Board {

	// 필드
	private int bno;
	private String btitle;
	private String bcontect;
	private String bwriter;
	private Date bdate;
	
	
	// 생성자
	public Board() {}
	
	public Board(int bno, String btitle, String bcontect, String bwriter, Date bdate) {
	
		this.bno = bno;
		this.btitle = btitle;
		this.bcontect = bcontect;
		this.bwriter = bwriter;
		this.bdate = bdate;
	}
	
	// getter, setter
	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBcontect() {
		return bcontect;
	}

	public void setBcontect(String bcontect) {
		this.bcontect = bcontect;
	}

	public String getBwriter() {
		return bwriter;
	}

	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}

	public Date getBdate() {
		return bdate;
	}

	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}
	
	@Override
	public String toString() {
	    String str = "no:" + bno + "\n" +
	                 "title:" + btitle + "\n" +
	                 "content:" + bcontect + "\n" +
	                 "writer:" + bwriter + "\n" +
	                 "date:" + bdate;
	    return str;
	}
	
}
