package controller;

import models.InfoPaint;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApacheCommonsFileReader {

    private static CSVParser parser;
    private static CSVPrinter printer;



    public ApacheCommonsFileReader() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Student\\workspace\\Paint-for-Miniatures-Search-Engine\\src\\main\\resources\\Org.Vallejo-Model.csv");
        try {
            parser = new CSVParser(new FileReader( file), CSVFormat.DEFAULT);
            printer = new CSVPrinter(new FileWriter("Out.Vallejo-Model.csv"), CSVFormat.DEFAULT.withHeader("paintId", "Name", "Brand", "hexColorCode", "matchValue"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<CSVRecord> csvRecords = parser.getRecords();
        List<InfoPaint> paintList = new ArrayList<>();


        for (CSVRecord record : csvRecords) {

            String paintName = record.get(0);
            String brandName = record.get(1);
            String hexColorCode = record.get(2);
            String matchValue = record.get(3);

            InfoPaint currentPaint = new InfoPaint(paintName,brandName,hexColorCode,matchValue);
            paintList.add(currentPaint);

            String paintId = Integer.toString(currentPaint.getPaintId());

            // create a new record with the new column
            printer.printRecord(paintId, paintName, brandName, hexColorCode, matchValue);
        }

        printer.close();
        parser.close();

    }

}
