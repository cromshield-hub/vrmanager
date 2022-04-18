import java.util.Date;

public class VideoFactory {
    public static Video createVHSVideo(String title, int priceCode, Date registeredDate){
        return new VHSVideo(title, priceCode, registeredDate);
    }

    public static Video createCDVideo(String title, int priceCode, Date registeredDate){
        return new CDVideo(title, priceCode, registeredDate);
    }

    public static Video createDVDVideo(String title, int priceCode, Date registeredDate){
        return new DVDVideo(title, priceCode, registeredDate);
    }

    public static Video createVideo(int i, String title, int priceCode, Date registeredDate) {
        switch(i) {
            case 1:
                return createVHSVideo(title, priceCode, registeredDate);
            case 2:
                return createCDVideo(title, priceCode, registeredDate);
            case 3:
                return createDVDVideo(title, priceCode, registeredDate);
            default:
                return null;
        }
    }
}
