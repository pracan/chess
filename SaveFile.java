import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;  // Import the IOException class to handle errors

public class SaveFile {
  public SaveFile(String name) {
    try {
      File myObj = new File(name+".txt");
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
      } else {
        System.out.println("File already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  public void WriteToFile(Piece[][] board, String name) {
    try {
      FileWriter myWriter = new FileWriter(name+".txt");
      for (int i = 0; i <= 7; i++) {
        for (int v = 0; v <= 7; v++) {
          if(v!=0){myWriter.write(" ");}
          if(board[i][v].getType()!=0){
          if(board[i][v].getIsWhite()){
            myWriter.write("W");
          } else {myWriter.write("B");}}
          switch(board[i][v].getType()) {
            case 1:
                myWriter.write("P");
              break;
            case 2:
                myWriter.write("R");
              break;
            case 3:
                myWriter.write("B");
              break;
            case 4:
                myWriter.write("N");
              break;
            case 5:
                myWriter.write("Q");
              break;
            case 6:
                myWriter.write("K");
              break;
            default:
              myWriter.write("  ");
          }
        }
        myWriter.write("\n");
      }
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  public Board recover(String name) {
    Board board = new Board();
    try {
      File myObj = new File(name+".txt");
      Scanner myReader = new Scanner(myObj);
      for (int i = 0; i <= 7; i++) {
        String data = myReader.nextLine();
        for (int v = 0; v <= 7; v++) {
          char color = data.charAt(0+v);
          char pawn = data.charAt(1+v);
        }
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    return board;
  }
}