package co.hisabsoftware.polling.webback.services;

import co.hisabsoftware.polling.webback.models.PollDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//@Service
public class InMemoryPollService implements IObjectService<PollDto> {

    private List<PollDto> polls;

    InMemoryPollService() {
        polls = new ArrayList<PollDto>() {
            {
                add(new PollDto(1, "Limit"));
                add(new PollDto(2, "Page"));
            }
        };
    }

    @Override
    public Optional<PollDto> get(int id) {
        return polls.stream().filter(p -> p.getId() == id).findFirst();
    }

    @Override
    public List<PollDto> get(int limit, int page) {
        return polls.stream().skip((page - 1)* limit).limit(limit).collect(Collectors.toList());
    }

    @Override
    public void create(PollDto pollDto) {
        pollDto.setId(polls.size()); // Auto increment id
        polls.add(pollDto);
    }

    @Override
    public void update(int id, PollDto pollDto) {
        delete(id);
        polls.add(pollDto);
    }

    @Override
    public void delete(int id) {
        polls = polls.stream().filter(p -> p.getId() != id)
                .sorted(Comparator.comparingInt(PollDto::getId))
                .collect(Collectors.toList());
    }
}
