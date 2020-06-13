package by.artiomN.service;

import by.artiomN.dao.UserDao;
import by.artiomN.dto.UserBasicDto;
import by.artiomN.dto.UserDto;
import by.artiomN.entity.User;

public enum UserService {
    INSTANCE;
    public Long createUser(UserDto userDto){

        return UserDao.INSTANCE.save(userDto);
    }
//    public List<ViewUserBasicDto> findAll(){
//        return UserDao.INSTANCE
//                .getAll()
//                .stream()
//                .map(user -> new ViewUserBasicDto(user.getId(),user.getLogin()))
//                .collect(toList());
//
//    }
    public User findOne(Long id){
        User foundUser = UserDao.INSTANCE.findOne(id);
        if(foundUser==null){
            return null;
        }
        else {
            return foundUser;
        }

    }
    public User authentication(UserBasicDto userBasicDto){
        return UserDao.INSTANCE.findByLogin(userBasicDto);
    }


}
