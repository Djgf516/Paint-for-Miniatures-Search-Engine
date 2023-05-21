package com.paintfinder.MiniaturePaint.dao;

import com.paintfinder.MiniaturePaint.model.InfoPaint;

import java.util.List;

public interface InfoPaintDao {

    List<InfoPaint> findAll();

    List<InfoPaint> findAllByBrand(String brand);

    List<InfoPaint> findByName(String name);

    List<InfoPaint> findByBrand(String brand);

    List<InfoPaint> findByHexColorCode(String hex);

    List<InfoPaint> findMatchesByName(String string);

}
