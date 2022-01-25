import java.util.Arrays;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CandidateWords
{
  private static ArrayList<String> generateCandidates()
  {
    ArrayList<String> words = new ArrayList<String>();
    try
    {
      BufferedReader bf = new BufferedReader(new FileReader("answers.txt"));
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

    for (int a = 0; a < 6; ++a)
    {
      Scanner sc = new Scanner(System.in);
      System.out.print("enter word: ");
      String word = sc.nextLine();
      System.out.print("values gyb: ");
      String vals = sc.nextLine();


      for (int j = 0; j < 5; ++j)
      {
        if (vals.charAt(j)=='g')
        {
          requirement[j] = word.charAt(j);
        }
        if (vals.charAt(j)=='y')
        {
          requiredLetters.append(word.charAt(j));
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
            words.remove(j);
            j--;
          }
        }
      }
      for (int i = 0; i < requiredLetters.length(); ++i)
      {
        for (int j = 0; j < words.size(); ++j)
        {
          if (!words.get(j).contains("" + requiredLetters.charAt(i)))
          {
            words.remove(j);
            j--;
          }
        }
      }
      for (int i = 0; i < 5; ++i)
      {
        if (requirement[i] != '*')
        {
          for (int j = 0; j < words.size(); ++j)
          {
            if (words.get(j).charAt(i)!=requirement[i])
            {
              words.remove(j);
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
