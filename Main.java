import javax.swing.*;
import java.io.IOException;

public class Main extends JFrame {

    MyPanel mp = null;
    public static void main(String[] args) throws IOException, InterruptedException {
       new Main();
    }
    public Main() throws IOException, InterruptedException {
        mp = new MyPanel();
        Thread thread=new Thread(mp);
        thread.start();
        add(mp);

        setSize(1000,786);
        setTitle("少帅下飞机");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

}