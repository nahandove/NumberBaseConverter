package converter;

public class Main {
    static Converter converter = new Converter();

    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu() {
        String answer = "";
        while (true) {
            ConsoleHelper.writeMessage("Enter two numbers in format: {source base} {target base} (To quit type /exit) ");
            answer = ConsoleHelper.readString();
            if ("/exit".equals(answer)) {
                System.exit(0);
            }
            converter.openMenu(answer);
        }
    }
}
