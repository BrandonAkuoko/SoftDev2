public class NameThread implements Runnable{
    private int index;
    private String name;
    private Thread prev;

    public NameThread(String name, int index){
        this.name = name;
        this.index = index;
    }
    @Override 
    public void run(){
        if(index >= 0){
            Thread prev = new Thread(new NameThread(name, index - 1));
            prev.start(); // JVM spawns a new thread
            if(prev != null){
                try {
                    prev.join();
                } catch (Exception e) {
                    //TODO: handle exception
                }
            }
            System.out.println(name.charAt(index));
        }
    }
    public static void main(String[] args){
        String string = "ABCDEFGHIJ";
        Thread nameThread = new Thread(new NameThread(string,string.length() - 1));
        nameThread.start();
        
    }
    
}
