import java.util.Scanner;

class InputProvider {
    final private Scanner SCAN = new Scanner(System.in);

    String getInputText(){
        return SCAN.nextLine();
    }
}
