package notify;

import java.util.*;

public class NotificationManager<T extends Notification> {

    private final List<T> notificationsList = new ArrayList<>();
    private final Map<Priority, List<T>> notificationsByPriority = new HashMap<>();

    public void add(T new_element) throws DuplicateIdException {
        if (notificationsList.stream().anyMatch(element -> element.getId() == new_element.getId())) {
            throw new DuplicateIdException("Уведомление с ID " + new_element.getId() + " уже добавлено");
        }
        notificationsList.add(new_element);
        notificationsByPriority.computeIfAbsent(new_element.getPriority(),
                k -> new ArrayList<>()).add(new_element);
    }


    public Optional<T> find(int search_id) {
        return notificationsList.stream()
                .filter(element -> element.getId() == search_id)
                .findFirst();
    }

    public List<T> get(Priority priority){
        List<T> originalList = notificationsByPriority.get(priority);
        return (originalList != null) ? new ArrayList<>(originalList) : null;
    };


    public void sendAll(){
        Sendable.sendAll(notificationsList);
    }

}