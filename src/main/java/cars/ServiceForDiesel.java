package cars;

import org.springframework.stereotype.Service;

//4a
@Service
public class ServiceForDiesel {

    //3
   public Engine createEngineDiesel(){
        return new Engine(Engine.type.Diesel);
    }
}
