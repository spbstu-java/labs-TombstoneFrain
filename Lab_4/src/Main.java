import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args)
    {
        for (Method m : TestAnnotation.class.getDeclaredMethods()) {
            Annotation annotation = m.getAnnotation(CallCountParam.class);
            CallCountParam countParam = (CallCountParam) annotation;
            if (countParam != null) {
                m.setAccessible(true);
                for (int i = 0; i < countParam.CallCount(); i++) {
                    try {
                        m.invoke(null);
                    }
                    catch(InvocationTargetException ite){
                        System.out.println(ite.getCause());
                    }
                    catch(IllegalAccessException iae){
                        System.out.println(iae.getMessage());
                    }
                }
                System.out.println();
            }
        }
    }
}