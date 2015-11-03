package org.openbel.tdbstats;

import org.apache.jena.query.Dataset;
import org.apache.jena.tdb.TDBFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static java.lang.System.currentTimeMillis;
import static java.lang.String.format;

public class Main {

    public static void main(String[] args) throws IOException {
        Dataset dataset = TDBFactory.createDataset(".");
        InputStream sparqls = Main.class.getResourceAsStream("/sparqls.lst");
        try (BufferedReader rdr = new BufferedReader(new InputStreamReader(sparqls))) {
            String line;
            DescribedQuery dq = new DescribedQuery();
            while ((line = rdr.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                if (line.startsWith("#")) {
                    dq.description = line.replaceFirst("^#\\s*", "");
                } else {
                    dq.query       = line;
                    long start     = currentTimeMillis();
                    {
                        new RunQuery(dq).execute(dataset);
                    }
                    long finish    = currentTimeMillis();

                    double execTime = ((double) finish - start) / 1000d;

                    System.out.println(dq.toString());
                    System.out.println(format("Completed in %s seconds.", execTime));
                }
            }
        }
    }
}
