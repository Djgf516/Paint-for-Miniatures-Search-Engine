package dao;

import models.InfoPaint;
import java.util.List;

public interface InfoPaintDao {

    List<InfoPaint> findAll();
    List<InfoPaint> findByString(String string);

}
