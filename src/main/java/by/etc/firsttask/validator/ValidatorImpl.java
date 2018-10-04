package by.etc.firsttask.validator;

public class ValidatorImpl implements Validator {
    private static final String regex = "(\\d+\\s+){15}\\d+";
    //предусмотреть, что точки лежат на одной линии
    //добавить отрицательные точки
    public boolean validList(String stringFromFile) {
        return stringFromFile.matches(regex);
    }
}
