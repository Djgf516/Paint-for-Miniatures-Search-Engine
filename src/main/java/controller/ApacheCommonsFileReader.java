package controller;

import models.InfoPaint;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ApacheCommonsFileReader {

    private static CSVParser parser;
    private static CSVPrinter printer;


    public ApacheCommonsFileReader() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Student\\workspace\\Paint-for-Miniatures-Search-Engine\\src\\main\\resources\\Org.Vallejo-Model.csv");
        File matchData = new File("C:\\Users\\Student\\workspace\\Paint-for-Miniatures-Search-Engine\\src\\main\\resources\\MatchDataOriginals.csv");

        //Empty String to hold the information from our file reader
        String line;
        try {
            parser = new CSVParser(new FileReader(file), CSVFormat.DEFAULT);
           // printer = new CSVPrinter(new FileWriter("Out.Vallejo-Model.csv"), CSVFormat.DEFAULT.withHeader("paintId", "Name", "Brand", "hexColorCode", "matchValue"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<CSVRecord> csvRecords = parser.getRecords();
        List<InfoPaint> paintList = new ArrayList<>();

        //Assign values to the InfoPaint class
        for (CSVRecord record : csvRecords) {
            int paintId = Integer.parseInt(record.get(0));
            String paintName = record.get(1);
            String brandName = record.get(2);
            String hexColorCode = record.get(3);

            InfoPaint currentPaint = new InfoPaint(paintId, paintName, brandName, hexColorCode);
            paintList.add(currentPaint);

            // create a new record with the new column
            // printer.printRecord(paintId, paintName, brandName, hexColorCode, matchValue);
        }

        BufferedReader reader = new BufferedReader( new FileReader(matchData));
        while((line = reader.readLine())!=null){

        }



        printer.close();
        parser.close();

    }

    // Replace the value if you find the value.
    public static String replaceLine(InfoPaint currentpaint, String line) {
        if (line.contains(currentpaint.getPaintName())) {
            return line.replace(currentpaint.getPaintName(), String.valueOf(currentpaint.getPaintId()));

        }
        return line;


    }


}
