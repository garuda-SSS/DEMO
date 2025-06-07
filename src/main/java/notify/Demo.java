package notify;  // Пакет должен совпадать с папкой!

public class Demo {
    public static void main(String[] args) {
        EmailNotification test2 = new EmailNotification("test@gmail.com","test2");
        SmsNotification test3 = new SmsNotification("22222","test3");
        Notification[] demo_array = {test2, test3};
        for (Notification n : demo_array) {
            n.send();
        }
        System.out.println("Длина массива " + demo_array.length);
    }
}
