package cars;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service

public class ServiceForAllTypesEngine {
    public Engine createEngine(String type) throws Exception {
        try {
            if (Engine.isFuelAcceptable(type)) {
                List<cars.Engine.type> list = Arrays.asList(Engine.type.values());
                return new Engine(Engine.type.valueOf(Engine.type.class,
                        list.stream()
                        .filter(e -> {
                            Enum<Engine.type> x = Enum.valueOf(Engine.type.class,type);
                            return e.equals(x);
                        })
                        .findFirst()
                        .get().toString()));
               // return new Engine (Engine.type.valueOf(Engine.type.class,type ));
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception("This type of engine is incorrect");
        }
    } }
