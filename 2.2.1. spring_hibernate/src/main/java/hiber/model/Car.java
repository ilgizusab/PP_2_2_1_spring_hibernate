package hiber.model;

import javax.persistence.*;

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
    public String toString() {
        return "Car{" + "id=" + id + ", model=" + model + ", series=" + series + '}';
    }
}