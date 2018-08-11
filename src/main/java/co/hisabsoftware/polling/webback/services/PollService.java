package co.hisabsoftware.polling.webback.services;

import co.hisabsoftware.polling.webback.models.Poll;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PollService {

    private List<Poll> polls;

    PollService () {
        polls = new ArrayList<Poll>() {
            {
                add(new Poll(1, "Limit"));
                add(new Poll(2, "Page"));
            }
        };
    }

    public Optional<Poll> getPoll(int id) {
        return polls.stream().filter(p -> p.getId() == id).findFirst();
    }

    public List<Poll> getPolls(int limit, int page) {
        return polls.stream().skip((page - 1)* limit).limit(limit).collect(Collectors.toList());
    }

    public void createPoll(Poll poll) {
        poll.setId(polls.size()); // Auto increment id
        polls.add(poll);
    }

    public void updatePoll(int id, Poll poll) {
        deletePoll(id);
        polls.add(poll);
    }

    public void deletePoll(int id) {
        polls = polls.stream().filter(p -> p.getId() != id)
                .sorted(Comparator.comparingInt(Poll::getId))
                .collect(Collectors.toList());
    }
}
