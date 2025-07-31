package observer;

public class MobileObserverImpl implements Observer {

    private final String mobileNo;

    public MobileObserverImpl(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    @Override
    public void update() {
        sendSms();
    }

    private void sendSms() {
        System.out.println("Sending Sms to :" + mobileNo);
    }

}
