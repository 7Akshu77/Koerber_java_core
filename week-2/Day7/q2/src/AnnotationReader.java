import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

public class AnnotationReader {

    public static void readAnnotations(AnnotatedElement element) {

        Annotation[] annotations = element.getAnnotations();


        for (Annotation annotation : annotations) {
            if (annotation instanceof Author) {
                Author author = (Author) annotation;
                System.out.println("Author: " + author.name());
            } else if (annotation instanceof Version) {
                Version version = (Version) annotation;
                System.out.println("Version: " + version.number());
            }
        }
    }

    public static void main(String[] args) {
        try {

            Class<?> cls = AnnotatioMethod.AnnotatedClass.class;
            System.out.println("Class Annotations:");
            readAnnotations(cls);

            
            for (Method method : cls.getDeclaredMethods()) {
                System.out.println("\nMethod: " + method.getName());
                readAnnotations(method);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
