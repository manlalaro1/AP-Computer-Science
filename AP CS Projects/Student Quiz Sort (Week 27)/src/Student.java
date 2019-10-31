/*
 * Virtual High School
 * Patrick James O'Donnell
 */

import java.util.*;

public class Student
{

  private String id;
  private String[] quizresult = new String[10];
  private String letterGrade;
  int score;

  public Student()
  {
    id = " ";
    for (int i = 0; i < quizresult.length; i++)
    {
      quizresult[i] = "";
    }
    score = 0;
  }

  public Student(String a, String[] answers)
  {
    id = a;
    for (int i = 0; i < answers.length; i++)
    {
      quizresult[i] = answers[i];
    }
    score = 0;
  }

  public String[] getAnwers()
  {
    return quizresult;
  }

  public String getId()
  {
    return id;
  }

  public void grade(String[] answerkey, String[] studentanswer)
  {
    int count = 0;
    for (int i = 0; i < answerkey.length; i++)
    {
      if (answerkey[i].equals(studentanswer[i]))
      {
        count = count + 10;
      }
    }
    score = count;
  }

  public void assignLetterGrade(int score)
  {
    if (score == 100)
    {
      letterGrade = "A";
    }
    else if (score == 90)
    {
      letterGrade = "B";
    }
    else if (score == 80 || score == 70)
    {
      letterGrade = "C";
    }
    else if (score == 60 || score == 50)
    {
      letterGrade = "D";
    }
    else
    {
      letterGrade = "F";
    }
  }

  public String toString()
  {
    String a =
      "Student id: " + id + " " + Arrays.toString(quizresult)
        + " The score for this quiz is:  " + score + "\n";
    return a;
  }
}
