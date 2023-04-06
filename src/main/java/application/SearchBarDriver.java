package application;

import models.InfoPaint;
import models.InfoPaint;
import models.ListRelatedPaints;
import ui.*;


import java.util.*;





public class SearchBarDriver {

    public String choice = "";


    //------------------------------------------------------------
    // Test Items (Before adding in the database)
    //------------------------------------------------------------
    InfoPaint deadWhite = new InfoPaint("Dead White","Vallejo", "ffffff");
    InfoPaint white = new InfoPaint("White", "Vallejo - Model", "ffffff");
    InfoPaint whiteScar = new InfoPaint("White Scar ", "Citadel", "ffffff");
    InfoPaint morrowWhite = new InfoPaint("Morrow White", "P3 Formula", "FEFBFD");
    InfoPaint mattWhite = new InfoPaint("Matt White", "Army Painter", "ffffff");


    List<InfoPaint> listDeadWhite = new ArrayList() {{
        add(white);
        add(whiteScar);
        add(morrowWhite);
        add(mattWhite);
    }};

    List<InfoPaint> listWhite = new ArrayList() {{
        add(deadWhite);
        add(whiteScar);
        add(morrowWhite);
        add(mattWhite);
    }};

    List<InfoPaint> listWhiteScar = new ArrayList() {{
        add(deadWhite);
        add(white);
        add(morrowWhite);
        add(mattWhite);
    }};



    ListRelatedPaints deadWhiteRelatedPaints = new ListRelatedPaints(deadWhite.getPaintName(), listDeadWhite);
    ListRelatedPaints whiteRelatedPaints = new ListRelatedPaints(white.getPaintName(), listWhite);
    ListRelatedPaints whiteScareRelatedPaints = new ListRelatedPaints(whiteScar.getPaintName(), listWhiteScar);




    //------------------------------------------------------------
    // Start Search bar
    //------------------------------------------------------------

    public void run(){



        while (true){
            //Welcome the User to the program
            UserInput.displayHomeScreen();

            //Get the user search option
            choice = UserInput.getSearchOption();

            System.out.println( nameSearch(choice));


        }
    }

    public ListRelatedPaints nameSearch (String option) {

        ListRelatedPaints search = null;


      if (option.trim().equalsIgnoreCase(deadWhite.getPaintName())){

          search= deadWhiteRelatedPaints;
        }


        return deadWhiteRelatedPaints;

    }








}





   /* public String thePaintColor() {

        String whiteHexCode = white.getHexColorCode();

        Color.decode(whiteHexCode);

        System.out.println(Color.decode(whiteHexCode));

        return whiteHexCode;

    }*/
