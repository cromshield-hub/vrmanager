import java.util.Date;

public abstract class Video {
	private String title ;

	private int priceCode ;
	public static final int REGULAR = 1 ;
	public static final int NEW_RELEASE =2 ;

	private VideoType videoType ;

	private Date registeredDate ;
	private boolean rented ;


	public abstract int getLateReturnPointPenalty();
	public abstract int getLimitDays();

	protected Video(String title, int priceCode, Date registeredDate) {
		this.setTitle(title) ;
		this.setPriceCode(priceCode) ;
		this.registeredDate = registeredDate ;
	}


	public int getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(int priceCode) {
		this.priceCode = priceCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}

	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

	public VideoType getVideoType() {
		return videoType;
	}

	protected void setVideoType(VideoType videoType) {
		this.videoType = videoType;
	}


	public enum VideoType {
		VHS, CD, DVD;
	}
}
