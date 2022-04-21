package preactivity;

public enum Work {
    HW(10), LECTURE(3), SLEEP(5);
    // public Work HW = new Work

    private int workHours;
    private Work(int workHours){
        this.workHours = workHours;
    }
    public int getWorkHours(){
        return workHours;
    }

    
}
