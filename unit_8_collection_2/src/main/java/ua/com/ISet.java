package ua.com;


public interface ISet<T> {
    void add(T n);
    void add(T ... n);
    void join(ISet ms);
    void join(ISet... ms);
    void sortDesc();
    void sortDesc(int firstIndex, int lastIndex);
    void sortDesc(T value);
    void sortAsc();
    void sortAsc(int firstIndex, int lastIndex);
    void sortAsc(T value);
    Number get(int index);
    Number getMax();
    Number getMin();
    Number getAverage();
    Number getMedian();
    Number[] toArray();
    Number[] toArray(int firstIndex, int lastIndex);
    ISet squash(int firstIndex, int lastIndex);
    void clear();
    void clear(T[] ts);
    void show();
}
