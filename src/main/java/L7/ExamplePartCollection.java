package L7;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;


@Getter
@Setter
public class ExamplePartCollection<T> {
    private ExamplePartCollection<T> previous;
    private ExamplePartCollection<T> next;
    private  T value;

    public ExamplePartCollection(Object value) {
        this.value = (T) value;
    }

    public ExamplePartCollection getPrevious() {
        return previous;
    }

    public void setPrevious(ExamplePartCollection previous) {
        this.previous = previous;
    }

    public ExamplePartCollection getNext() {
        return next;
    }

    public void setNext(ExamplePartCollection next) {
        this.next = next;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = (T) value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ExamplePartCollection<T> that = (ExamplePartCollection<T>) o;
        return Objects.equals(value, that.value);
    }
    @Override
    public int hashCode() {
        return value.hashCode();
    }
}