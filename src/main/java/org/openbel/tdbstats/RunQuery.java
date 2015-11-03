package org.openbel.tdbstats;

import org.apache.jena.query.*;
import org.apache.jena.sparql.core.Prologue;

import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class RunQuery {

    private final DescribedQuery dq;

    public RunQuery(DescribedQuery dq) {
        this.dq = dq;
    }

    public void execute(Dataset dataset) {
        Prologue prologue = new Prologue();
        //prologue.setPrefix("skos", "http://www.w3.org/2004/02/skos/core#");

        Query query = QueryFactory.parse(new Query(prologue), dq.query, null, null);

        try(QueryExecution queryExec = QueryExecutionFactory.create(query, dataset)) {
            ResultSet rs = queryExec.execSelect();
            if (rs.hasNext()) {
                String header = rs.getResultVars().stream().collect(Collectors.joining("\t\t"));
                System.out.println(header);
                while (rs.hasNext()) {
                    QuerySolution solution = rs.next();
                    String row = StreamSupport.stream(Spliterators.
                            spliteratorUnknownSize(solution.varNames(), Spliterator.ORDERED), false).
                            map(var -> solution.get(var).toString()).
                            collect(Collectors.joining("\t\t"));
                    System.out.println(row);
                }
            }
        }
    }
}
