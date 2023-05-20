package com.paintfinder.MiniaturePaint.dao;

import com.paintfinder.MiniaturePaint.model.InfoPaint;
import java.util.List;

public interface InfoPaintDao {

    List<InfoPaint> findAll();
    List<InfoPaint> findByString(String string);

}
