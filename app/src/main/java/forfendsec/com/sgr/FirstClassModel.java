package forfendsec.com.sgr;

/**
 * Created by Joshua Munaweza on 12/15/17.
 */

public class FirstClassModel {
    int _train_id;
    String train;
    String destination;
    String seats;
    String price;

    public FirstClassModel(int _train_id, String train, String destination, String seats, String price) {
        this._train_id = _train_id;
        this.train = train;
        this.destination = destination;
        this.seats = seats;
        this.price = price;
    }

    public FirstClassModel(String train, String destination, String seats, String price) {
        this.train = train;
        this.destination = destination;
        this.seats = seats;
        this.price = price;
    }

    public FirstClassModel() {

    }


    public int getId() {
        return this._train_id;
    }

    public void setId(int _train_id) {
        this._train_id = _train_id;
    }

    public String getTrain() {
        return this.train;
    }

    public void setTrain(String train) {
        this.train = train;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getSeats() {
        return this.seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


}

