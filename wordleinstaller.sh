echo @@@@@@@@@@@@@@@@@@@@@@@@@@
echo "@ wordle macOS installer @"
echo @@@@@@@@@@@@@@@@@@@@@@@@@@

currentDirectory=$(pwd)
chmod +x wordle

#in bash

path="export PATH=\"\$PATH:${currentDirectory}/wordle"\"
echo "" >> ~/.bash_profile
echo "#wordle bot command path" >> ~/.bash_profile
echo $path >> ~/.bash_profile 

