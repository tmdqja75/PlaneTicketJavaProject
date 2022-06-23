package Package;

public class Package {
    private String product_num;
    private String departflight_id;
    private String arriveflight_id;
    private String agency;
    private String destination;
    private String period;
    private String manual;
    private boolean isHotel;
    private boolean flight_type;
    private int product_price;

    public Package(String departflight_id, String arriveflight_id,String agency,
            String manual, boolean isHotel, boolean flight_type, int product_price) {
        this.departflight_id = departflight_id;
        this.arriveflight_id = arriveflight_id;
        this.agency = agency;
        // this.destination = destination;
        // this.period = period;
        this.manual = manual;
        this.isHotel = isHotel;
        this.flight_type = flight_type;
        this.product_price = product_price;
    }

    public String getProduct_num() {
        return product_num;
    }

    public void setProduct_num(String product_num) {
        this.product_num = product_num;
    }


    public String getDepartflight_id() {
        return departflight_id;
    }

    public void setDepartflight_id(String departflight_id) {
        this.departflight_id = departflight_id;
    }

    public String getArriveflight_id() {
        return arriveflight_id;
    }

    public void setArriveflight_id(String arriveflight_id) {
        this.arriveflight_id = arriveflight_id;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getManual() {
        return manual;
    }

    public void setManual(String manual) {
        this.manual = manual;
    }

    public boolean isHotel() {
        return isHotel;
    }

    public void setHotel(boolean isHotel) {
        this.isHotel = isHotel;
    }

    public boolean isFlight_type() {
        return flight_type;
    }

    public void setFlight_type(boolean flight_type) {
        this.flight_type = flight_type;
    }

    public int getProduct_price() {
        return product_price;
    }

    public void setProduct_price(int product_price) {
        this.product_price = product_price;
    }

    @Override
    public String toString() {
        return "Package [agency=" + agency + ", arriveflight_id=" + arriveflight_id + ", departflight_id="
                + departflight_id + ", destination=" + destination + ", flight_type=" + flight_type + ", isHotel="
                + isHotel + ", manual=" + manual + ", period=" + period + ", product_num=" + product_num
                + ", product_price=" + product_price + "]";
    }

    

}
