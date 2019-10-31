
/**
 * Virtual High School
 * Patrick James O'Donnell
 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class WordConverter
{
  private static FileInputStream file;
  private static InputStreamReader inputReader;
  private static BufferedReader reader;
  private static String text, word, lastLetter, secondLastLetter, vowel1,
    vowel2, vowel3, vowel4, suffix, suffixFirstLetter;

  public static void main(String[] args) throws IOException
  {
    importDoc();
    convertPlural();
    convertSuffix();
  }

  // find document in files
  public static void importDoc() throws IOException
  {
    file =
      new FileInputStream(
        "//Users//patrick//Desktop//Eclipse//!!VHSJava//Vowels-R-Us//vowels.txt");
    inputReader = new InputStreamReader(file);
    reader = new BufferedReader(inputReader);
  }

  // this method takes input from the text file and converts the original word into its plural
  public static void convertPlural() throws IOException
  {
    while ((text = reader.readLine()) != null)
    {
      String word = text.substring(0, text.indexOf(" "));
      String vowel1 = "A", vowel2 = "S", vowel3 = "C", vowel4 = "L";
      String lastLetter = text.substring(word.length() - 1, word.length());
      String secondLastLetter =
        text.substring(word.length() - 2, word.length() - 1);

      System.out.println("The original word is: " + word);
      if (lastLetter.equalsIgnoreCase(vowel1)
        || lastLetter.equalsIgnoreCase(vowel2)
        || lastLetter.equalsIgnoreCase(vowel3)
        || lastLetter.equalsIgnoreCase(vowel4))
      {
        if (secondLastLetter.equalsIgnoreCase(vowel1)
          || secondLastLetter.equalsIgnoreCase(vowel2)
          || secondLastLetter.equalsIgnoreCase(vowel3)
          || secondLastLetter.equalsIgnoreCase(vowel4))
        {
          // word ends in double vowel
          word += lastLetter + "H";
          System.out.println(
            "This word ended in a double vowel, so it is now: " + word);
          continue;
        }
        // word ends in single vowel
        word = word.substring(0, word.length() - 1) + "G";
        System.out
          .println("This word ended in a single vowel, so it is now: " + word);
        continue;
      }
      if (!lastLetter.equalsIgnoreCase(vowel1)
        && !lastLetter.equalsIgnoreCase(vowel2)
        && !lastLetter.equalsIgnoreCase(vowel3)
        && !lastLetter.equalsIgnoreCase(vowel4))
      {
        if (!secondLastLetter.equalsIgnoreCase(vowel1)
          && !secondLastLetter.equalsIgnoreCase(vowel2)
          && !secondLastLetter.equalsIgnoreCase(vowel3)
          && !secondLastLetter.equalsIgnoreCase(vowel4))
        {
          // vowel ends in double consonant
          word += "GH";
          System.out.println(
            "This word ended in a double consonant, so it is now: " + word);
          continue;
        }
        // vowel ends in single consonant
        word += lastLetter + "H";
        System.out.println(
          "This word ended in a single consonant, so it is now: " + word);
      }
    }
  }

  // this method takes input from the text file and adds the suffix to the original word
  public static void convertSuffix() throws IOException
  {
    while ((text = reader.readLine()) != null)
    {
      word = text.substring(0, text.indexOf(" "));
      suffix = text.substring(text.indexOf(" ") + 1, text.length());
      suffixFirstLetter =
        text.substring(text.indexOf(" ") + 1, text.indexOf(" ") + 2);
      lastLetter = word.substring((word.length() - 1), word.length());
      secondLastLetter = word.substring((word.length() - 2), word.length() - 1);

      System.out.println("Original: " + text);

      // checks if suffix starts with a vowel
      if (suffixFirstLetter.equalsIgnoreCase("a")
        || suffixFirstLetter.equalsIgnoreCase("l")
        || suffixFirstLetter.equalsIgnoreCase("c")
        || suffixFirstLetter.equalsIgnoreCase("s"))
      {
        // checks if suffix ends with a vowel
        if (lastLetter.equalsIgnoreCase("a") || lastLetter.equalsIgnoreCase("l")
          || lastLetter.equalsIgnoreCase("c")
          || lastLetter.equalsIgnoreCase("s"))
        {
          // check if word ends in two vowels
          if (secondLastLetter.equalsIgnoreCase("a")
            || secondLastLetter.equalsIgnoreCase("l")
            || secondLastLetter.equalsIgnoreCase("c")
            || secondLastLetter.equalsIgnoreCase("s"))
          {
            // word ends in double vowel and starts with single vowel
            word += suffixFirstLetter + suffix;
            System.out.println("Suffix: " + word);
            System.out.println(" ");
            continue;
          }
          // suffix starts with vowel and word ends in single vowel
          word += suffix.substring(1, suffix.length());
          System.out.println("Suffix: " + word);
          System.out.println(" ");
        }
        // check if last letter of word is consonant
        if (!lastLetter.equalsIgnoreCase("a")
          && !lastLetter.equalsIgnoreCase("l")
          && !lastLetter.equalsIgnoreCase("c")
          && !lastLetter.equalsIgnoreCase("s"))
        {
          // check if second to last letter of word is consonant
          if (!secondLastLetter.equalsIgnoreCase("a")
            && !secondLastLetter.equalsIgnoreCase("l")
            && !secondLastLetter.equalsIgnoreCase("c")
            && !secondLastLetter.equalsIgnoreCase("s"))
          {
            // word ends in double consonant and suffix starts with vowel
            word += suffixFirstLetter + suffix;
            System.out.println("Suffix: " + word);
            System.out.println(" ");
            continue;
          }
          // suffix starts with vowel and word ends in single consonant
          word += suffix;
          System.out.println("Suffix: " + word);
          System.out.println(" ");
        }
      }
      // checks if suffix starts with consonant
      else if (!suffixFirstLetter.equalsIgnoreCase("a")
        && !suffixFirstLetter.equalsIgnoreCase("l")
        && !suffixFirstLetter.equalsIgnoreCase("c")
        && !suffixFirstLetter.equalsIgnoreCase("s"))
      {
        // check if word ends in vowel
        if (lastLetter.equalsIgnoreCase("a") || lastLetter.equalsIgnoreCase("l")
          || lastLetter.equalsIgnoreCase("c")
          || lastLetter.equalsIgnoreCase("s"))
        {
          // check if word ends in two vowels
          if (secondLastLetter.equalsIgnoreCase("a")
            || secondLastLetter.equalsIgnoreCase("l")
            || secondLastLetter.equalsIgnoreCase("c")
            || secondLastLetter.equalsIgnoreCase("s"))
          {
            // word ends in double vowel and suffix starts with consonant
            for (int i = word.length(); i > 0; i--)
            {
              String character = word.substring((i - 1), i);
              if (!character.equalsIgnoreCase("a")
                && !character.equalsIgnoreCase("l")
                && !character.equalsIgnoreCase("c")
                && !character.equalsIgnoreCase("s"))
              {
                word =
                  word.substring(0, i) + word.substring((i + 1), word.length())
                    + suffix;
                System.out.println("Suffix: " + word);
                System.out.println(" ");
                break;
              }
            }
            continue;
          }
          // suffix starts with consonant and word ends in single vowel
          word += suffixFirstLetter + suffix;
          System.out.println("Suffix: " + word);
          System.out.println(" ");
        }
        // check if last letter of word is consonant
        if (!lastLetter.equalsIgnoreCase("a")
          && !lastLetter.equalsIgnoreCase("l")
          && !lastLetter.equalsIgnoreCase("c")
          && !lastLetter.equalsIgnoreCase("s"))
        {
          // check if second to last letter of word is consonant
          if (!secondLastLetter.equalsIgnoreCase("a")
            && !secondLastLetter.equalsIgnoreCase("l")
            && !secondLastLetter.equalsIgnoreCase("c")
            && !secondLastLetter.equalsIgnoreCase("s"))
          {
            // word ends in double consonant and suffix starts with consonant
            for (int i = word.length(); i > 0; i--)
            {
              String character = word.substring((i - 1), i);
              if (character.equalsIgnoreCase("a")
                || character.equalsIgnoreCase("l")
                || character.equalsIgnoreCase("c")
                || character.equalsIgnoreCase("s"))
              {
                word =
                  word.substring(0, i) + word.substring((i + 1), word.length())
                    + suffix;
                System.out.println("Suffix: " + word);
                System.out.println(" ");
                break;
              }
            }
            continue;
          }
          // suffix starts with consonant and word ends in single consonant
          word += suffix;
          System.out.println("Suffix: " + word);
          System.out.println(" ");
        }
      }
    }
  }
}
