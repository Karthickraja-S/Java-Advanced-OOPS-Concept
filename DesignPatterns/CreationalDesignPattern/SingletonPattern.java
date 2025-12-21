public class SingletonPattern {
    // InMemoryCacheManager
    // DBConnection
    // DownloadManager

    // 1. Restricting multiple object creation since new object request data to DB if not saved in-memory
    private static volatile SingletonPattern pattern = null;
    private SingletonPattern() {}

    // The below code will not work in multithreaded environment. If 2 thread access same time, 2 obj created
//    public static SingletonPattern getPattern() {
//        if(pattern == null) {
//            pattern = new SingletonPattern();
//        }
//        return pattern;
//    }

    // 1) We can put synchronized in method declaration. However it is not optimal
    // what if the obj is already created, multiple thread will wait in queue
    // for the object to be returned right!

    // 2) we can move the method declaration to the block synchronization. still not optimal
    // since only one thread is allowed at a time

    // 3) so, we can do a double check before synchronized block.
    // If multiple threads accessed, then in the if condition itself, all the thread will fail and object
    // will be returned immediately. & the field can be initialised to volatile.
    // volatile usage -> object creation order is maintained
    // ( allocate mem in heap -> construct object -> points memory to variable )

    public  static SingletonPattern getPattern() {
        if(pattern == null) {
            synchronized (SingletonPattern.class) {
                if (pattern == null) {
                    pattern = new SingletonPattern();
                }
            }
        }
        return pattern;
    }
}
