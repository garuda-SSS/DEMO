package notify;

public class EmailNotification extends Notification{
    private String email;

    public EmailNotification(String email, String message){
        super(message,Priority.HIGH);
        this.email=email;
    }

    @Override
    public void send() {
        System.out.println("Sending e-mail to " + this.email);
        System.out.println(super.toString());
    }
}
