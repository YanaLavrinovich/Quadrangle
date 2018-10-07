package by.etc.firsttask.coordinateValidator;

public class CoordinateValidatorImpl implements CoordinateValidator {
    private static final String regex = "((-?\\d+[.]?(\\d+)?)\\s+){7}(-?\\d+[.]?(\\d+)?)";

    @Override
    public boolean isValid(String inputString) {
        if (inputString.matches(regex)) {
            return true;
        } else {
            return false;
        }
    }
}
