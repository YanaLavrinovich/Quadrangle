package by.etc.firsttask.coordinateValidator;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CoordinateValidatorImpl implements CoordinateValidator {
    private static final String regex = "((\\d+[.]?(\\d+)?)\\s+){7}(\\d+[.]?(\\d+)?)";
    private static final Logger LOGGER = LogManager.getLogger(CoordinateValidatorImpl.class.getName());

    @Override
    public boolean isValid(String inputString) {
        if (inputString.matches(regex)) {
            LOGGER.info("String is valid");
            return true;
        } else {
            LOGGER.info("String isn't valid");
            return false;
        }
    }
}
