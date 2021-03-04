call mvn clean
call mvn install
@pause
call java -jar target/app-1.0-SNAPSHOT.jar
@dir
@pause