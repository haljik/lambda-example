package stream;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by haljik on 15/05/03.
 */
public class IndexedList<T> {

    private final List<T> values; //index アクセスできるやつ

    private IndexedList(List<T> values) {
        this.values = values;
    }

    private Stream<IndexedValue<T>> stream() {
        return IntStream.range(0, values.size())
                .mapToObj(index -> new IndexedValue<>(index, values.get(index)));
    }

    public static <T> Stream<IndexedValue<T>> stream(List<T> values) {
        return new IndexedList<>(values).stream();
    }
}
