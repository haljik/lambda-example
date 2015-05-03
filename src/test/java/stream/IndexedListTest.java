package stream;

import model.Member;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by haljik on 15/05/03.
 */
public class IndexedListTest {

    private List<Member> members() {
        return Arrays.asList(
                new Member("engineering", "haljik"),
                new Member("engineering", "mark"),
                new Member("marketing", "john doe")
        );
    }

    @Test
    public void インデックスが付与されている() throws Exception {
        final List<IndexedValue<Member>> list = IndexedList.stream(members()).collect(Collectors.toList());
        assertThat(list.get(0).getIndex(), is(0));
        assertThat(list.get(1).getIndex(), is(1));
        assertThat(list.get(2).getIndex(), is(2));
        assertThat(list.get(0).getValue().toString(), is(members().get(0).toString()));
        assertThat(list.get(1).getValue().toString(), is(members().get(1).toString()));
        assertThat(list.get(2).getValue().toString(), is(members().get(2).toString()));
    }
}