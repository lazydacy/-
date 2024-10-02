import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MyPanel extends JPanel  implements Runnable{
    Soldier soldier01;
    Soldier soldier02;
    Plane plane;
    ShaoShuai shaoShuai;
    Image image01;
    Image image02;
    Image shaoPng;
    Image planePng;
    //初始化
    public MyPanel() throws IOException, InterruptedException {
        plane =new Plane(0,0);
        Thread thread01 = new Thread(plane);
        thread01.start();
        shaoShuai=new ShaoShuai(700,100);
        shaoShuai.plane=plane;
        Thread thread02 = new Thread(shaoShuai);
        thread02.start();
        soldier01=new Soldier(650,120);
        soldier01.shaoShuai=shaoShuai;
        Thread thread03 = new Thread(soldier01);
        thread03.start();
        soldier02=new Soldier(750,120);
        soldier02.shaoShuai=shaoShuai;
        Thread thread04 = new Thread(soldier02);
        thread04.start();



        MediaTracker tracker = new MediaTracker(this);
        image01=Toolkit.getDefaultToolkit().getImage(getClass().getResource("soldier01.png"));
        tracker.addImage(image01, 0);
        tracker.waitForAll();
        image02=Toolkit.getDefaultToolkit().getImage(getClass().getResource("soldier02.png"));
        tracker.addImage(image02, 0);
        tracker.waitForAll();
        shaoPng=Toolkit.getDefaultToolkit().getImage(getClass().getResource("shaoShuai.png"));
        tracker.addImage(shaoPng, 0);
        tracker.waitForAll();
        planePng=Toolkit.getDefaultToolkit().getImage(getClass().getResource("plane01.jpg"));
        tracker.addImage(planePng, 0);
        tracker.waitForAll();

    }

    public  void paint(Graphics g){
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);
        g.drawImage(planePng,plane.x,plane.y,200,100,this);
        g.drawImage(image01,soldier01.x,soldier01.y,40,50,this);
        g.drawImage(image02,soldier02.x,soldier02.y,40,50,this);
        if(plane.x>=600){
            g.drawImage(shaoPng,shaoShuai.x,shaoShuai.y,40,50,this);
        }



    }


    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(10);
                this.repaint();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
