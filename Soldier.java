public class Soldier implements Runnable{
    int x,y;
    ShaoShuai shaoShuai;

    public Soldier(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if(shaoShuai != null&&shaoShuai.y>=120){
                this.y+=10;
            }
        }
    }
}
