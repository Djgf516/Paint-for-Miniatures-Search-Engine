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
        File file = new File("C:\\Users\\Student\\workspace\\Paint-for-Miniatures-Search-Engine\\src\\main\\resources\\PaintDatabasee.csv");
        File matchData = new File("C:\\Users\\Student\\workspace\\Paint-for-Miniatures-Search-Engine\\src\\main\\resources\\CitadelMatchData.csv");

        //Empty String to hold the information from our file reader
        String line;
        CSVParser parser = null;
        CSVPrinter printer = null;
        try {
            parser = new CSVParser(new FileReader(file), CSVFormat.DEFAULT);
            // printer = new CSVPrinter(new FileWriter("Out.Vallejo-Model.csv"), CSVFormat.DEFAULT.withHeader("paintId", "Name", "Brand", "hexColorCode", "matchValue"));

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
                System.out.println("Paint ID: " + paintId + ", Paint Name: " + paintName);
            }

            BufferedReader reader = new BufferedReader(new FileReader(matchData));
            FileWriter outputCSVWriter = new FileWriter("VallejoGameNumbers.csv");
            printer = new CSVPrinter(outputCSVWriter, CSVFormat.DEFAULT);

            while ((line = reader.readLine()) != null) {
                StringBuilder modifiedLine = new StringBuilder(line);
                for (InfoPaint paint : paintList) {
                    modifiedLine = new StringBuilder(replaceLine(paint, modifiedLine.toString()));
                }
                printer.printRecord(modifiedLine.toString());
            }

            reader.close();
            printer.close();


            System.out.println("CSV processing completed successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (parser != null) {
                    parser.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Replace the value if found within the line. String Reader
    public static String replaceLine(InfoPaint currentPaint, String line) {
        String newline = line;
        if (line != null) {
            String paintName = currentPaint.getPaintName();
            if (paintName != null) {
                paintName = paintName.trim(); // Trim leading and trailing spaces
                //
                String[] parts = line.split(",");
                for (int i = 0; i < parts.length; i++) {
                    String smallerPart = parts[i].trim();
                    if (smallerPart.equals(paintName)) {
                        //adds the new value to the string
                        String replacement = String.valueOf(currentPaint.getPaintId());
                        parts[i] = replacement;

                    }

                }
                newline = "";
                for (int i = 0; i < parts.length; i++) {
                    if (i < parts.length - 1) {
                        newline += parts[i] + ",";
                    } else {
                        newline += parts[i];
                    }
                }

            }
        }
        return newline;
    }


//        String paintDatabaseFile = "C:\\Users\\Student\\workspace\\Paint-for-Miniatures-Search-Engine\\src\\main\\resources\\PaintDatabasee.csv";
//        String matchDataFile = "C:\\Users\\Student\\workspace\\Paint-for-Miniatures-Search-Engine\\src\\main\\resources\\VallejoGameMatchData.csv";
//        String outputFile = "VallejoGameNumbers.csv";
//
//        List<InfoPaint> paintList = new ArrayList<>();
//
//        try (BufferedReader paintReader = new BufferedReader(new FileReader(paintDatabaseFile));
//             BufferedReader matchReader = new BufferedReader(new FileReader(matchDataFile));
//             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
//
//            // Read the paint database file and populate the paint list
//            String paintLine;
//            while ((paintLine = paintReader.readLine()) != null) {
//                String[] record = paintLine.split(",");
//                int paintId = Integer.parseInt(record[0]);
//                String paintName = record[1];
//                String brandName = record[2];
//                String hexColorCode = record[3];
//
//                InfoPaint currentPaint = new InfoPaint(paintId, paintName, brandName, hexColorCode);
//                paintList.add(currentPaint);
//            }
//
//            // Process the match data file
//            String matchLine;
//            while ((matchLine = matchReader.readLine()) != null) {
//                for (InfoPaint paint : paintList) {
//                    String paintName = paint.getPaintName();
//                    String paintId = Integer.toString(paint.getPaintId());
//                    matchLine = matchLine.replaceAll("\\b" + paintName + "\\b", paintId);
//                }
//                writer.write(matchLine);
//                writer.newLine();
//            }
//
//            System.out.println("CSV processing completed successfully.");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


}
