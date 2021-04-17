package ua.com;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node<T> {
    private Node next;
    private Node previous;
    private T t;

    public Node() {
        this.next = null;
        this.previous = null;
    }
    public Node (Node previous) {
        this.next = null;
        this.previous = previous;
    }

    @Override
    public boolean equals(Object obj) {
        return t.equals(obj);
    }
}
