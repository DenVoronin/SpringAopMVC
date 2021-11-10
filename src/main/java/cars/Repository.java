package cars;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class Repository {
    ArrayList<Car> cars= new ArrayList<Car>();

    void add(Car car){
        cars.add(car);
    }

    ArrayList<Car> getAll(){

        return cars;
    }
}
