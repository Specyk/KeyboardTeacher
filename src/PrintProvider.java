import java.io.PrintWriter;

class PrintProvider {
    final private TimeHelper timeHelper;

    PrintProvider(
            TimeHelper th
    ){
        timeHelper = th;
    }

    private final static PrintWriter PW = new PrintWriter(System.out, true);

    void divider(){
        for (int i=0; i<64; i++){
            PW.print('-');
        }
        PW.println();
    }

    void println(String s){
        PW.println(s);
    }

    void welcome(){
        PW.println("Witaj w KeyboardTeacher!");
    }

    void congratulations(long beginTimeStamp, long endTimeStamp){
        float timeInSeconds = timeHelper.getTypingTime(beginTimeStamp, endTimeStamp);
        PW.println("Gratulacje! Czas działania programu to " + timeInSeconds + "s");
    }

    void errorLog(int firstMistakeIndex, int numberOfMistakes){
        PW.println("Błędnie przepisany tekst. Indeks pierwszego błędu: " + firstMistakeIndex + " | Liczba błędów: " + numberOfMistakes);
    }

    void oneLineTime(long beginTimeStamp, long endTimeStamp){
        float time = timeHelper.getTypingTime(beginTimeStamp, endTimeStamp);

        PW.print("-----------");
        PW.print("Czas: " + time + "s");
        PW.println();
    }
}
