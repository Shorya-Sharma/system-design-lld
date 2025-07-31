package observer;

public class EmailObserverImpl implements Observer {
    private final String emailId;

    public EmailObserverImpl(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public void update() {
        sendEmail();
    }

    private void sendEmail() {
        System.out.println("Sending Email to :" + emailId);
    }
}
