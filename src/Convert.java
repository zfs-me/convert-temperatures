public class Convert {
    public double convert(String baseUnit, double input, String targetUnit) {
        double tempC = 0.0;
        if(baseUnit.equals("Fahrenheit")) {
            tempC = (input - 32) * 5.0 / 9.0;
        } else if(baseUnit.equals("Kelvin")) {
            tempC = input - 273.15;
        } else { 
            tempC = input;
        }
        if(targetUnit.equals("Fahrenheit")) {
            return tempC * 9.0 / 5.0 + 32;
        } else if(targetUnit.equals("Kelvin")) {
            return tempC + 273.15;
        } else {
            return tempC;
        }
    }
}

