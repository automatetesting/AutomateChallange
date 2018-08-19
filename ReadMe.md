SOME EXAMPLES TO RUN 
====================
Run the feature file manually or use the below commands. The farmework is capable of executing the feature files in parallel and also across differnet local browsers

mvn  -Dtest=SomePatternThatDontMatchAnything -DfailIfNoTests=false clean verify
mvn verify -Dtest=SomePatternThatDontMatchAnything -DfailIfNoTests=false -Dcucumber.options="--tags @smoke

----for Sequential excution of all tags----
mvn verify -Dcucumber.options="--tags @smoke
mvn clean verify  -Dtest=IgnoreTphase -DfailIfNoTests=false -Dcucumber.options="--tags @red"
