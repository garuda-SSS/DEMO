package notify;

import java.util.concurrent.atomic.AtomicInteger;

public class Notification {
    private static final AtomicInteger COUNTER  = new AtomicInteger(1);

    private final int id;

    private String message;
    private Priority priority;

    public Notification(String message,Priority priority) {
        id = COUNTER .getAndIncrement();
        this.message = message;
        this.priority = priority;
    }

    public Notification() {
        id = COUNTER .getAndIncrement();
        this.message = "empty";
        this.priority = Priority.NORMAL;
    }

    public int getId() {
        return id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
    public void send() {
        System.out.println(this.message);
        System.out.println(this.priority);
    }

    public void send(String extra) {
        System.out.println(this.message);
        System.out.println(this.priority);
        System.out.println(extra);
    }

    @Override
    public String toString() {
        return "Message: " + this.message + ", Priority: " + this.priority;
    }
}