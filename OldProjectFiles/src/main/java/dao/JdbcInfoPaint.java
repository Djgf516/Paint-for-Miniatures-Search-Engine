package dao;

import models.InfoPaint;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcInfoPaint implements InfoPaintDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcInfoPaint(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //Just for testing purposes
    @Override
    public List<InfoPaint> findAll() {
        List<InfoPaint> paints = new ArrayList<>();
        String sql = "SELECT name, brand, hex_color_code FROM paint ORDER BY name LIMIT 25;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            InfoPaint paint = mapRowToInfoPaint(results);
            paints.add(paint);
        }
        return paints;
    }

    //Method will only search by the paint name, we will add seperate code to search by hex-code or brand
    @Override
    public List<InfoPaint> findByString(String string) {
        List<InfoPaint> paints = new ArrayList<>();
        String sql = "SELECT name, brand, hex_color_code " +
                "FROM paint " +
                "WHERE paint_id IN(SELECT match_paint.comparison_paint_id " +
                "FROM paint " +
                "JOIN match_paint ON match_paint.base_paint_id = paint.paint_id " +
                "WHERE paint.name ILIKE ?)" +
                "LIMIT 25;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, string);
        if (results.next()){
            InfoPaint paint =mapRowToInfoPaint(results);
            paints.add(paint);

        }
       return paints;
    }

    private InfoPaint mapRowToInfoPaint(SqlRowSet rowSet) {
        InfoPaint paint = new InfoPaint();
        paint.setPaintId(rowSet.getInt("paint_id"));
        paint.setPaintName(rowSet.getString("name"));
        paint.setBrandName(rowSet.getString("brand"));
        paint.setHexColorCode(rowSet.getString("hex_color_code"));
        return paint;
    }
}
