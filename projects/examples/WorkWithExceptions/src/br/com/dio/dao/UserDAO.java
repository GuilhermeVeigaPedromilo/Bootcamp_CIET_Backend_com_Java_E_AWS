package br.com.dio.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.dio.model.UserModel;

public class UserDAO {
    private final List<UserModel> models = new ArrayList<>();
    private long nextId = 1L;

    public UserModel save(final UserModel model){
        model.setId(nextId);
        nextId++;
        models.add(model);
        return model;
    }

    public UserModel update(final UserModel model) {
        
    }

    public UserModel findById(final long id) {
        models.stream().filter(u -> u.getId() == id)
        .findFirst().orElseThrow();
    }
}
