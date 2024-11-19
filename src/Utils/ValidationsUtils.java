package Utils;

import java.util.List;

public class ValidationsUtils {
    public static <T> void validateNotNull(T obj, String message ) {
        if (obj == null) throw new IllegalArgumentException(message);
    }

    public static <T> void validateExistsInList(T obj, List<T> list, String message){
        if (!list.contains(obj)) throw new IllegalArgumentException(message);
    }

    public static <T> boolean validateIsNotEmpty(List<T> list){
       return list.isEmpty();
    }
}
