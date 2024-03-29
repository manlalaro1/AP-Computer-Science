/*
 * Virtual High School
 * Patrick James O'Donnell
 */

/**
 * This class contains class (static) methods that will help you test the
 * Picture class methods. Uncomment the methods and the code in the main to
 * test.
 * 
 * @author Barbara Ericson
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach =
      new Picture(
        "/Users/patrick/Downloads/PictureLab/pixLab/images/beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }

  /** Method to test keepOnlyBlue */
  public static void testKeepOnlyBlue()
  {
    Picture beach =
      new Picture(
        "/Users/patrick/Downloads/PictureLab/pixLab/images/beach.jpg");
    beach.explore();
    beach.keepOnlyBlue();
    beach.explore();
  }

  /** Method to test negate */
  public static void testNegate()
  {
    Picture beach =
      new Picture(
        "/Users/patrick/Downloads/PictureLab/pixLab/images/beach.jpg");
    beach.explore();
    beach.negate();
    beach.explore();
  }

  /** Method to test grayscale */
  public static void testGrayscale()
  {
    Picture beach =
      new Picture(
        "/Users/patrick/Downloads/PictureLab/pixLab/images/beach.jpg");
    beach.explore();
    beach.grayscale();
    beach.explore();
  }

  /** Method to test fixUnderwater */
  public static void testFixUnderwater()
  {
    Picture water =
      new Picture(
        "/Users/patrick/Downloads/PictureLab/pixLab/images/water.jpg");
    water.explore();
    water.fixUnderwater();
    water.explore();
  }

  /** Method to test mirrorVerticalRightToLeft */
  public static void testMirrorVerticalRightToLeft()
  {
    Picture caterpillar =
      new Picture(
        "/Users/patrick/Downloads/PictureLab/pixLab/images/caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVerticalRightToLeft();
    caterpillar.explore();
  }

  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar =
      new Picture(
        "/Users/patrick/Downloads/PictureLab/pixLab/images/caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }

  /** Method to test mirrorHorizontal */
  public static void testMirrorHorizontal()
  {
    Picture redMotorcycle =
      new Picture(
        "/Users/patrick/Downloads/PictureLab/pixLab/images/redMotorcycle.jpg");
    redMotorcycle.explore();
    redMotorcycle.mirrorHorizontal();
    redMotorcycle.explore();
  }
  
  /** Method to test mirrorHorizontalBotToTop */
  public static void testMirrorHorizontalBotToTop()
  {
    Picture redMotorcycle =
      new Picture(
        "/Users/patrick/Downloads/PictureLab/pixLab/images/redMotorcycle.jpg");
    redMotorcycle.explore();
    redMotorcycle.mirrorHorizontalBotToTop();
    redMotorcycle.explore();
  }

  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("/Users/patrick/Downloads/PictureLab/pixLab/images/redMotorcycle.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  public static void testMirrorArms() {
    Picture snowman = new Picture("/Users/patrick/Downloads/PictureLab/pixLab/images/snowman.jpg");
    snowman.explore();
    snowman.mirrorTemple();
    snowman.explore();
  }
  
  public static void testMirrorGull() {
    Picture seagull = new Picture("/Users/patrick/Downloads/PictureLab/pixLab/images/seagull.jpg");
    seagull.explore();
    seagull.mirrorTemple();
    seagull.explore();
  }

  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }

  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }

  /**
   * Main method for testing. Every class can have a main method in Java
   */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    // testZeroBlue();
    // testKeepOnlyBlue();
    // testKeepOnlyRed();
    // testKeepOnlyGreen();
    // testNegate();
    // testGrayscale();
    // testFixUnderwater();
    // testMirrorVerticalRightToLeft();
    // testMirrorVertical();
    // testMirrorHorizontal();
    // testMirrorHorizontalBotToTop();
    // testMirrorTemple();
    testMirrorArms();
    // testMirrorGull();
    // testMirrorDiagonal();
    // testCollage();
    // testCopy();
    // testEdgeDetection();
    // testEdgeDetection2();
    // testChromakey();
    // testEncodeAndDecode();
    // testGetCountRedOverValue(250);
    // testSetRedToHalfValueInTopHalf();
    // testClearBlueOverValue(200);
    // testGetAverageForColumn(0);
  }
}