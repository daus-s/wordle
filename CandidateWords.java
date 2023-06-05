import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CandidateWords
{
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

      int y = 0;

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
            System.out.println("removed: " + words.remove(j));
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
            System.out.println("removed: " + words.remove(j));
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
                  System.out.println("removed: " + words.remove(j));
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
      for (int i = 0; i < 5; ++i)
      {
        if (requirement[i] != '*')
        {
          for (int j = 0; j < words.size(); ++j)
          {
            if (words.get(j).charAt(i) != requirement[i])
            {
              System.out.println("removed: " + words.remove(j));
              --j;
            }
          }
        }
      }
      System.out.println(words);
    }
  }
  public static void main(String[] args)
  {
    ArrayList<String> words = generateCandidates();
    getInput(words);
  }
}
