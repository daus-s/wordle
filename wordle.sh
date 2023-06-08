cd /wordle
echo WORDLE
java -jar Wordle.jar
STATUS=$?
if [$STATUS=1]; then
	echo "error occured, compiling and rebuilding Wordle.jar"
	javac Wordle.java
	jar cfe Wordle.jar Wordle Wordle.class
fi