package decorator;
public class EmailNotifier implements Notifier {
    public void send() {
        System.out.println("Sending Email Notification");
    }
}
