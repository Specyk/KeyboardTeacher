import java.io.File;

class FileHelper {

    final private PrintProvider printProvider;
    final private InputProvider inputProvider;

    FileHelper(
            PrintProvider pf,
            InputProvider ip
    ) {
        printProvider = pf;
        inputProvider = ip;
    }

    private String getFilePath(){
        printProvider.println("Podaj ścieżkę do pliku z tekstem:");
        return inputProvider.getInputText();
    }

    File getTextFile(){
        return new File(getFilePath()) ;
    }

    File getTextFile(String filePath){
        return new File(filePath);
    }

}
