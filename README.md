# tdbstats

General statistical queries for Jena TDB instances.

### Requirements

- Java
- Maven (to build)

### Build

Build the executable JAR with:

```bash
mvn clean package
```

You can find it in:

```bash
target/tdbstats-1.0.0.jar
```

### Execution

Assumes that the TDB directory exists in the working directory. If it does not then one will be created.

```bash
# Copy tdbstats JAR to Jena TDB.

cd "$HOME/jena/database"
cp target/tdbstats-1.0.0.jar .

java -jar tdbstats-1.0.0.jar
```
