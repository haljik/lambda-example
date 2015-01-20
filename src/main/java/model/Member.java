package model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * Created by zzoTeam04_nw on 2015/01/20.
 */
public class Member {
    String organizationCode;
    String name;

    public Member(String organizationCode, String name) {
        this.organizationCode = organizationCode;
        this.name = name;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
