class TextChecker {
    final private InputProvider inputProvider;
    final private PrintProvider printProvider;

    TextChecker(
        InputProvider ip,
        PrintProvider pf
    ) {
        inputProvider = ip;
        printProvider = pf;
    }

    private String findMistakes(String org, String entered){
        StringBuilder errorsText = new StringBuilder(org);
        int i, firstMistakeIndex = -1, numberOfMistakes = 0;

        for (i = 0; i < entered.length(); i++) {
            if (entered.charAt(i) != org.charAt(i)) {
                if (firstMistakeIndex < 0) firstMistakeIndex = i;
                errorsText.setCharAt(i, '#');
                numberOfMistakes++;
            }
        }
        for(int j = i; j<org.length(); j++){
            if (firstMistakeIndex <0) firstMistakeIndex=i;
            errorsText.setCharAt(j, '#');
            numberOfMistakes++;
        }
        printProvider.errorLog(firstMistakeIndex, numberOfMistakes);
        return new String(errorsText);
    }

    void compareTexts(String org, String entered){

        while ( !entered.trim().equals( org.trim() ) ){
            if (entered.length() > 0) {
                printProvider.println(findMistakes(org, entered));
            }else {
                printProvider.println("Wprowadź tekst");
            }
            entered = inputProvider.getInputText();
        }
    }
}
