package co.hisabsoftware.polling.webback.services;

import co.hisabsoftware.polling.webback.Repositories.PollRepository;
import co.hisabsoftware.polling.webback.models.PollDto;
import co.hisabsoftware.polling.webback.mapping.MapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PollService implements IObjectService<PollDto> {

    @Autowired
    private PollRepository repository;
    @Autowired
    private MapperService mapper;

    @Override
    public Optional<PollDto> get(int id) {
        return repository.findById(id).map(p -> mapper.toDto(p));
    }

    @Override
    public List<PollDto> get(int limit, int page) {
       return repository.findAll(PageRequest.of(page, limit))
               .map(p -> mapper.toDto(p))
               .getContent();
    }

    @Override
    public void create(PollDto object) {
        repository.save(mapper.toNewEntity(object));
    }

    @Override
    public void update(int id, PollDto object) {
        repository.save(mapper.toUpdatedEntity(repository.findById(id).get(), object));
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
