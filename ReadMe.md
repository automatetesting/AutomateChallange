sOME EXAMPLES TO RUN 
====================
mvn  -Dtest=SomePatternThatDontMatchAnything -DfailIfNoTests=false clean verify
mvn verify -Dtest=SomePatternThatDontMatchAnything -DfailIfNoTests=false -Dcucumber.options="--tags @smoke

----for Sequential excution of all tags----
mvn verify -Dcucumber.options="--tags @smoke
mvn clean verify  -Dtest=IgnoreTphase -DfailIfNoTests=false -Dcucumber.options="--tags @red"
