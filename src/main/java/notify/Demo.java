package notify;  // Пакет должен совпадать с папкой!

public class Demo {
    public static void main(String[] args) {
        Notification test2 = new EmailNotification("test@gmail.com", "test2");
        Notification test3 = new SmsNotification("22222", "test3");
        Notification test4 = new SmsNotification("22222", "test4");
        NotificationManager<Notification> manager = new NotificationManager<>();
        manager.add(test2);
        manager.add(test3);
        manager.add(test4);
        try {
            manager.add(test4);
        } catch (DuplicateIdException e) {
            throw new RuntimeException(e);
        }
        manager.add(test4);
        System.out.println(manager.get(Priority.HIGH));
        manager.find(10).ifPresentOrElse(Notification::send, () -> System.out.println("id не найден"));
        manager.sendAll();
        test4.typeOfNotification();
    }
}
