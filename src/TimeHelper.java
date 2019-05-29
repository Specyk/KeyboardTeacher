class TimeHelper {
    private float getTimeInSeconds(long time){
        return (float) time/1000;
    }

    private long getRunningTime(long beginTime, long endTime){
        return endTime - beginTime;
    }

    float getTypingTime(long beginTime, long endTime){
        return getTimeInSeconds(
            getRunningTime(beginTime, endTime)
        );
    }

}
