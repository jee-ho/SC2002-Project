package Entity;

public class TicketInfo{
    double returnPrice;
    String ticketType;

    public TicketInfo(double returnPrice, String ticketType) {
        this.returnPrice = returnPrice;
        this.ticketType = ticketType;
    }

    public static TicketInfo getTicketInfo(double returnPrice, String ticketType) {
        return new TicketInfo(returnPrice, ticketType);
	}

    public double getreturnPrice() {
        return returnPrice;
    }

    public String getticketType() {
        return ticketType;
    }
}
