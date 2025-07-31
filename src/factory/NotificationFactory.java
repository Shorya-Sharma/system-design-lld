package factory;

public class NotificationFactory {
    public static Notification createNotification(String type) {
        if (type.equalsIgnoreCase("EMAIL")) {
            return new EmailNotification();
        } else if (type.equalsIgnoreCase("SMS")) {
            return new SMSNotification();
        } else if (type.equalsIgnoreCase("PUSH")) {
            return new PushNotification();
        }
        throw new IllegalArgumentException("Unknown notification type: " + type);
    }
}
