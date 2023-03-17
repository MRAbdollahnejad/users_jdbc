package repository;

import entity.User;

public interface Crud {
    void save(User user);
    void saveAll();
    void delete();
    void update();
    void load();
    void loadAll();
}
