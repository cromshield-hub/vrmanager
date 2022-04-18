import java.util.Date;

public class VHSVideo extends Video {

    public VHSVideo(String title, int priceCode, Date registeredDate) {
        super(title, priceCode, registeredDate);

        this.setTitle(title);
        this.setPriceCode(priceCode);
        this.setRegisteredDate(registeredDate);
    }

    @Override
    public int getLateReturnPointPenalty() { return 1; }

    @Override
    public int getLimitDays() { return 5; }

}
