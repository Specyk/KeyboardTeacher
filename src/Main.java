public class Main {

    public static void main(String... args){

        Injector injector = new Injector();
        Application keyboardTeacher = injector.getKeyboardTeacher();
        keyboardTeacher.run();
    }
}
