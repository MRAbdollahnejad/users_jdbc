package repository;

import entity.User;

public interface Crud {
    void save(User user);
    void saveAll(User[] users);

    void delete(int userId);
    void update();
    void load();
    void loadAll();
}
