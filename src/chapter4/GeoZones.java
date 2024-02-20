package chapter4;

public enum GeoZones {
    NORTH_CENTRAL("benue", "fct", "kogi", "nasarawa", "niger", "plateau"),
    NORTH_EAST("adamawa", "bauchi", "borno", "gombe", "taraba", "yobe"),
    NORTH_WEST("kaduna", "katsina", "kano", "sokoto", "jigawa", "zamfara"),
    SOUTH_SOUTH("Akwa-ibom", "Bayelsa", "Cross-river", "Delta", "Edo", "Rivers"),
    SOUTH_WEST("Ekiti", "Lagos", "Osun", "Ondo", "Ogun", "Oyo"),
    SOUTH_EAST("Abia", "Anambra", "Ebonyi", "Enugu", "Imo");

   private final String [] zone;


    GeoZones(String ... states) {
        this.zone = states;

    }
    public String[] getStates(){
        return zone;
    }

    public String checkState(String state) {
        for(String states : NORTH_CENTRAL.zone){
            if(state.equalsIgnoreCase(states))
                return "You are from North Central.";
        }
        for(String states : SOUTH_EAST.zone){
            if(state.equalsIgnoreCase(states))
                return "You are from South East.";
        }
        for(String states : SOUTH_SOUTH.zone){
            if(state.equalsIgnoreCase(states))
                return "You are from South South.";
        }
        for(String states : SOUTH_WEST.zone){
            if(state.equalsIgnoreCase(states))
                return "You are from South West.";
        }
        for(String states : NORTH_EAST.zone){
            if(state.equalsIgnoreCase(states))
                return "You are from North East.";
        }
        for(String states : NORTH_WEST.zone){
            if(state.equalsIgnoreCase(states))
                return "You are from North West.";
        }
        return String.format("%s does not Exist as a state in Nigeria.", state);
    }

}
