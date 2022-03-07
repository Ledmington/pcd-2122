package pcd.demo.bouncingballnet;

public class Visualiser extends Thread {
    
    private final boolean stop;
    private final Context context;
    private final VisualiserFrame frame;
    
    public Visualiser(Context context){
        stop = false;
        this.context = context ;
        frame = new VisualiserFrame(context);
        frame.show();
   }
    
    public void run(){
        while (!stop) {
            frame.updatePosition(context.getPositions());
            //log("update pos");
            try {
                Thread.sleep(20);     
            } catch (Exception ex){
            }
        }
    }
    
    private void log(String msg){
        System.out.println("[VISUALISER] "+msg);
    }

}
