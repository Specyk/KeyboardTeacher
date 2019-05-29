class Injector {
    private PrintProvider printProvider;
    private InputProvider inputProvider;
    private TextChecker textChecker;
    private FileHelper fileHelper;
    private LessonProvider lessonProvider;
    private KeyboardTeacher keyboardTeacher;
    private TimeHelper timeHelper;

    private PrintProvider getPrintProvider() {
        if (printProvider == null)
            this.printProvider = new PrintProvider(
                getTimeHelper()
            );
        return this.printProvider;
    }

    private InputProvider getInputProvider() {
        if ((inputProvider == null))
            inputProvider = new InputProvider();
        return inputProvider;
    }

    private TextChecker getTextChecker() {
        if(textChecker == null)
            textChecker = new TextChecker(
                    getInputProvider(),
                    getPrintProvider()
            );
        return textChecker;
    }

    private FileHelper getFileHelper() {
        if (fileHelper == null)
            fileHelper = new FileHelper(
                    getPrintProvider(),
                    getInputProvider()
            );
        return fileHelper;
    }

    private LessonProvider getLessonProvider() {
        if (lessonProvider == null)
            lessonProvider = new LessonProvider(
                    getPrintProvider(),
                    getInputProvider(),
                    getTextChecker(),
                    getFileHelper()
            );
        return lessonProvider;
    }

    private TimeHelper getTimeHelper(){
        if (timeHelper == null)
            timeHelper = new TimeHelper();
        return timeHelper;
    }

    KeyboardTeacher getKeyboardTeacher() {
        if (keyboardTeacher == null)
            keyboardTeacher = new KeyboardTeacher(
                    getPrintProvider(),
                    getFileHelper(),
                    getLessonProvider()
            );
        return keyboardTeacher;
    }
}
