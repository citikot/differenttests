package online.agatstudio.objectmapperjson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class JsonUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper();
//
//    static {
//        // Настройка Jackson для использования полей enum
//        objectMapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
//    }


    public static String objectToJson(Object object) throws Exception {
        return objectMapper.writeValueAsString(object);
    }

    public static List<MyEnum> getMyEnumList() {
        return new ArrayList<>(EnumSet.allOf(MyEnum.class));
    }

    public static void main(String[] args) throws Exception {
        MyEnum[] enumValues = MyEnum.values(); // Получаем все элементы enum

        // Сериализовать массив enumValues в JSON
        String json = JsonUtils.objectToJson(enumValues);

        System.out.println(json);
        System.out.println(getMyEnumList());
    }
}