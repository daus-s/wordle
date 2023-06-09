echo @@@@@@@@@@@@@@@@@@@@@@@@@@
echo "@ wordle macOS installer @"
echo @@@@@@@@@@@@@@@@@@@@@@@@@@

currentDirectory=$(pwd)
#in bash

# Check if wordle command already exists in PATH
path="export PATH=\"\$PATH:${currentDirectory}\"\n"



if grep -q "export PATH=\"\$PATH:${currentDirectory}\"" ~/.bash_profile; then
    echo "The wordle command is already set up in PATH."
else
    # Add wordle command to PATH
    echo "" >> ~/.bash_profile
    echo "# wordle bot command path" >> ~/.bash_profile
    echo -e $path >> ~/.bash_profile
    echo "The wordle command has been added to PATH."
fi

source ~/.bash_profile

# set up the wordle executable
echo "cd ${currentDirectory}
      echo WORDLE
      java -jar Wordle.jar
      STATUS=\$?
      if [ \$STATUS -ne 0 ]; then
        echo \"error occured, compiling and rebuilding Wordle.jar\"
        javac Wordle.java
        jar cfe Wordle.jar Wordle Wordle.class
        java -jar Wordle.jar
      fi" >| wordle


chmod +x wordle



echo "Installation complete."
read -p "Press Enter to exit..."