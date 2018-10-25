package by.etc.firsttask;

import by.etc.firsttask.creator.QuadrangleCreator;
import by.etc.firsttask.entity.Point;
import by.etc.firsttask.entity.Quadrangle;
import by.etc.firsttask.exception.ReaderFromFileException;
import by.etc.firsttask.parserDouble.ParserDouble;
import by.etc.firsttask.parserDouble.ParserDoubleImpl;
import by.etc.firsttask.readerFromFile.ReaderFromFile;
import by.etc.firsttask.readerFromFile.ReaderFromFileImpl;
import by.etc.firsttask.repository.QuadrangleRepository;
import by.etc.firsttask.storage.QuadrangleStorage;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ReaderFromFile reader = new ReaderFromFileImpl();
        List<String> list = new ArrayList<>();
        try {
            list = reader.read(Paths.get("resources/test1.txt"));
        } catch (ReaderFromFileException e) {
            e.printStackTrace();
        }
        ParserDouble parser = new ParserDoubleImpl();
        List<List<Double>> data = parser.parse(list);
        List<Quadrangle> quadrangleList = new ArrayList<>();
        QuadrangleCreator creator = new QuadrangleCreator();
        QuadrangleStorage storage = QuadrangleStorage.getInstance();
        QuadrangleRepository repository = QuadrangleRepository.getInstance();


        repository.subscribe(storage);


        for(List<Double> current : data) {
            Quadrangle quadrangle = creator.create(current);
            quadrangleList.add(quadrangle);
            repository.add(quadrangle);
            quadrangle.setVertex1(new Point(1,1));
        }
       // Quadrangle quadrangle = repository.getQuadrangles().;
        //repository.remove(quadrangle);
    }
}
