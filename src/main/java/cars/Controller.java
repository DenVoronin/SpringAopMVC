package cars;


import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller
@ResponseBody


public class Controller {
    private final ServiceForDiesel serviceForDiesel;
    private final ServiceForPetrol serviceForPetrol;
    private final ServiceForAllTypesEngine serviceForAllTypesEngine;
    @Autowired
    public Controller(ServiceForDiesel serviceForDiesel, ServiceForPetrol serviceForPetrol, ServiceForAllTypesEngine serviceForAllTypesEngine) {
        this.serviceForDiesel = serviceForDiesel;
        this.serviceForPetrol = serviceForPetrol;
        this.serviceForAllTypesEngine = serviceForAllTypesEngine;
    }



    @RequestMapping(value = "/", method = RequestMethod.POST)
    @FuelExceptionHandler()
    public String createCar(@RequestParam String engineType, @RequestParam String modelName, @RequestParam String manufacturerName) throws Exception
    {

            Engine engine = serviceForAllTypesEngine.createEngine(engineType);
        Car car = new Car(modelName, manufacturerName, engine.engineType.toString());
        System.out.println(car.toString());
        return engine.powerUp() + "\ncreated: " + car.toString();

           /* if (Engine.type.Diesel.toString().equals(engineType) ) {
                Engine engine = serviceForDiesel.createEngineDiesel();
                Car car = new Car(modelName, manufacturerName, engine.engineType.toString());
                System.out.println(car.toString());
                return engine.powerUp() + "\ncreated: " + car.toString();
            }
            if (Engine.type.Petrol.toString().equals(engineType)) {
                Engine engine = serviceForPetrol.createEnginePetrol();
                Car car = new Car(modelName, manufacturerName, engine.engineType.toString());
                System.out.println(car.toString());
                return engine.powerUp() + "\ncreated: " + car.toString();
            }


        return("not ok");

            */

    }
    @RequestMapping(value = "/check/fuel", method = RequestMethod.GET)
    @FuelExceptionHandler()
    public String checkFuel(@RequestParam String type) throws Exception {
        if (Engine.isFuelAcceptable(type)) {
        return "ok";
        }

        try {
        if (Engine.isFuelAcceptable(type) == false) {
            throw new Exception(); } }
        catch (Exception ex) {
            throw new Exception("This type of engine is incorrect"); }
        return "";
    }


}
