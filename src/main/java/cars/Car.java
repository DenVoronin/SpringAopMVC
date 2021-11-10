package cars;


import java.util.ArrayList;

public class Car {


    protected int id;
    protected String manufacturerName;
    protected String engine;
    protected String modelName;


    public String getEngine() {
        return engine;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setId(int id) {
        this.id = id;
    }



    Car(String modelName, String manufacturerName, String engine){
        this.engine=engine;
        this.manufacturerName=manufacturerName;
        this.modelName=modelName;
    }

    public int getId() {
        return id;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public String getModelName() {
        return modelName;
    }

    public String toString() {

        return String.join(" ", manufacturerName, modelName, engine);
    }


}
