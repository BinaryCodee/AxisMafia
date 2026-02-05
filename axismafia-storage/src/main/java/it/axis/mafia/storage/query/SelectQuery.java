package it.axis.mafia.storage.query;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SelectQuery implements QueryPart {
    private final String table;
    private final List<String> columns = new ArrayList<>();
    private String whereClause;

    public SelectQuery(String table) {
        this.table = table;
    }

    public SelectQuery select(String... cols) {
        for (String c : cols)
            columns.add(c);
        return this;
    }

    public SelectQuery where(String condition) {
        this.whereClause = condition;
        return this;
    }

    @Override
    public String getSql() {
        String cols = columns.isEmpty() ? "*" : String.join(", ", columns);
        String sql = "SELECT " + cols + " FROM " + table;
        if (whereClause != null)
            sql += " WHERE " + whereClause;
        return sql;
    }
}
