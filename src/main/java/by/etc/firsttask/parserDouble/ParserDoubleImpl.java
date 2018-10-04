package by.etc.firsttask.parserDouble;

import by.etc.firsttask.coordinateValidator.CoordinateValidator;
import by.etc.firsttask.coordinateValidator.CoordinateValidatorImpl;

import java.util.ArrayList;
import java.util.List;

public class ParserDoubleImpl implements ParserDouble {
    private CoordinateValidator coordinateValidator;

    private static final String DELIMITER = "\\s+";

    public ParserDoubleImpl() {
        coordinateValidator = new CoordinateValidatorImpl();
    }

    public List<List<Double>> parse(List<String> inputData) {
        List<List<Double>> resultList = new ArrayList<>();
        for(String current : inputData) {
            if(coordinateValidator.isValid(current)) {
                List<Double> line = parse(current);
                resultList.add(line);
            }
        }
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
