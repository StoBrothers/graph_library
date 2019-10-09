# graph_library
Graph library

Technologies: Java 8, JUnit, lombok.

========================

Requirements
------------
Install Java 8.65 version
http://www.oracle.com/ 

Install Apache Maven 
https://maven.apache.org

Introduction

This library allows building the path between two vertices.
Implentation of this library based on the Depth-First Search (DFS) algorithm.
The DFS algorithm is starting from starting point and go into depth of graph 
until it reach a dead end and then move up to parent node. 


Java classes
--------------------------

Vertex - wrapper for user defined type.
Edge - edge between two vertices.
Graph - interface for working with graph instance.
GraphImpl - Implementation of directed and undirected graphs.
GraphsFactory - Factory for building directed and undirected graphs.
GraphType - types of graphs.

Test java classes
--------------------------

GraphUnitTest  - unit test
TestUtil - Utility for tests

How to build the project?
--------------------------

```
mvn clean install
```


How to run tests?
--------------------------

```
mvn test
```



This undirected graph used in tests.

![alt text](https://github.com/StoBrothers/graph_library/blob/master/star_undirected.png)



This directed graph used in tests.
![alt text](https://github.com/StoBrothers/graph_library/blob/master/star_directed.png)



author: Sergey Stotskiy

