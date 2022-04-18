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

		return video.getLimitDays();
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

	int getPoint(int daysRented, int eachPoint) {
		if ((getVideo().getPriceCode() == Video.NEW_RELEASE) )
			eachPoint++;

		if ( daysRented > getDaysRentedLimit() )
			eachPoint -= Math.min(eachPoint, getVideo().getLateReturnPointPenalty()) ;
		return eachPoint;
	}

	double getCharge(int daysRented, double eachCharge) {
		switch (getVideo().getPriceCode()) {
			case Video.REGULAR:
				eachCharge += 2;
				if (daysRented > 2)
					eachCharge += (daysRented - 2) * 1.5;
				break;
			case Video.NEW_RELEASE:
				eachCharge = daysRented * 3;
				break;
		}
		return eachCharge;
	}


	public enum RentalStatus {
		Rented, Returned
	}
}
