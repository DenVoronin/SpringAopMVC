package cars;


import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@org.springframework.stereotype.Controller
@ResponseBody


public class Controller {

    private final ServiceForAllTypesEngine serviceForAllTypesEngine;
    private final Repository repository;
    @Autowired
    public Controller( ServiceForAllTypesEngine serviceForAllTypesEngine, Repository repository) {
        this.repository=repository;
        this.serviceForAllTypesEngine = serviceForAllTypesEngine;
    }



    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @FuelExceptionHandler()
    public ModelAndView add(@RequestParam String modelName, @RequestParam String  manufacturerName, @RequestParam String engine) throws Exception
    {

        Engine engine1 = serviceForAllTypesEngine.createEngine(engine);
        Car car = new Car(modelName, manufacturerName, engine1.engineType.toString());

         repository.add(car);

       


        return new ModelAndView("/");
    }
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView check(){

        return new ModelAndView("create");
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(Model model){


        model.addAttribute("cars", repository.getAll());
        return new ModelAndView("index");
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
