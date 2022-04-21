public class Deadlock extends Thread{
    private final String name;
    private final String locka;
    private final String lockb;

    public Deadlock(String name, String locka, String lockb){
        this.name = name;
        this.locka = locka;
        this.lockb = lockb;
    }
    @Override
    public void run() {
        System.out.println(name + " is trying to acquire first lock");
        synchronized(locka){
            System.out.println(name + " acquired first lock "+ locka);
            System.out.println(name + " is trying to acquire second lock " + lockb);
            synchronized(lockb){
                System.out.println(name + " acquired both locks ");
                System.out.println(name + " releases second lock " + lockb);
            }
            System.out.println(name + " releases first lock" + locka);
        }
    }
    
    public static void main(String[] args) {
        String locka = "A";
        String lockb = "B";
        Thread thread = new Deadlock("thread1", locka, lockb);
        thread.start();
    }
}
