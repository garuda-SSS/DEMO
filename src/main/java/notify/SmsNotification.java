package notify;

public class SmsNotification extends Notification{
    private String phone_number;

    public SmsNotification(String phone_number, String message){
        super(message,Priority.LOW);
        this.phone_number=phone_number;
    }

    @Override
    public void send() {
        System.out.println("Sending sms to " + this.phone_number);
        System.out.println(this.getMessage());
        System.out.println(this.getPriority());;
    }
}
