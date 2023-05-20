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
    @GetMapping
    public List<InfoPaint> searchPaintsByName(@RequestParam("name") String name) {
        // Call the DAO method to search paints by name
        return infoPaintDao.findByString(name);
    }
}
