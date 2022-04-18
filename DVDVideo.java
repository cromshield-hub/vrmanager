import java.util.Date;

public class DVDVideo extends Video {

    public DVDVideo(String title, int priceCode, Date registeredDate) {
        super(title, priceCode, registeredDate);

        this.setTitle(title);
        this.setPriceCode(priceCode);
        this.setRegisteredDate(registeredDate);
    }

    @Override
    public int getLateReturnPointPenalty() { return 3; }

    @Override
    public int getLimitDays() { return 2; }

}
