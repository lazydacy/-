public class Plane implements Runnable{
    int x,y;

    public Plane(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(this.x<=600){
                this.x+=20;
            }
        }
    }
}
