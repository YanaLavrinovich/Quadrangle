package by.etc.firsttask.parserDouble;

import by.etc.firsttask.coordinateValidator.CoordinateValidator;
import by.etc.firsttask.coordinateValidator.CoordinateValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ParserDoubleImpl implements ParserDouble {
    private CoordinateValidator coordinateValidator;

    private static final String DELIMITER = "\\s+";

    private static final Logger LOGGER = LogManager.getLogger(ParserDouble.class.getName());

    public ParserDoubleImpl() {
        coordinateValidator = new CoordinateValidatorImpl();
    }

    @Override
    public List<List<Double>> parse(List<String> inputData) {
        List<List<Double>> resultList = new ArrayList<>();
        for(String current : inputData) {
            current = current.trim();
            if(coordinateValidator.isValid(current)) {
                List<Double> line = parse(current);
                resultList.add(line);
            }
        }
        LOGGER.info("Parsing input data is done");
        return resultList;
    }

    private List<Double> parse(String data) {
        String[] numbers= data.split(DELIMITER);
        List<Double> resultArray = new ArrayList<>();
        for(String currentNumber : numbers) {
            resultArray.add(Double.parseDouble(currentNumber));
        }
        return resultArray;
    }
}
