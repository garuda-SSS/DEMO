package notify;

public interface Sendable {
    void send();

    static  <T extends Sendable> void send_all(Iterable<T> elements) {
        for (T element : elements) {
            element.send();
        }
    }

    default void type_of_notification(){
        System.out.println("Это уведомление типа " +this.getClass().getSimpleName());
    }
}