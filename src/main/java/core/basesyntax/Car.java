package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = getWheelCopy(wheels);
        this.engine = engineNotNull(engine);
    }

    @Override
    public String toString() {
        return "Car{"
                + "year=" + year
                + ", color='" + color + '\''
                + ", wheels=" + wheels
                + ", engine=" + engine
                + '}';
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getWheelCopy(wheels);
    }

    public Engine getEngine() {
        return engineNotNull(engine);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return year == car.year && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    private Engine engineNotNull(Engine newEngine) {
        if (newEngine == null) {
            return null;
        } else {
            return newEngine.clone();
        }
    }

    private List<Wheel> getWheelCopy(List<Wheel> listWheel) {
        List<Wheel> copyWheel = new ArrayList<>();
        for (Wheel wheel : listWheel) {
            copyWheel.add(wheel.clone());
        }
        return copyWheel;
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> wheelList = getWheelCopy(wheels);
        wheelList.add(newWheel);
        return new Car(year, color, wheelList, engine);
    }
}
