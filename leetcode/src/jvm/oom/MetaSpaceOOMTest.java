package jvm.oom;

/**
 * @Author JH
 **/
public class MetaSpaceOOMTest {
    static class OOMTest{

    }

    public static void main(String[] args) {
        int i =0;
        try {
            while (true){
                i++;
//                Enhancer enhancer = new Enhancer();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
}
