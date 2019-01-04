import java.io.*;

//Simple Buffered Reader
//With an Input Stream and Input Stream BufferedReader

public class SimpleIO {
  public static void main(String[] arg) throws Exception {
    BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
    System.out.println(keyboard.readLine());
  }
}
