class History {
    String url;
    String userName;
    int userId;
    History next;
    History prev;

    History(String userName, String url, int userId) {
        this.userName = userName;
        this.url = url;
        this.userId = userId;
    }
}

interface Navigation {
    void searchForward(String url, int userId);
    void searchBackward(String url, int userId);
}

abstract class UserHistory implements Navigation {
    protected History head;
    protected History tail;
    protected int size = 0;

    public void addHistory(String userName, String url, int userId) {
        History newNode = new History(userName, url, userId);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void searchForward(String url, int userId) {
        History current = head;
        while (current != null) {
            if (current.url.equals(url) && current.userId == userId) {
                System.out.println("Found in forward search: " + url);
                return;
            }
            current = current.next;
        }
        System.out.println("Not found in forward search.");
    }

    public void searchBackward(String url, int userId) {
        History current = tail;
        while (current != null) {
            if (current.url.equals(url) && current.userId == userId) {
                System.out.println("Found in backward search: " + url);
                return;
            }
            current = current.prev;
        }
        System.out.println("Not found in backward search.");
    }

    public void printHistory(int userId) {
        System.out.println("Browser History for User ID: " + userId);
        History current = head;
        while (current != null) {
            if (current.userId == userId) {
                System.out.println(current.url);
            }
            current = current.next;
        }
    }

    public int getSize() {
        return size;
    }
}

class UserSession extends UserHistory {
    	
}

public class BrowserHistory {
    public static void main(String[] args) {
        UserHistory user1 = new UserSession();

        user1.addHistory("Hemant", "facebook", 101);
        user1.addHistory("anuj", "instagram", 101);
        user1.addHistory("madhav", "linkedin", 101);

        System.out.println("Total sites visited: " + user1.getSize());

        user1.printHistory(101);

        user1.searchForward("instagram", 101);
        user1.searchBackward("facebook", 101);
    }
}
