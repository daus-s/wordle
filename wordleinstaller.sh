echo @@@@@@@@@@@@@@@@@@@@@@@@@@
echo "@ wordle macOS installer @"
echo @@@@@@@@@@@@@@@@@@@@@@@@@@

currentDirectory=$(pwd)
chmod +x wordle

#in bash

# Check if wordle command already exists in PATH
if grep -q "export PATH=\"\$PATH:${currentDirectory}\"" ~/.bash_profile; then
    echo "The wordle command is already set up in PATH."
else
    # Add wordle command to PATH
    path="export PATH=\"\$PATH:${currentDirectory}\"\n"
    echo "" >> ~/.bash_profile
    echo "# wordle bot command path" >> ~/.bash_profile
    echo -e $path >> ~/.bash_profile
    echo "The wordle command has been added to PATH."
fi

source ~/.bash_profile

echo "Installation complete."
read -p "Press Enter to exit..."