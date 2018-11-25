# crawler


How to build and run your solution

-> to build: 'mvn clean install' in directory with pom.xml

-> to run: 'java -jar crawler-0.0.1-SNAPSHOT.jar' in target directory 

-> enter 'http://localhost:8080/start.xhtml'

-> type url and check progress and results on console or application.log file

-> for test purposes please use some small domains or subdomains like: 'https://alkohole-domowe.com/wino', indexing big pages takes long time


Expectations:

- Web application which gets url, 
- checks in database if indexed version of page is available,
- if yes then display indexed version from database
- if not starts task to analyze 
- display progress in real time on web application
 
What did I manage to do:

- page to get and validate url
- working indexer (pages and all images)
- all is displayed only in console

Explanation of what could be done with more time

- Good hierarchical model
- Done all from 'expectations'
- Everything covered by tests
- Analyzer working in more threads 
