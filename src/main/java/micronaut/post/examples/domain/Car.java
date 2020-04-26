package micronaut.post.examples.domain;



import io.micronaut.core.annotation.Introspected;

import javax.validation.constraints.NotBlank;

@Introspected
public class Car {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @NotBlank(message = "Car name is mandatory")
    private String name;

    @NotBlank(message = "Car Color is mandatory")
    private String color;
}
