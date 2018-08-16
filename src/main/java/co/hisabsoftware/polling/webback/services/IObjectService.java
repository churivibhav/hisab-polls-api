package co.hisabsoftware.polling.webback.services;

import co.hisabsoftware.polling.webback.models.PollDto;

import java.util.List;
import java.util.Optional;

public interface IObjectService<T> {
    Optional<T> get(int id);

    List<T> get(int limit, int page);

    void create(T object);

    void update(int id, T object);

    void delete(int id);
}
