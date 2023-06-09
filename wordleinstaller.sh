echo @@@@@@@@@@@@@@@@@@@@@@@@@@
echo "@ wordle macOS installer @"
echo @@@@@@@@@@@@@@@@@@@@@@@@@@

currentDirectory=$(pwd)
chmod +x wordle

#in bash

path="
${currentDirectory}/wordle"
echo "#wordle bot command path"
echo $path >> `/.bash_profile 

read 
