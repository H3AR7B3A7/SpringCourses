package be.dog.d.steven.multipledb.service;

import be.dog.d.steven.multipledb.dao.UserDao;
import be.dog.d.steven.multipledb.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Qualifier("datasource1")
public class UserService {

    private final UserDao dao;

    @Transactional
    public void addUser(User user){
        dao.save(user);
    }

    @Transactional
    public Iterable<User> getAllUsers(){
        return dao.findAll();
    }

    @Transactional
    public Optional<User> getUserById(int id){
        return dao.findById(id);
    }

    @Transactional
    public int deleteUser(int id){
        if(dao.existsById(id)) {
            dao.deleteById(id);
            return 1;
        } else {
            return 0;
        }
    }

}
