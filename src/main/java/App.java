

import java.io.IOException;
import java.text.ParseException;

import controller.Controller;
import ui.UI;

public class App {

    public static void main(String[] args) throws IOException, ParseException {
        Controller ctrl = new Controller("students.txt", "laboratories.txt");
    	UI view  = new UI(ctrl);

        try {
            view.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}