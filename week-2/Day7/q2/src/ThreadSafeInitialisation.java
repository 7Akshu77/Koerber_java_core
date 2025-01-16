class ThreadSafeInitialiser {
    private static ThreadSafeInitialiser instance = new ThreadSafeInitialiser();

    private ThreadSafeInitialiser() {
    }

    public static ThreadSafeInitialiser getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeInitialiser.class) {
                if (instance == null) {
                    instance = new ThreadSafeInitialiser();
                }
            }
        }
        return instance;
    }

    public void print() {
        System.out.println("singleton thread safe initialisation implemented");
    }
}

public class ThreadSafeInitialisation {
    public static void main(String[] args) {
        ThreadSafeInitialiser instance = ThreadSafeInitialiser.getInstance();
        instance.print();
    }
}
