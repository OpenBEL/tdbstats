package org.openbel.tdbstats;

import java.util.Arrays;

public class DescribedQuery {
    public String description;
    public String query;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(description).append("\n");
        char[] hashmarks = new char[description.length()];
        Arrays.fill(hashmarks, '-');
        sb.append(new String(hashmarks)).append("\n");
        sb.append(query).append("\n");
        return sb.toString();
    }
}
