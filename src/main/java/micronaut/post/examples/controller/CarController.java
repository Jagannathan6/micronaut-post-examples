package micronaut.post.examples.controller;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.validation.Validated;
import micronaut.post.examples.domain.Car;
import micronaut.post.examples.excpetion.PostException;

import javax.validation.Valid;

@Controller("car")
@Validated
public class CarController {

    @Post
    public Car addCars(@Valid @Body Car car) throws PostException {
        if ("RED".equalsIgnoreCase(car.getColor())){
            throw new PostException("Color is Red");
        }
        return car;
    }
}
