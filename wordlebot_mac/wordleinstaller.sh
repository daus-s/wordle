echo @@@@@@@@@@@@@@@@@@@@@@@@@@@@@
echo "@ wordlebot macOS installer @"
echo @@@@@@@@@@@@@@@@@@@@@@@@@@@@@

currentDirectory=$(pwd)


# Get the parent shell process ID (PPID)
ppid=$(ps -o ppid= $$)

# Get the parent shell command
parent_shell_command=$(ps -o command= "$ppid")


echo $ppid
echo SHELL:$parent_shell_command



if [ "$parent_shell_command" = "-bash" ]; then
  newpath="export PATH=\"\$PATH:${currentDirectory}\"\n"

    # Check if wordle command already exists in PATH
    if grep -q "export PATH=\"\$PATH:${currentDirectory}\"" ~/.bash_profile; then
          echo "The wordle command is already set up in PATH."
      else
        # Add wordle command to PATH
          echo "" >> ~/.bash_profile
          echo "# wordle bot command path" >> ~/.bash_profile
          echo -e $newpath >> ~/.bash_profile
          echo "The wordle command has been added to PATH."
    fi

    source ~/.bash_profile
fi

if [ "$parent_shell_command" = "zsh" ]; then
      newpath="${currentDirectory}"
      if grep -q "${currentDirectory}\"" ~/.zshrc; then
            echo "The wordle command is already set up in $HOME/.zshrc PATH variable."
        else
          # Add wordle command to PATH
          echo "export PATH=\"\$PATH:${currentDirectory}\"" >> ~/.zshrc
      fi
  fi


# set up the wordle executable
echo "cd ${currentDirectory}
      echo WORDLE
      java -jar Wordle.jar
      STATUS=\$?
      if [ \$STATUS -eq 1 ]; then
        echo \"error occured, compiling and rebuilding Wordle.jar\"
        javac Wordle.java
        jar cfe Wordle.jar Wordle Wordle.class
        java -jar Wordle.jar
      fi" >| wordle


chmod +x wordle



echo "Installation complete."
read -p "Press Enter to exit..."