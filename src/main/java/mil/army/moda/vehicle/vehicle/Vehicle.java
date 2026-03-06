package mil.army.moda.vehicle.vehicle;

import jakarta.persistence.*;
import mil.army.moda.vehicle.operator.Operator;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue
    private Long id;

    private String make;
    private String model;
    private int year;
    private int mileage;
    @ManyToOne
    @JoinColumn(name = "operator_id")
    private Operator operator;

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public Vehicle(String make, String model, int year, int mileage, Operator operator) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.operator = operator;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }


}
