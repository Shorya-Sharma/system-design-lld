package factory;

public class Main {
    public static void main(String[] args) {
        Notification notification = NotificationFactory.createNotification("EMAIL");
        notification.send("Welcome to our service!");

        notification = NotificationFactory.createNotification("SMS");
        notification.send("Your verification code is 123456");

        notification = NotificationFactory.createNotification("PUSH");
        notification.send("New message received!");
    }
}