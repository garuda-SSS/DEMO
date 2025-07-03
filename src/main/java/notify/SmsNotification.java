package notify;

public class SmsNotification extends Notification {
    private String phoneNumber;

    public SmsNotification(String phoneNumber, String message) {
        super(message, Priority.LOW);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void send() {
        System.out.println("Sending sms to " + this.phoneNumber);
        System.out.println(super.toString());
    }
}
