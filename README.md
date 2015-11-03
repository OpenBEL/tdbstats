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

### Output

```
$ java -jar tdbstats-1.0.0.jar 
no
20110969^^http://www.w3.org/2001/XMLSchema#integer
total number of triples
-----------------------
SELECT (COUNT(*) AS ?no) { ?s ?p ?o  }

Completed in 10.6 seconds.
no
1094481^^http://www.w3.org/2001/XMLSchema#integer
total number of entities
------------------------
SELECT (COUNT(DISTINCT ?s) AS ?no) { ?s a []  }

Completed in 23.602 seconds.
no
1574974^^http://www.w3.org/2001/XMLSchema#integer
total number of DISTINCT resource URIs (deprecated??)
-----------------------------------------------------
SELECT (COUNT(DISTINCT ?s) AS ?no) { { ?s ?p ?o  } UNION { ?o ?p ?s } FILTER(!isBlank(?s) && !isLiteral(?s)) }

Completed in 99.957 seconds.
no
20^^http://www.w3.org/2001/XMLSchema#integer
total number of DISTINCT classes
--------------------------------
SELECT (COUNT(DISTINCT ?o) AS ?no) { ?s rdf:type ?o }

Completed in 3.19 seconds.
no
14^^http://www.w3.org/2001/XMLSchema#integer
total number of DISTINCT predicates
-----------------------------------
SELECT (COUNT(DISTINCT ?p) AS ?no) { ?s ?p ?o }

Completed in 15.043 seconds.
no
1557586^^http://www.w3.org/2001/XMLSchema#integer
total number of DISTINCT subject nodes
--------------------------------------
SELECT (COUNT(DISTINCT ?s) AS ?no) {  ?s ?p ?o   }

Completed in 24.436 seconds.
no
1284856^^http://www.w3.org/2001/XMLSchema#integer
total number of DISTINCT object nodes
-------------------------------------
SELECT (COUNT(DISTINCT ?o) AS ?no) {  ?s ?p ?o  filter(!isLiteral(?o)) }

Completed in 57.41 seconds.
type
http://www.openbel.org/vocabulary/RNAConcept
http://www.openbel.org/vocabulary/AbundanceConcept
http://www.openbel.org/vocabulary/NamespaceConcept
http://www.w3.org/2004/02/skos/core#Concept
http://www.openbel.org/vocabulary/CellLineAnnotationConcept
http://www.openbel.org/vocabulary/AnnotationConcept
http://www.openbel.org/vocabulary/CellAnnotationConcept
http://www.openbel.org/vocabulary/DiseaseAnnotationConcept
http://www.openbel.org/vocabulary/PathologyConcept
http://www.openbel.org/vocabulary/BiologicalProcessConcept
http://www.openbel.org/vocabulary/GeneConcept
http://www.openbel.org/vocabulary/ProteinConcept
http://www.openbel.org/vocabulary/MicroRNAConcept
http://www.openbel.org/vocabulary/ComplexConcept
http://www.openbel.org/vocabulary/AnatomyAnnotationConcept
http://www.openbel.org/vocabulary/LocationAnnotationConcept
http://www.openbel.org/vocabulary/SpeciesAnnotationConcept
http://www.openbel.org/vocabulary/AnnotationConceptScheme
http://www.w3.org/2004/02/skos/core#ConceptScheme
http://www.openbel.org/vocabulary/NamespaceConceptScheme
exhaustive list of classes used in the dataset
----------------------------------------------
SELECT DISTINCT ?type { ?s a ?type }

Completed in 7.478 seconds.
p
http://www.w3.org/1999/02/22-rdf-syntax-ns#type
http://purl.org/dc/terms/identifier
http://www.openbel.org/vocabulary/fromSpecies
http://www.w3.org/2004/02/skos/core#exactMatch
http://www.w3.org/2004/02/skos/core#inScheme
http://www.w3.org/2004/02/skos/core#prefLabel
http://www.openbel.org/vocabulary/orthologousMatch
http://purl.org/dc/terms/title
http://www.w3.org/2004/02/skos/core#altLabel
http://purl.org/dc/terms/replaces
http://www.openbel.org/vocabulary/domain
http://www.openbel.org/vocabulary/prefix
http://www.w3.org/2004/02/skos/core#closeMatch
http://www.openbel.org/vocabulary/status
exhaustive list of properties used in the dataset
-------------------------------------------------
SELECT DISTINCT ?p { ?s ?p ?o }

Completed in 30.255 seconds.
class		count
3^^http://www.w3.org/2001/XMLSchema#integer		http://www.openbel.org/vocabulary/SpeciesAnnotationConcept
9^^http://www.w3.org/2001/XMLSchema#integer		http://www.openbel.org/vocabulary/AnnotationConceptScheme
18^^http://www.w3.org/2001/XMLSchema#integer		http://www.openbel.org/vocabulary/NamespaceConceptScheme
24^^http://www.w3.org/2001/XMLSchema#integer		http://www.w3.org/2004/02/skos/core#ConceptScheme
230^^http://www.w3.org/2001/XMLSchema#integer		http://www.openbel.org/vocabulary/LocationAnnotationConcept
2194^^http://www.w3.org/2001/XMLSchema#integer		http://www.openbel.org/vocabulary/CellAnnotationConcept
2222^^http://www.w3.org/2001/XMLSchema#integer		http://www.openbel.org/vocabulary/ComplexConcept
8210^^http://www.w3.org/2001/XMLSchema#integer		http://www.openbel.org/vocabulary/MicroRNAConcept
11250^^http://www.w3.org/2001/XMLSchema#integer		http://www.openbel.org/vocabulary/DiseaseAnnotationConcept
11519^^http://www.w3.org/2001/XMLSchema#integer		http://www.openbel.org/vocabulary/PathologyConcept
12380^^http://www.w3.org/2001/XMLSchema#integer		http://www.openbel.org/vocabulary/CellLineAnnotationConcept
14897^^http://www.w3.org/2001/XMLSchema#integer		http://www.openbel.org/vocabulary/AnatomyAnnotationConcept
40954^^http://www.w3.org/2001/XMLSchema#integer		http://www.openbel.org/vocabulary/AnnotationConcept
41045^^http://www.w3.org/2001/XMLSchema#integer		http://www.openbel.org/vocabulary/BiologicalProcessConcept
221380^^http://www.w3.org/2001/XMLSchema#integer		http://www.openbel.org/vocabulary/ProteinConcept
401574^^http://www.w3.org/2001/XMLSchema#integer		http://www.openbel.org/vocabulary/GeneConcept
720442^^http://www.w3.org/2001/XMLSchema#integer		http://www.openbel.org/vocabulary/RNAConcept
1023938^^http://www.w3.org/2001/XMLSchema#integer		http://www.openbel.org/vocabulary/AbundanceConcept
1064983^^http://www.w3.org/2001/XMLSchema#integer		http://www.openbel.org/vocabulary/NamespaceConcept
1094457^^http://www.w3.org/2001/XMLSchema#integer		http://www.w3.org/2004/02/skos/core#Concept
table: class vs. total number of instances of the class
-------------------------------------------------------
SELECT ?class (COUNT(?s) AS ?count) { ?s a ?class } GROUP BY ?class ORDER BY ?count

Completed in 24.827 seconds.
p		count
http://www.openbel.org/vocabulary/prefix		24^^http://www.w3.org/2001/XMLSchema#integer
http://www.openbel.org/vocabulary/domain		25^^http://www.w3.org/2001/XMLSchema#integer
http://www.w3.org/2004/02/skos/core#closeMatch		39847^^http://www.w3.org/2001/XMLSchema#integer
http://purl.org/dc/terms/replaces		202377^^http://www.w3.org/2001/XMLSchema#integer
http://www.openbel.org/vocabulary/status		463063^^http://www.w3.org/2001/XMLSchema#integer
http://purl.org/dc/terms/title		493012^^http://www.w3.org/2001/XMLSchema#integer
http://www.openbel.org/vocabulary/fromSpecies		728861^^http://www.w3.org/2001/XMLSchema#integer
http://www.w3.org/2004/02/skos/core#prefLabel		1094481^^http://www.w3.org/2001/XMLSchema#integer
http://purl.org/dc/terms/identifier		1218949^^http://www.w3.org/2001/XMLSchema#integer
http://www.w3.org/2004/02/skos/core#inScheme		1557556^^http://www.w3.org/2001/XMLSchema#integer
http://www.w3.org/2004/02/skos/core#altLabel		1615552^^http://www.w3.org/2001/XMLSchema#integer
http://www.w3.org/2004/02/skos/core#exactMatch		2498384^^http://www.w3.org/2001/XMLSchema#integer
http://www.w3.org/1999/02/22-rdf-syntax-ns#type		4671729^^http://www.w3.org/2001/XMLSchema#integer
http://www.openbel.org/vocabulary/orthologousMatch		5527109^^http://www.w3.org/2001/XMLSchema#integer
table: property vs. total number of triples using the property
--------------------------------------------------------------
SELECT  ?p (COUNT(?s) AS ?count) { ?s ?p ?o } GROUP BY ?p ORDER BY ?count

Completed in 33.667 seconds.
p		count
http://www.openbel.org/vocabulary/domain		24^^http://www.w3.org/2001/XMLSchema#integer
http://www.openbel.org/vocabulary/prefix		24^^http://www.w3.org/2001/XMLSchema#integer
http://www.w3.org/2004/02/skos/core#closeMatch		17474^^http://www.w3.org/2001/XMLSchema#integer
http://purl.org/dc/terms/replaces		94925^^http://www.w3.org/2001/XMLSchema#integer
http://www.openbel.org/vocabulary/orthologousMatch		391224^^http://www.w3.org/2001/XMLSchema#integer
http://www.openbel.org/vocabulary/status		463059^^http://www.w3.org/2001/XMLSchema#integer
http://purl.org/dc/terms/title		493012^^http://www.w3.org/2001/XMLSchema#integer
http://www.w3.org/2004/02/skos/core#altLabel		538415^^http://www.w3.org/2001/XMLSchema#integer
http://www.openbel.org/vocabulary/fromSpecies		728861^^http://www.w3.org/2001/XMLSchema#integer
http://www.w3.org/2004/02/skos/core#exactMatch		1065599^^http://www.w3.org/2001/XMLSchema#integer
http://purl.org/dc/terms/identifier		1094457^^http://www.w3.org/2001/XMLSchema#integer
http://www.w3.org/1999/02/22-rdf-syntax-ns#type		1094481^^http://www.w3.org/2001/XMLSchema#integer
http://www.w3.org/2004/02/skos/core#prefLabel		1094481^^http://www.w3.org/2001/XMLSchema#integer
http://www.w3.org/2004/02/skos/core#inScheme		1557556^^http://www.w3.org/2001/XMLSchema#integer
table: property vs. total number of DISTINCT subjects in triples using the property
-----------------------------------------------------------------------------------
SELECT  ?p (COUNT(DISTINCT ?s) AS ?count) { ?s ?p ?o } GROUP BY ?p ORDER BY ?count

Completed in 37.73 seconds.
p		count
http://www.openbel.org/vocabulary/fromSpecies		3^^http://www.w3.org/2001/XMLSchema#integer
http://www.openbel.org/vocabulary/status		3^^http://www.w3.org/2001/XMLSchema#integer
http://www.openbel.org/vocabulary/domain		11^^http://www.w3.org/2001/XMLSchema#integer
http://www.w3.org/1999/02/22-rdf-syntax-ns#type		20^^http://www.w3.org/2001/XMLSchema#integer
http://www.openbel.org/vocabulary/prefix		24^^http://www.w3.org/2001/XMLSchema#integer
http://www.w3.org/2004/02/skos/core#inScheme		24^^http://www.w3.org/2001/XMLSchema#integer
http://www.w3.org/2004/02/skos/core#closeMatch		14293^^http://www.w3.org/2001/XMLSchema#integer
http://purl.org/dc/terms/replaces		201112^^http://www.w3.org/2001/XMLSchema#integer
http://purl.org/dc/terms/title		255320^^http://www.w3.org/2001/XMLSchema#integer
http://www.openbel.org/vocabulary/orthologousMatch		391215^^http://www.w3.org/2001/XMLSchema#integer
http://www.w3.org/2004/02/skos/core#prefLabel		1070554^^http://www.w3.org/2001/XMLSchema#integer
http://www.w3.org/2004/02/skos/core#exactMatch		1083537^^http://www.w3.org/2001/XMLSchema#integer
http://purl.org/dc/terms/identifier		1116671^^http://www.w3.org/2001/XMLSchema#integer
http://www.w3.org/2004/02/skos/core#altLabel		1161827^^http://www.w3.org/2001/XMLSchema#integer
table: property vs. total number of DISTINCT objects in triples using the property
----------------------------------------------------------------------------------
SELECT  ?p (COUNT(DISTINCT ?o) AS ?count) { ?s ?p ?o } GROUP BY ?p ORDER BY ?count

Completed in 72.095 seconds.
```
