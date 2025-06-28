package notify;

public interface Sendable {
    void send();

    static  <T extends Sendable> void sendAll(Iterable<T> elements) {
        for (T element : elements) {
            element.send();
        }
    }

    default void typeOfNotification(){
        System.out.println("Это уведомление типа " +this.getClass().getSimpleName());
    }
}