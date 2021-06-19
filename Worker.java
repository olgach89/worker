public class Worker  {

    @FunctionalInterface
    public interface OnTaskDoneListener {
        void onDone(String result);
    }
    private OnTaskDoneListener callback;

    @FunctionalInterface
    public interface OnTaskErrorListener {
        void onError(String result);
    }
    private OnTaskErrorListener errorCallback;

    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }

    public void start() {
        for ( int i = 1; i <= 100; i++ ) {
            if(i == 33){
                errorCallback.onError("Task " + i + " ERROR"  );}
            else {
                callback.onDone( "Task " + i + " is done" );
            }
        }
    }

}
