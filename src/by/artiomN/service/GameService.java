package by.artiomN.service;

import by.artiomN.dao.GameDao;
import by.artiomN.dto.GameDto;
import by.artiomN.entity.Game;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public enum GameService {
    INSTANCE;
   public ArrayList<Game> games = new ArrayList<Game>();
    public Long createGame(Game game) {
        return GameDao.INSTANCE.save(game);
    }

    public List<GameDto> getAllGames() {
        return GameDao.INSTANCE.getAll().stream().map(game -> new GameDto(
                game.getId(),
                game.getName(),
                game.getGenre(),
                game.getCompanyName()))
                .collect(toList());

    }

    public Game findOne(Long id) {
        Game foundedGame = GameDao.INSTANCE.findOne(id);
        if (foundedGame == null) {
            return null;
        } else {
            return foundedGame;
        }
    }
    public List<Game> getList(){
        return games;
    }
    public Game getGame(Long id){

        return games.get(id.intValue());
    }
    public void addToList(Game game){

        games.add(game);
        game.setId((long) games.indexOf(game));
        games.remove(game);
        games.add(game);
    }
}
