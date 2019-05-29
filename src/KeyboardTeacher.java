import java.io.*;

class KeyboardTeacher implements Application{
    final private PrintProvider printProvider;
    final private FileHelper fileHelper;
    final private LessonProvider lessonProvider;

    KeyboardTeacher(
        PrintProvider pf,
        FileHelper fh,
        LessonProvider lp
    ) {
        printProvider = pf;
        fileHelper = fh;
        lessonProvider = lp;
    }

    @Override
    public void run(String... args) {
        long startTime = System.currentTimeMillis();

        printProvider.welcome();
        File textFile = (args.length == 1) ? fileHelper.getTextFile(args[0]) : fileHelper.getTextFile();
        lessonProvider.startLesson(textFile);
        printProvider.divider();

        long endTime = System.currentTimeMillis();
        printProvider.congratulations(startTime, endTime);
    }
}
