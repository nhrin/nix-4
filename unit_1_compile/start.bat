@echo --------------------Start the simple build-------------------------------
@cd simple_build app
@call "simpleStart.bat"
@cd ..
@cd ant app
@echo --------------------Start the build with Ant-----------------------------
@call "antStart.bat"
@cd ..
@cd maven app\app
@echo --------------------Start the build with Maven---------------------------
@call "mavenStart.bat"
