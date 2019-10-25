package Users;


public class Timer {

    private long startTime;

    Timer(long startTime){
        this.startTime=startTime;
    }
    public long actualTime(final long actualTime){
        return actualTime-startTime;
    }
    /*public boolean compareTime(Integer expectedTime) {

    }*/

    //TODO implement methods


}
