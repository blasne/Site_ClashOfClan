package exception;

public class ProvidedIncorrectParametersException extends ClashOfClansApiException {
    public ProvidedIncorrectParametersException() {
        super("Client provided incorrect parameters for the request.");
    }

    public ProvidedIncorrectParametersException(String message) {
        super(message);
    }

}