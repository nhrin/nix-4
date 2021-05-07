@echo --------------------Start  build-------------------------------
call mvn clean install
@echo ----------------------Run app----------------------------------
call mvn exec:java -Dexec.mainClass=com.kub.App
@pause