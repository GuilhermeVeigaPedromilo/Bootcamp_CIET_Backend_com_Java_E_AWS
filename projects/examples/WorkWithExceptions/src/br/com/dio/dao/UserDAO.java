package br.com.dio.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.dio.exception.EmpltyStorageException;
import br.com.dio.exception.UserNotFoudException;
import br.com.dio.model.UserModel;

public class UserDAO {
    private final List<UserModel> models = new ArrayList<>();
    private long nextId = 1L;

    // CRUD - Implementation

    // CREATE
    public UserModel save(final UserModel model){
        model.setId(nextId);
        nextId++;
        models.add(model);
        return model;
    }

    // UPDATE
    public UserModel update(final UserModel model) {
        verifyStorage();
        var toUpdate = findById(model.getId());
        models.remove(toUpdate);
        models.add(model);
        return model;
    }

    // DELETE
    public void delete(final long id) {
        verifyStorage();
        var toDelete = findById(id);
        models.remove(toDelete);
    }

    // READ - Search a user by id
    public UserModel findById(final long id) {
        verifyStorage();
        var message = String.format("There isn't a user with this id (%s) registered", id);
        return models.stream().filter(u -> u.getId() == id)
        .findFirst().orElseThrow(() -> new UserNotFoudException(message));
    }

    // READ
    public List<UserModel> findAll() {
        List<UserModel> result;
        try {
            verifyStorage();
            result = models;
        } catch (EmpltyStorageException ex) {
            ex.printStackTrace();
            result = new ArrayList<>();
        }
        return result;
    }

    private void verifyStorage() {
        if (models.isEmpty()) throw new EmpltyStorageException("The storage is empty");
    }
}
