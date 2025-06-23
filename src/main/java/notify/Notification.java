package notify;

import java.util.concurrent.atomic.AtomicInteger;


public abstract class Notification implements Sendable{
    private static final AtomicInteger COUNTER  = new AtomicInteger(1);

    private final int id;

    public String getMessage() {
        return message;
    }

    public Priority getPriority() {
        return priority;
    }

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
    public abstract void send();

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