interface TrafficLightState {
    void display();
    void changeState(TrafficLight trafficLight);
}

class RedState implements TrafficLightState {
    @Override
    public void display() {
        System.out.println("Traffic light is displaying RED");
    }

    @Override
    public void changeState(TrafficLight trafficLight) {
        System.out.println("Changing state from RED to GREEN");
        trafficLight.setState(new GreenState());
        System.out.println();
    }
}

class GreenState implements TrafficLightState {
    @Override
    public void display() {
        System.out.println("Traffic light is displaying GREEN");
    }

    @Override
    public void changeState(TrafficLight trafficLight) {
        System.out.println("Changing state from GREEN to YELLOW");
        trafficLight.setState(new YellowState());
        System.out.println();
    }
}

class YellowState implements TrafficLightState {
    @Override
    public void display() {
        System.out.println("Traffic light is displaying YELLOW");
    }

    @Override
    public void changeState(TrafficLight trafficLight) {
        System.out.println("Changing state from YELLOW to RED");
        trafficLight.setState(new RedState());
        System.out.println();
    }
}

class TrafficLight {
    private TrafficLightState currentState;

    public TrafficLight() {
        currentState = new RedState();
    }

    public void setState(TrafficLightState state) {
        currentState = state;
    }

    public void display() {
        currentState.display();
    }

    public void changeState() {
        currentState.changeState(this);
    }
}

public class TrafficLightStateDemo {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();

        trafficLight.display();

        trafficLight.changeState();
        trafficLight.display();

        trafficLight.changeState();
        trafficLight.display();

        trafficLight.changeState();
        trafficLight.display();
    }
}