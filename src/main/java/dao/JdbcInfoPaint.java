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



    @Override
    public List<InfoPaint> findByString(String string) {
        return null;
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
