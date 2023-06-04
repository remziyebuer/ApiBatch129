package pojos;

public class BookingDatesPojo {
    //elimde bir json data var onu java objesine cevirmem lazim yoksa post , patch..
    // vs islemleri yapamam bu seferde pojo class kullaniyoruz daha cok tercih edilir
    // cün ki daha hizli ve daha güvenlidir

    //önce inner pojo icin bir class olusturalim

    private String checkin;
    private String checkout;

    public BookingDatesPojo(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
//bunu yapmasanizda olur setter ile atama yaparsiniz ama bu bize kolaylik saglar
    }
    public BookingDatesPojo() {
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    @Override
    public String toString() {// o objede neler var onu görmek icin
        return "BookingDatesPojo{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }

}