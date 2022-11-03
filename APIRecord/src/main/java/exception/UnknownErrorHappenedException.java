package exception;

public class UnknownErrorHappenedException extends ClashOfClansApiException {
    public UnknownErrorHappenedException() {
        super("Unknown error happened when handling the request.");
    }
}
