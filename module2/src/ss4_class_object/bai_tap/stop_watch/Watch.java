package ss4_class_object.bai_tap.stop_watch;


public class Watch {
    private long startTime, endTime;

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void start(long startTime){
        this.startTime = startTime;
    }

    public void stop(long endTime){
        this.endTime = endTime;
    }

    public long getElapsedTime(){
        return getEndTime() - getStartTime();
    }

}
