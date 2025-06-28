package notify;

import java.util.concurrent.atomic.AtomicInteger;


public abstract class Notification implements Sendable{
    private static final AtomicInteger COUNTER  = new AtomicInteger(1);

    private String message;
    private Priority priority;
    private final int id;


    public Notification(String message,Priority priority) {
        id = COUNTER .getAndIncrement();
        this.message = message;
        this.priority = priority;
    }

    public Notification() {
        this("empty",Priority.NORMAL);
    }

    public String getMessage() {
        return message;
    }

    public Priority getPriority() {
        return priority;
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
    public abstract void send();

    public void sendWithExtra(String extra) {
        System.out.println(this.message);
        System.out.println(this.priority);
        System.out.println(extra);
    }

    @Override
    public String toString() {
        return "Message: " + this.message + ", Priority: " + this.priority;
    }
}