package by.artiomN.service;

import by.artiomN.dao.UserLibraryDAO;
import by.artiomN.entity.Game;
import by.artiomN.entity.UserLibrary;

import java.util.List;

public enum UserLibraryService {
    INSTANCE;
    public UserLibrary writeToLibrary(UserLibrary userLibrary){
        return UserLibraryDAO.INSTANCE.addToLibrary(userLibrary);
    }
    public List<Game> getUserListOfGames(Long id){
        return UserLibraryDAO.INSTANCE.getLibrary(id);
    }
}
