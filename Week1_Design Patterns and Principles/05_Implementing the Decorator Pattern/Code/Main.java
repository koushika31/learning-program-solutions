package decorator;
public class Main {
    public static void main(String[] args) {
        Notifier n = new SlackNotifier(new SMSNotifier(new EmailNotifier()));
        n.send();
    }
}
