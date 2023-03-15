class Airplane {
    private String type;
    private String model;
    private String engine;

    public void setType(String type) {
        this.type = type;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "type='" + type + '\'' +
                ", model='" + model + '\'' +
                ", engine='" + engine + '\'' +
                '}';
    }
}

abstract class AirplaneBuilder {
    protected Airplane airplane;

    public Airplane getAirplane() {
        return airplane;
    }

    public void createAirplane() {
        airplane = new Airplane();
    }

    public abstract void buildType();
    public abstract void buildModel();
    public abstract void buildEngine();
}


class CropDuster extends AirplaneBuilder {
    @Override
    public void buildType() {
        airplane.setType("Crop Duster");
    }

    @Override
    public void buildModel() {
        airplane.setModel("Model X");
    }

    @Override
    public void buildEngine() {
        airplane.setEngine("Turbo Prop");
    }
}


class FighterJet extends AirplaneBuilder {
    @Override
    public void buildType() {
        airplane.setType("Fighter Jet");
    }

    @Override
    public void buildModel() {
        airplane.setModel("F-16");
    }

    @Override
    public void buildEngine() {
        airplane.setEngine("Afterburner");
    }
}


class Glider extends AirplaneBuilder {
    @Override
    public void buildType() {
        airplane.setType("Glider");
    }

    @Override
    public void buildModel() {
        airplane.setModel("Model Y");
    }

    @Override
    public void buildEngine() {
        airplane.setEngine("None");
    }
}


class Airliner extends AirplaneBuilder {
    @Override
    public void buildType() {
        airplane.setType("Airliner");
    }

    @Override
    public void buildModel() {
        airplane.setModel("Boeing 747");
    }

    @Override
    public void buildEngine() {
        airplane.setEngine("Jet");
    }
}


class AerospaceEngineer {
    private AirplaneBuilder airplaneBuilder;

    public void setAirplaneBuilder(AirplaneBuilder airplaneBuilder) {
        this.airplaneBuilder = airplaneBuilder;
    }

    public Airplane getAirplane() {
        return airplaneBuilder.getAirplane();
    }

    public void constructAirplane() {
        airplaneBuilder.createAirplane();
        airplaneBuilder.buildType();
        airplaneBuilder.buildModel();
        airplaneBuilder.buildEngine();
    }
}


public class Airplane_Builder {
    public static void main(String[] args) {
        AerospaceEngineer aerospaceEngineer = new AerospaceEngineer();
        AirplaneBuilder cropDuster = new CropDuster();
        aerospaceEngineer.setAirplaneBuilder(cropDuster);
        aerospaceEngineer.constructAirplane();
        Airplane airplane1 = aerospaceEngineer.getAirplane();
        System.out.println("Airplane 1: " + airplane1);
        AirplaneBuilder fighterJet = new FighterJet();
        aerospaceEngineer.setAirplaneBuilder(fighterJet);
        aerospaceEngineer.constructAirplane();
        Airplane airplane2 = aerospaceEngineer.getAirplane();
        System.out.println("Airplane 2: " + airplane2);
        AirplaneBuilder glider = new Glider();
        aerospaceEngineer.setAirplaneBuilder(glider);
        aerospaceEngineer.constructAirplane();
        Airplane airplane3 = aerospaceEngineer.getAirplane();
        System.out.println("Airplane 3: " + airplane3);
        AirplaneBuilder airliner = new Airliner();
        aerospaceEngineer.setAirplaneBuilder(airliner);
        aerospaceEngineer.constructAirplane();
        Airplane airplane4 = aerospaceEngineer.getAirplane();
        System.out.println("Airplane 4: " + airplane4);
    }
}