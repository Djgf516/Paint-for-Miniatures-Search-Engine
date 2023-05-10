package application;

import models.InfoPaint;
import models.InfoPaint;
import models.ListRelatedPaints;
import ui.*;


import java.util.*;

import static controller.ReadDatabasePaints.readPaintFromCSV;


public class SearchBarDriver {

    public String choice = "";


    //------------------------------------------------------------
    // Start Search bar
    //------------------------------------------------------------
    private List<InfoPaint> infoPaints = readPaintFromCSV("Test.csv");

    private int paintNameCounter = 0;
    private int paintBrandCounter = 0;
    private int paintHexCounter = 0;

    public void run() {
        // let's print all the paint read from CSV file

        while (true) {
            //Welcome the User to the program
            UserInput.displayHomeScreen();

//                for (InfoPaint b : infoPaints) {
//                   System.out.println(b);}

            //Get the user search option
            choice = UserInput.getSearchOption();

            System.out.println(nameSearch(choice));

        }
    }

    public InfoPaint nameSearch(String option) {

        InfoPaint search = null;

        for (InfoPaint currentPaint : infoPaints) {

            //Search the Paint name return 1 value

            if (option.trim().equalsIgnoreCase(currentPaint.getPaintName())) {

                search = currentPaint;
            }

            if (option.trim().equalsIgnoreCase(currentPaint.getBrandName())) {

                search = currentPaint;
            }

        }


        return search;

    }


}






   /* public String thePaintColor() {

        String whiteHexCode = white.getHexColorCode();

        Color.decode(whiteHexCode);

        System.out.println(Color.decode(whiteHexCode));

        return whiteHexCode;

    }*/
