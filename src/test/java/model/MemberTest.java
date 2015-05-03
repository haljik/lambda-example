package model;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MemberTest {

    private List<Member> members() {
        return Arrays.asList(
                new Member("engineering", "haljik"),
                new Member("engineering", "mark"),
                new Member("marketing", "john doe")
        );
    }

    private Map<String, List<Member>> groupedMembers() {
        Map<String, List<Member>> map = new HashMap<>();
        for (Member member : members()) {
            if (!map.containsKey(member.organizationCode)) {
                map.put(member.organizationCode, new ArrayList<>());
            }
            map.get(member.organizationCode).add(member);
        }
        return map;
    }


    @Test
    public void groupBy() {
        Map<String, List<Member>> groupedMembers = members().stream().collect(Collectors.groupingBy(it -> it.organizationCode));

        assertThat(groupedMembers.size(), is(2));
        assertThat(groupedMembers.get("engineering").size(), is(2));
        assertThat(groupedMembers.get("marketing").size(), is(1));
        //List内部の順序は維持されるが、Mapのキー元のListの順序とは違う
        //このアサーションはMapのｷｰ順序に依存しているため、groupedMembers()内部でLinkedHashMapなど順序保証のMapを使うと破綻する
        assertThat(groupedMembers().toString(), is(groupedMembers.toString()));

        System.out.println(groupedMembers);
    }

}