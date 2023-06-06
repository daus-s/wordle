import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class CandidateWords
{
  public static boolean DEBUG = false;
  private static ArrayList<String> generateCandidates()
  {
    ArrayList<String> words = new ArrayList<String>();
    try
    {
      BufferedReader bf = new BufferedReader(new FileReader("sgb-words.txt"));
      String line = bf.readLine();
      while (line != null)
      {
        words.add(line);
        line = bf.readLine();
      }
    }
    catch (IOException io)
    {
      io.printStackTrace();
    }
    return words;
  }



  private static void getInput(ArrayList<String> words)
  {
    analysis(words);
    StringBuilder disallowedLetters = new StringBuilder();
    char[] requirement = {'*','*','*','*','*'};
    StringBuilder requiredLetters = new StringBuilder();

    //misplaced letters
    char[] misLetter = new char[21];
    for (int i = 0; i < 21; ++i)
    {
      misLetter[i] = ' ';
    }
    int[][] position  = new int [21][5];
    for (int i = 0; i < 21; ++i)
    {
      for (int j = 0; j < 5; ++j)
      {
        position[i][j] = 0;
      }
    }

    int y = 0;
    for (int a = 0; a < 6; ++a)
    {
      boolean removed = false;
      Scanner sc = new Scanner(System.in);
      System.out.print("enter word: ");
      String word = sc.nextLine();
      System.out.print("values gyb: ");
      String vals = sc.nextLine();
      if (vals.equals("ggggg"))
      {
        System.out.printf("solved in %d rounds!\n", a+1);
        return;
      }


      //TODO: Check for double letters here
      for (int i = 0; i < 5; i++)
      {
        for (int j = i+1; j < 5; j++) {
          if (word.charAt(i)==word.charAt(j))
          {
            if (vals.charAt(i)=='y' && vals.charAt(j)=='b')
            {
              vals = vals.substring(0, j) + 'y' + vals.substring(j + 1);
            }
            if (vals.charAt(i)=='b' && vals.charAt(j)=='y')
            {
              vals = vals.substring(0, i) + 'y' + vals.substring(i + 1);
            }
            if (vals.charAt(i)=='g' && vals.charAt(j)=='b')
            {
              vals = vals.substring(0, j) + 'y' + vals.substring(j + 1);
            }
            if (vals.charAt(i)=='b' && vals.charAt(j)=='g')
            {
              vals = vals.substring(0, i) + 'y' + vals.substring(i + 1);
            }
          }
        }
      }

      for (int j = 0; j < 5; ++j)
      {
        if (vals.charAt(j)=='g')
        {
          requirement[j] = word.charAt(j);
        }
        if (vals.charAt(j)=='y')
        {
          requiredLetters.append(word.charAt(j));
          misLetter[y] = word.charAt(j);
          position[y][j] = -1;
          y++;
        }
        if (vals.charAt(j)=='b')
        {
          disallowedLetters.append(word.charAt(j));
        }
      }





      for (int i = 0; i < disallowedLetters.length(); ++i)
      {
        for (int j = 0; j < words.size(); ++j)
        {
          if (words.get(j).contains("" + disallowedLetters.charAt(i)))
          {
            if (DEBUG)
            {
              System.out.printf("removed %s because %s contains the disallowed(BLACK) letter %c\n", words.get(j), words.get(j), disallowedLetters.charAt(i));
            }
            words.remove(j);
            j--;
          }
        }
      }
      //the word doesn't have a needed letter (GREEN CONDITION)
      for (int i = 0; i < requiredLetters.length(); ++i)
      {
        for (int j = 0; j < words.size(); ++j)
        {
          if (!words.get(j).contains("" + requiredLetters.charAt(i)))
          {
            if (DEBUG)
            {
              System.out.printf("removed %s because %s does not contain the required(GREEN) letter %c\n", words.get(j), words.get(j), requiredLetters.charAt(i));
            }
            words.remove(j);
            j--;
          }
        }
      }

      //meets YELLOW condition
      for (int i = 0; i < requiredLetters.length(); ++i)
      {
        for (int j = 0; j < words.size(); ++j)
        {
          for (int x = 0; x < 21; ++x)
          {
            for (int w = 0; w < 5; ++w)
            {
              if (misLetter[x]!=' ')
              {
                if (words.get(j).charAt(w)==misLetter[x]&&position[x][w]==-1)
                {
                  removed = true;
                  if (DEBUG)
                  {
                    System.out.printf("removed %s because %s has the letter %c but the letter is in the position %d (YELLOW) \n"
                            , words.get(j), words.get(j), requiredLetters.charAt(i), w + 1);
                  }
                  words.remove(j);
                  break;
                }
              }
            }
            if (removed)
            {
              break;
            }
          }
          if (removed)
          {
            removed = false;
            break;
          }
        }
      }

      //does not match required pattern
      for (int i = 0; i < 5; ++i)
      {
        if (requirement[i] != '*')
        {
          for (int j = 0; j < words.size(); ++j)
          {
            if (words.get(j).charAt(i) != requirement[i])
            {
              if (DEBUG)
              {
                System.out.printf("removed %s because %s does not match the pattern %c%c%c%c%c\n", words.get(j), words.get(j), requirement[0], requirement[1], requirement[2], requirement[3], requirement[4]);
              }
              words.remove(j);
              --j;
            }
          }
        }
      }
      System.out.println(words);
      analysis(words);

    }
  }

  private static void analysis(ArrayList<String> words)
  {
    char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    double[] percentages = new double[26];
    for (int l = 0; l < alphabet.length; ++l)
    {
      int count = 0;
      for (String word : words)
      {
        if (word.contains("" + alphabet[l]))
        {
          count++;
        }
      }
      percentages[l] = ((double)count)/((double)words.size());
    }
    double[] scores = new double[words.size()];
    //now find the word with the highest percentage score
    for (int i = 0; i < words.size(); i++)
    {
      double s = 0;
      for (int j = 0; j < 5; j++)
      {
        s += percentages[((int)words.get(i).charAt(j) - 97)];
      }
      scores[i] = s;
      //print stats
      if (DEBUG)
      {
        System.out.printf("%s : %f\n", words.get(i), scores[i]);
      }
    }
    double maxScore = -1;
    int maxIndex = -1;
    for (int i = 0; i < words.size(); i++)
    {
      if (scores[i] >= maxScore && !doubleLetters(words.get(i)))
      {
        maxScore = scores[i];
        maxIndex = i;
      }
    }
    if (maxIndex!=-1)
      System.out.printf("the best word choice is %s\n", words.get(maxIndex));
    else
      System.out.printf("the best word choice is %s\n", words.get(0));
  }

  private static boolean doubleLetters(String s)
  {
    for (int i = 0; i < 5; i++)
    {
      for (int j = i+1; j < 5; j++)
      {
        if (s.charAt(j) == s.charAt(i))
        {
          return true;
        }
      }
    }
    return false;
  }

  public static void main(String[] args)
  {
    ArrayList<String> words = generateCandidates();
    getInput(words);
  }
}
