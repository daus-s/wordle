# wordle
## Game
[Wordle](https://www.nytimes.com/games/wordle/index.html)

### Abstract 

This codebase is for a program used to help (some say cheat) play the popular word game 'wordle.' The program is a CLI that takes the user's chosen word, and the following respective letter values. These are the yellow, green, and black values that Wordle returns when a guess is made. The code then eliminates words that do not match the requirements based on the output from Wordle. 
Additionally, the code also provides the best guess based on the frequency of letters remaining in the pool of words. 


All-time record as of 8/7/2023.


83W - 0L

### Instructions
#### System Requirements 
- Java runtime 
- zsh or bash on macOS
#### Install

##### macOS

1. Download the macOS zip file [wordlebot_mac.zip](https://github.com/daus-s/wordle/raw/main/wordlebot_mac.zip)
2. Extract the zip file into the desired location
3. Open a terminal window in this folder and run
    - `chmod +x wordleinstaller.sh`
    - `./wordleinstaller.sh`
4. Restart the Terminal and type `wordle` into the terminal anywhere and play. OR run `./wordle` immediately.


##### Windows

1. Download the Windows zip file [wordlebot_win.zip](https://github.com/daus-s/wordle/raw/main/wordlebot_win.zip)
2. Extract the zip file into the desired location
3. Go to this directory and run the command `wordle`



#### Playing
- Go to [Wordle](https://www.nytimes.com/games/wordle/index.html)
- Run the wordlebot (wordle.sh for macOS/Linux, wordle.bat for Windows)
- Enter the first word into both press enter for each

![Wordle after 1 round](https://github.com/daus-s/wordle/blob/d796f0d50b0a33256b8540f077aae00cf7d55bdd/round1.PNG)

**Fig 1.** Wordles output for 6/8/2023 using the word "cover" 

- Translate the colors of the wordle output to their respective characters
    - Green -> g,  this means the letter chosen is in the correct spot
    - Yellow -> y, this means the letter is present in the word but not in that spot
    - Black -> b, this letter is not present in the word
- For this example the input for the 1st round should be 
- 
```
enter word: cover
values gyb: gbbby
```

- Continue these steps until the wordle is solved. 

[Tutorial](https://www.twitch.tv/videos/1841246263)

\*contains spoilers for wordle 6/8/2023
###### Sources
https://github.com/charlesreid1/five-letter-words/blob/master/sgb-words.txt - list of 5 letter words used to filter words
