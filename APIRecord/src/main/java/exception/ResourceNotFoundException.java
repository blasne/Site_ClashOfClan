package exception;

public class ResourceNotFoundException extends ClashOfClansApiException {
    public ResourceNotFoundException() {
        super("Resource was not found");
    }

}
