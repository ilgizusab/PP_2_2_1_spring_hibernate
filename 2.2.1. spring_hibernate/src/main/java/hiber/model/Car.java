package hiber.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private int series;

    @OneToOne(mappedBy = "car")
    private User user;

    public Car(){
    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getSeries() {
        return series;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id;
    }

    @Override
    public int hashCode() {
        int result = (int) this.id;
        result = 31 * result + (this.series != 0 ? this.series : 0);
        result = 31 * result + (this.model != null ? this.model.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Car{" + "id=" + id + ", model=" + model + ", series=" + series + '}';
    }
}
