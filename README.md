# wordle
## Game
[Wordle](https://www.nytimes.com/games/wordle/index.html)

### Abstract 


### Instructions

#### Install

Download [wordle.zip](https://github.com/daus-s/wordle/blob/9b84d70db36743ef3eceda56ce308385358f3cda/wordle.zip)


##### Linux/Unix



##### Windows



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
`
enter word: cover
values gyb: gbbby
`
- Continue these steps until the wordle is solved. 

[Tutorial](https://www.twitch.tv/videos/1841246263)

\*contains spoilers for wordle 6/8/2023
###### Sources
https://github.com/charlesreid1/five-letter-words/blob/master/sgb-words.txt - list of 5 letter words used to filter words
