package lab03;

public class NumberBox<T extends Number> {

    private T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public double sum(Number number) {
        return item.doubleValue() + number.doubleValue();
    }
}