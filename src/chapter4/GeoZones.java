package chapter4;

public enum GeoZones {
    NORTH_CENTRAL("benue", "fct", "kogi", "nasarawa", "niger", "plateau"),
    NORTH_EAST("adamawa", "bauchi", "borno", "gombe", "taraba", "yobe"),
    NORTH_WEST("kaduna", "katsina", "kano", "sokoto", "jigawa", "zamfara"),
    SOUTH_SOUTH("Akwa-ibom", "Bayelsa", "Cross-river", "Delta", "Edo", "Rivers"),
    SOUTH_WEST("Ekiti", "Lagos", "Osun", "Ondo", "Ogun", "Oyo"),
    SOUTH_EAST("Abia", "Anambra", "Ebonyi", "Enugu", "Imo");

   private  String [] zone;


    GeoZones(String ... states) {
        this.zone = states;

    }
    public String[] getStates(){
        return zone;
    }

    public String checkState(String state) {
        String northCentral[] = NORTH_CENTRAL.zone;
        String southEast[] = SOUTH_EAST.zone;
        String southSouth[] = SOUTH_SOUTH.zone;
        String [] southWest = SOUTH_WEST.zone;
        String [] northEast = NORTH_EAST.zone;
        String [] northWest = NORTH_WEST.zone;
        for(String states : northCentral){
            if(state.equalsIgnoreCase(states))
                return "You are from North Central.";
        }
        for(String states : southEast){
            if(state.equalsIgnoreCase(states))
                return "You are from South East.";
        }
        for(String states : southSouth){
            if(state.equalsIgnoreCase(states))
                return "You are from South South.";
        }
        for(String states : southWest){
            if(state.equalsIgnoreCase(states))
                return "You are from South West.";
        }
        for(String states : northEast){
            if(state.equalsIgnoreCase(states))
                return "You are from North East.";
        }
        for(String states : northWest){
            if(state.equalsIgnoreCase(states))
                return "You are from North West.";
        }
        return String.format("%s does not Exist as a state in Nigeria.", state);
    }

}
