public class ShaoShuai implements Runnable{

    int x,y;

    Plane plane;
    int time =0;

    public ShaoShuai(int x, int y) {
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
            if(plane!=null&&plane.x>=600){
                time++;
                if(time>4){
                    this.y+=10;
                }

            }

        }


    }
}
