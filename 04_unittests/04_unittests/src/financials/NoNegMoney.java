package financials;

public class NoNegMoney extends RuntimeException {

    public NoNegMoney() {
    }

    public NoNegMoney(String message) {
        super(message);
    }


    public NoNegMoney(Throwable cause) {
        super(cause);
    }


    public NoNegMoney(String message, Throwable cause) {
        super(message, cause);
    }
}
