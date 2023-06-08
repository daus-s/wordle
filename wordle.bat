@ECHO OFF
ECHO WORDLE-BOT
cd ..\wordle
java -jar Wordle.jar
IF ERRORLEVEL 1
(
	ECHO "error occured, compiling and rebuilding Wordle.jar"
	javac Wordle.java
	jar cfe Wordle.jar Wordle Wordle.class
	java -jar Wordle.jar
)
PAUSE