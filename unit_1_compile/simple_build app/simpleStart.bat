javac -sourcepath ./src -d build/classes -cp ./libs/commons-lang3-3.11.jar;./libs/commons-math3-3.2.jar src/ua/com/alevel/test/Test.java src/ua/com/alevel/test/Factorial.java src/ua/com/alevel/Main.java
java -cp build/classes/;./libs/commons-lang3-3.11.jar;./libs/commons-math3-3.2.jar. src.ua.com.alevel.Main
@echo SIMPLE COMPILE AND RUN ARE SUCCESSFUL
@dir
@pause

