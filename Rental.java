import java.util.Date;

public class Rental {
	private Video video ;
	private RentalStatus rentalStatus; // 0 for Rented, 1 for Returned
	private Date rentDate ;
	private Date returnDate ;

	public Rental(Video video) {
		this.video = video ;
		rentalStatus = RentalStatus.Rented ;
		rentDate = new Date() ;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public RentalStatus getRentalStatus() {
		return rentalStatus;
	}
	public void setRentalStatus(RentalStatus status) {
		rentalStatus = status;
	}

	public void returnVideo() {
		if (isReturned(RentalStatus.Rented)) {
			setRentalStatus(RentalStatus.Returned);
			returnDate = new Date() ;
			getVideo().setRented(false);
		}
	}
	public Date getRentDate() {
		return rentDate;
	}

	public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public int getDaysRentedLimit() {
		int limit = 0 ;
		int daysRented ;
		daysRented = getDaysRented();
		if ( daysRented <= 2) return limit ;

		switch ( video.getVideoType() ) {
			case VHS: limit = 5 ; break ;
			case CD: limit = 3 ; break ;
			case DVD: limit = 2 ; break ;
		}
		return limit ;
	}

	public int getDaysRented() {
		int daysRented;
		long diff;
		if (isReturned(RentalStatus.Returned)) { // returned Video
			diff = returnDate.getTime() - rentDate.getTime();
		} else { // not yet returned
			diff = new Date().getTime() - rentDate.getTime();
		}
		daysRented = (int) (diff / (1000 * 60 * 60 * 24)) + 1;
		return daysRented;
	}

	private boolean isReturned(RentalStatus returned) {
		return getRentalStatus() == returned;
	}


	public boolean isRented(String videoTitle) {
		return (getVideo().getTitle().equals(videoTitle) && getVideo().isRented());
	}


	public enum RentalStatus {
		Rented, Returned
	}
}
