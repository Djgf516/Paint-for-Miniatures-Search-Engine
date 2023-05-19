import models.InfoPaint;
import models.ListRelatedPaints;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

public class PaintSearchBarDriverTest {


    //------------------------------------------------------------
    // Test Items (Before adding in the database)
    //------------------------------------------------------------
    InfoPaint deadWhite = new InfoPaint("Dead White", "Vallejo", "ffffff");
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





}