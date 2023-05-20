package com.paintfinder.MiniaturePaint.model;

import java.util.List;

public class ListRelatedPaints extends InfoPaint  {

    public String paintName;

    public List<InfoPaint> listOfRelatedPaints = null;


    public ListRelatedPaints(String paintName, List<InfoPaint> listOfRelatedPaints) {
        super(paintName);
        this.listOfRelatedPaints = listOfRelatedPaints;
    }

    @Override
    public String getPaintName() {
        return paintName;
    }

    @Override
    public void setPaintName(String paintName) {
        this.paintName = paintName;
    }

    public List<InfoPaint> getListOfRelatedPaints() {
        return listOfRelatedPaints;
    }

    public void setListOfRelatedPaints(List<InfoPaint> listOfRelatedPaints) {
        this.listOfRelatedPaints = listOfRelatedPaints;
    }

    @Override
    public String toString() {
        return "ListRelatedPaints{" +
                "paintName='" + paintName + '\'' +
                ", listOfRelatedPaints=" + listOfRelatedPaints +
                '}';
    }
}
