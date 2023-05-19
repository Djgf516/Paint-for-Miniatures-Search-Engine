package controller;

import models.InfoPaint;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadDatabasePaints {


    //------------------------------------------------------------
    // PlaceHolder
    //------------------------------------------------------------
    File input = new File("Test.csv");
//    public static void main(String... args) {
//        List<InfoPaint> infoPaints = readPaintFromCSV("Test.csv");
//
//        // let's print all the paint read from CSV file
//        for (InfoPaint b : infoPaints) {
//            System.out.println(b);
//        }
//    }


    public static List<InfoPaint> readPaintFromCSV(String fileName) {
        List<InfoPaint> paintList = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        // create an instance of BufferedReader
        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {

            // read the first line from the text file
            String line = br.readLine();

            // loop until all lines are read
            while (line != null) {

                // use string.split to load a string array with the values from
                // each line of
                // the file, using a comma as the delimiter
                String[] attributes = line.split(",");

                if (attributes.length == 19) {

                    // Comparison Paint Column (the other colors are match value is to this one)
                    InfoPaint infoPaint = createInfoPaint(attributes);
                    paintList.add(infoPaint);

                    // First column
                    InfoPaint infoPaintWithMatch = createInfoPaintMatch(attributes);
                    paintList.add(infoPaintWithMatch);

                    // Second Column
                    InfoPaint infoPaintWithMatchTwo = createInfoPaintMatch2(attributes);
                    paintList.add(infoPaintWithMatchTwo);

                    // Third Column
                    InfoPaint infoPaintWithMatchThree = createInfoPaintMatch3(attributes);
                    paintList.add(infoPaintWithMatchThree);

                    // Fourth Column
                    InfoPaint infoPaintWithMatchFour = createInfoPaintMatch4(attributes);
                    paintList.add(infoPaintWithMatchFour);


                }


                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Poorly formated line in input file");

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return paintList;
    }

    private static InfoPaint createInfoPaint(String[] paintData) {
        String namePaint = paintData[0];
        String brandName = paintData[1];
        String hexdecimal = paintData[2];


        // create and return paint of this data
        return new InfoPaint(namePaint, brandName, hexdecimal);
    }

    private static InfoPaint createInfoPaintMatch(String[] paintData) {
        String namePaint = paintData[3];
        String brandName = paintData[4];
        String hexdecimal = paintData[5];
        String matchNumber = paintData[6];


        // create and return paint of this data
        return new InfoPaint(namePaint, brandName, hexdecimal, matchNumber);
    }


    private static InfoPaint createInfoPaintMatch2(String[] paintData) {
        String namePaint = paintData[7];
        String brandName = paintData[8];
        String hexdecimal = paintData[9];
        String matchNumber = paintData[10];


        // create and return paint of this data
        return new InfoPaint(namePaint, brandName, hexdecimal, matchNumber);
    }


    private static InfoPaint createInfoPaintMatch3(String[] paintData) {
        String namePaint = paintData[11];
        String brandName = paintData[12];
        String hexdecimal = paintData[13];
        String matchNumber = paintData[14];


        // create and return book of this metadata
        return new InfoPaint(namePaint, brandName, hexdecimal, matchNumber);
    }

    private static InfoPaint createInfoPaintMatch4(String[] paintData) {
        String namePaint = paintData[15];
        String brandName = paintData[16];
        String hexdecimal = paintData[17];
        String matchNumber = paintData[18];


        // create and return book of this metadata
        return new InfoPaint(namePaint, brandName, hexdecimal, matchNumber);
    }

}



