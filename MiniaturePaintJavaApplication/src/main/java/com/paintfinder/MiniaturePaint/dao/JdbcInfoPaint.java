package com.paintfinder.MiniaturePaint.dao;

import com.paintfinder.MiniaturePaint.exception.DaoException;
import com.paintfinder.MiniaturePaint.model.InfoPaint;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
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

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                InfoPaint paint = mapRowToInfoPaint(results);
                paints.add(paint);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        }
        return paints;
    }

    //Simple Search by Name
    @Override
    public List<InfoPaint> findByName(String name) {
        List<InfoPaint> paints = new ArrayList<>();
        String sql = "SELECT name, brand, hex_color_code FROM paint WHERE name ILIKE '%' || ? || '%' ORDER BY name LIMIT 25;";
        name = name.trim();
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name);
        try {
            while (results.next()) {
                InfoPaint paint = mapRowToInfoPaint(results);
                paints.add(paint);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        }
        return paints;
    }

    //Search by Brand
    @Override
    public List<InfoPaint> findByBrand(String brand) {
        List<InfoPaint> paints = new ArrayList<>();
        String sql = "SELECT name, brand, hex_color_code FROM paint WHERE brand ILIKE '%' || ? || '%' " +
                "ORDER BY brand LIMIT 25;";
        brand = brand.trim(); // Add wildcard characters to perform a partial match
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, brand);
        try {
            while (results.next()) {
                InfoPaint paint = mapRowToInfoPaint(results);
                paints.add(paint);

            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        }
        return paints;
    }

    @Override
    public List<InfoPaint> findByHexColorCode(String hex) {
        List<InfoPaint> paints = new ArrayList<>();
        String sql = "SELECT name, brand, hex_color_code FROM paint WHERE hex_color_code ILIKE '%' || ? || '%' ORDER BY hex_color_code LIMIT 25;";
        hex = hex.trim(); // Add wildcard characters to perform a partial match

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, hex);
        try {
            while (results.next()) {
                InfoPaint paint = mapRowToInfoPaint(results);
                paints.add(paint);

            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        }
        return paints;
    }

    //This method searches for a specific paint and returns the matches for it. Not a generic Search
    @Override
    public List<InfoPaint> findByString(String string) {
        List<InfoPaint> paints = new ArrayList<>();
        String sql = "SELECT name, brand, hex_color_code " +
                "FROM paint " +
                "WHERE paint_id IN(SELECT match_paint.comparison_paint_id FROM paint JOIN match_paint ON match_paint.base_paint_id = paint.paint_id WHERE paint.name ILIKE ?)" +
                "LIMIT 25;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, string);
        if (results.next()) {
            InfoPaint paint = mapRowToInfoPaint(results);
            paints.add(paint);

        }
        return paints;
    }

    //Used to map our values and read the results
    private InfoPaint mapRowToInfoPaint(SqlRowSet rowSet) {
        InfoPaint paint = new InfoPaint();
        paint.setPaintName(rowSet.getString("name"));
        paint.setBrandName(rowSet.getString("brand"));
        paint.setHexColorCode(rowSet.getString("hex_color_code"));
        return paint;
    }
}
