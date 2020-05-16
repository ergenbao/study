package singleton;

public class Singleton3 {
    private volatile static Singleton3 instance;
      private Singleton3() {

       }

        public static Singleton3 newInstance() {
           if (instance == null) {
                synchronized (Singleton3.class) {
                   if (instance == null) {
                       instance = new Singleton3();
                    }
                }
           }
            return instance;
       }
}
