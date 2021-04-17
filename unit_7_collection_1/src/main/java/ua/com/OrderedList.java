package ua.com;

import java.util.*;
import java.util.function.UnaryOperator;

public class OrderedList<E> implements List<E> {

    private Node<E> previous;
    private Node<E> next;
    private Node<E> first;

    private int size = 0;

    public OrderedList() {
        this.previous = new Node<E>();
    }

    private Node<E> getByIndex(int index) {
        Node<E> node = null;
        if (!isEmpty() && (index >= 0 && index < size)) {
            node = first;
            for (int i = 1; i <= index; i++) {
                node = node.getNext();
            }
        }
        return node;
    }

    @Override
    public void replaceAll(UnaryOperator operator) {

    }

    @Override
    public void sort(Comparator c) {

    }

    @Override
    public Spliterator spliterator() {
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size(); i++) {
            if (get(i).equals(o)) return true;
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] a) {
        Object[] array = new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = getByIndex(i).getT();
        }
        return array;
    }

    @Override
    public boolean add(E e) {
        Node<E> node = new Node<E>((Node) e);
        if (first == null) {
            first = node;
        } else {
            previous = first;
        }
        if (size() == 1) {
            first.setNext(node);
        }
        size++;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        Node<E> node = first;
        for (int i = 0; i < size(); i++) {
            if (node.equals(o)) {
                node.getPrevious().setNext(node.getNext());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        E element;
        if (index >= 0 && index < size()) {
            element = getByIndex(index).getT();
        } else throw new IndexOutOfBoundsException();
        return element;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }
}
