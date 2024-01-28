package base.util;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class DataProviders {
    @DataProvider(name = "products list")
        public Object[][] getProducts(){
            return new Object[][]{
                    {"bike-light"},
                    {"onesie"}
            };
        }

    @DataProvider(name = "invalidLoginParameters")
    public Object[][] readInvalidLoginParameters(){
        try {
            CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/invalidLoginParameters.csv"));
            List<String[]> csvData = csvReader.readAll();
            Object[][] csvDataObj = new Object[csvData.size()][2];
            for (int i = 0;i < csvData.size();i++){
                csvDataObj[i] = csvData.get(i);
            }
            return csvDataObj;

        }catch (IOException e){
            System.out.println(e);
            return null;
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
    }
}
