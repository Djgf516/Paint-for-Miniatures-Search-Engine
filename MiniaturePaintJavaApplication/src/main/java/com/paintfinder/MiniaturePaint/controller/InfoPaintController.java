package com.paintfinder.MiniaturePaint.controller;

import com.paintfinder.MiniaturePaint.dao.InfoPaintDao;
import com.paintfinder.MiniaturePaint.model.InfoPaint;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/paint")
public class InfoPaintController {
    private InfoPaintDao infoPaintDao;

    public InfoPaintController(InfoPaintDao infoPaintDao) {
        this.infoPaintDao = infoPaintDao;
    }

    @GetMapping(value = "/all")
    public List<InfoPaint> findAllPaints() {
        try {
            return infoPaintDao.findAll();
        } catch (CannotGetJdbcConnectionException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "SQL syntax error", e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred", e);
        }
    }

    @GetMapping("/paints")
    public List<InfoPaint> searchPaintsByName(@RequestParam("search-name") String name) {
        try {
            List<InfoPaint> paints = infoPaintDao.findByName(name);
            if (paints.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No paints found matching the search criteria.");
            }
            return paints;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred during the search.", e);
        }
    }

    @GetMapping("/brands")
    public List<InfoPaint> searchPaintsByBrand(@RequestParam("search-brand") String brand) {
        try {
            List<InfoPaint> paints = infoPaintDao.findByBrand(brand);
            if (paints.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No paints found matching the search criteria.");
            }
            return paints;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred during the search.", e);
        }
    }

    @GetMapping("/hex-color")
    public List<InfoPaint> searchPaintsByHexCode(@RequestParam("search-code") String hexCode) {
        try {
            List<InfoPaint> paints = infoPaintDao.findByHexColorCode(hexCode);
            if (paints.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No paints found matching the search criteria.");
            }
            return paints;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred during the search.", e);
        }
    }

//    @GetMapping
//    public List<InfoPaint> searchPaints(@RequestParam("query") String query) {
//        List<InfoPaint> paints = new ArrayList<>();
//
//        // Check if the query contains a comma
//        if (query.contains(",")) {
//            // Split the query into two parts: paint name and brand name
//            String[] parts = query.split(",", 2);
//            String paintName = parts[0].trim();
//            String brandName = parts[1].trim();
//
//            // Search for paints by both name and brand
//            List<InfoPaint> paintsByName = infoPaintDao.findByName(paintName);
//            List<InfoPaint> paintsByBrand = infoPaintDao.findByBrand(brandName);
//
//            // Combine the search results
//            paints.addAll(paintsByName);
//            paints.addAll(paintsByBrand);
//        } else if (containsNumber(query)) {
//            // Search by hex code
//            paints = infoPaintDao.findByHexColorCode(query);
//        } else {
//            // Search only by paint name
//            paints = infoPaintDao.findByName(query);
//        }
//        //Let the user know no paints were found
//        if (paints.isEmpty()) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No paints found matching the search criteria.");
//        }
//        return paints;
//    }
//
//


    private boolean containsNumber(String str) {
        // Check if the string contains a number
        return str.matches(".*\\d.*");
    }

}
