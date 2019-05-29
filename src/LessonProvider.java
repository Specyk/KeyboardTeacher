import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class LessonProvider
{
    final private PrintProvider printProvider;
    final private InputProvider inputProvider;
    final private TextChecker textChecker;
    final private FileHelper fileHelper;

    LessonProvider(
        PrintProvider pf,
        InputProvider ip,
        TextChecker tc,
        FileHelper fh
    ){
        printProvider = pf;
        inputProvider = ip;
        textChecker = tc;
        fileHelper = fh;
    }

    void startLesson(File file){
        try ( Scanner textScanner = new Scanner(file) ) {
            String originalTextLine;

            printProvider.divider();
            while (textScanner.hasNextLine()) {
                originalTextLine = textScanner.nextLine();
                goToNextLine(originalTextLine);
            }
        } catch(FileNotFoundException e) {
            printProvider.println("Nie znaleziono pliku.");
            startLesson(fileHelper.getTextFile());
        }
    }

    private void goToNextLine(String textLine){

        printProvider.println(textLine);

        long beginTimeStamp = System.currentTimeMillis();

        String enteredTextLine = inputProvider.getInputText();
        textChecker.compareTexts(textLine, enteredTextLine);

        long endTimeStamp = System.currentTimeMillis();

        printProvider.oneLineTime(beginTimeStamp, endTimeStamp);
    }
}
