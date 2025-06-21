When downloading Maven dependencies, especially artifact org.glassfish.jersey:jersey-bom:pom:2.27 artifact you should use proxy, otherwise you will have following network error: 

[ERROR]     Non-resolvable import POM: Could not transfer artifact org.glassfish.jersey:jersey-bom:pom:2.27 from/to central (https://repo.maven.apache.org/maven2): transfer failed for https://repo.maven.apache.org/maven2/org/glassfish/jersey/jersey-bom/2.27/jersey-bom-2.27.pom @ line 47, column 25: Network is unreachable


Rules for testing:
- All features should have a unit test or tests.
- Should be used JUnit with matchers from Hamcrest library.
- Should be used Mockito library when needed.
