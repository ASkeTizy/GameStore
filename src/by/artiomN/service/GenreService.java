package by.artiomN.service;

import by.artiomN.dao.GenreDao;
import by.artiomN.entity.Genre;

import java.util.List;

public enum  GenreService {
    INSTANCE;
    public List<Genre> getAllGenres(){
        return GenreDao.INSTANCE.findAll();
    }

}
