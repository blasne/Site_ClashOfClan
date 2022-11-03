package exception;

public class ServiceTemprorarilyException extends ClashOfClansApiException {
    public ServiceTemprorarilyException() {
        super("Service is temprorarily unavailable because of maintenance.");
    }
}
