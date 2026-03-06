package mil.army.moda.vehicle.operator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Operator {
    @Id
    @GeneratedValue
    private Long Id;

    private String name;
    private int age;

    public Operator(String name, int age) {

        this.name = name;
        this.age = age;
    }


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
