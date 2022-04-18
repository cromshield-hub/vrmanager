import java.util.Date;

public class CDVideo extends Video {

    public CDVideo(String title, int priceCode, Date registeredDate) {
        super(title, priceCode, registeredDate);

        this.setTitle(title);
        this.setPriceCode(priceCode);
        this.setRegisteredDate(registeredDate);
    }

    @Override
    public int getLateReturnPointPenalty() { return 2; }

    @Override
    public int getLimitDays() { return 3; }
}
