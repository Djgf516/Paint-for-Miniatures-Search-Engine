package controller;

import dao.InfoPaintDao;
import models.InfoPaint;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InfoPaintController {
    private InfoPaintDao infoPaintDao;

    public InfoPaintController(InfoPaintDao infoPaintDao) {
        this.infoPaintDao = infoPaintDao;
    }

    @RequestMapping(value= "/all", method = RequestMethod.GET)
    public List<InfoPaint> findAllPaints(){
        return infoPaintDao.findAll();
    }
}
