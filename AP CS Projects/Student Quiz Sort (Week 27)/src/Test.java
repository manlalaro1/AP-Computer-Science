
/*
 * Virtual High School
 * Patrick James O'Donnell
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Test
{

  private static FileInputStream inFile;
  private static InputStreamReader inReader;
  private static BufferedReader reader;

  private static List<Student> classroom = new ArrayList<Student>(); // ArrayList
                                                                     // to store
                                                                     // the
                                                                     // classroom.

  public static void main(String args[]) throws IOException
  {
    initFile();
    getData();
    inFile.close();
    chooseSortMethod();
  }

  // preparing the file for input

  public static void initFile() throws IOException

  {
    inFile =
      new FileInputStream(
        "//Users//patrick//Desktop//Eclipse//!!JavaDownload//truefalse.txt");
    inReader = new InputStreamReader(inFile);
    reader = new BufferedReader(inReader);

  }

  // Separate the id from the answers and store the answers in an array.

  public static void getData() throws IOException
  {
    String line = reader.readLine(); // Seed

    String[] answerkey = new String[10]; // Store the answer key from the first
                                         // line of the txt file.

    for (int i = 0; i < answerkey.length; i++)
    { // take that line and place each answer in an array.

      answerkey[i] = line.substring(i, i + 1);
    }

    line = reader.readLine(); // read the following line of the txt file.

    while (line != null) // Read and create a student for each line.
    {
      String[] answers = new String[10];
      StringTokenizer strTkn = new StringTokenizer(line);
      String id = strTkn.nextToken();
      String answerline = strTkn.nextToken();

      for (int i = 0; i < answers.length; i++)
      {

        answers[i] = answerline.substring(i, i + 1);

      }

      Student stu = new Student(id, answers);

      stu.grade(answerkey, answers);

      classroom.add(stu);

      line = reader.readLine(); // updating what is being read

    }
  }

  public static void chooseSortMethod()
  {
    // scanner to read input
    Scanner reader = new Scanner(System.in);

    // ask user for sort method and run specified method with classroom as param
    System.out.println("This is the unsorted classroom: \n" + classroom);
    System.out.println(
      "Would you like to quick sort or merge sort? Enter Q for quicksort and M for merge sort.");
    if (reader.nextLine().equalsIgnoreCase("q"))
    {
      quickSort(classroom, 0, classroom.size() - 1);
    }
    else if (reader.nextLine().equalsIgnoreCase("m"))
    {
      mergeSort(classroom);
    }
    else
    {
      System.out.println("You did not choose a valid sort method.");
    }
    System.out.println("This is the sorted classroom: ");
    System.out.println(classroom);
  }

  // I did not have trouble with the quicksort since I based it off of the
  // textbook's implementation
  public static void quickSort(List<Student> a, int left, int right)
  {
    if (left >= right)
      return;

    // set i = starting index, j = end index, and pivot value = median of the
    // current array
    int i = left;
    int j = right;
    int pivotValue = classroom.get((left + right) / 2).score;

    // while the start and end pointers do not meet, increase the start pointer
    // and decrease the end pointers
    while (i < j)
    {
      while (classroom.get(i).score < pivotValue)
        i++;
      while (pivotValue < classroom.get(j).score)
        j--;

      // swap grades if necessary
      if (i <= j)
      {
        Collections.swap(classroom, j, i);
        i++;
        j--;
      }
    }
    // recursively call the subarrays and repeat the process until list is
    // sorted completely
    quickSort(classroom, left, j);
    quickSort(classroom, i, right);

  }

  /*
   * I could not get my merge sort to work! If anyone has any suggestions please
   * share because I was trying to debug this for hours
   */
  public static void mergeSort(List<Student> a)
  {
    List<Student> copyBuffer = new ArrayList<Student>(a.size());
    mergeSortHelper(a, copyBuffer, 0, a.size() - 1);
  }

  public static void mergeSortHelper(List<Student> a, List<Student> copyBuffer,
    int low, int high)
  {
    if (low < high)
    {
      int middle = (low + high) / 2;
      mergeSortHelper(a, copyBuffer, low, middle);
      mergeSortHelper(a, copyBuffer, middle + 1, high);
      merge(a, copyBuffer, low, middle, high);
    }
  }

  public static void merge(List<Student> a, List<Student> copyBuffer, int low,
    int middle, int high)
  {
    int i1 = low, i2 = middle + 1;
    for (int i = low; i <= high; i++)
    {
      if (a.get(i1).score > a.get(middle).score)
      {
        copyBuffer.set(i, a.get(i2++));
      }
      else if (a.get(i2).score > a.get(high).score)
      {
        copyBuffer.set(i, a.get(i1++));
      }
      else if (a.get(i1).score < a.get(i2).score)
      {
        copyBuffer.set(i, a.get(i1++));
      }
      else
      {
        copyBuffer.set(i, a.get(i2++));
      }
    }

    for (int i = low; i <= high; i++)
      classroom.set(i, copyBuffer.get(i));
  }
}
