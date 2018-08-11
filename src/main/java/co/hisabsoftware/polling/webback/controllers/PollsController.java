package co.hisabsoftware.polling.webback.controllers;

import co.hisabsoftware.polling.webback.services.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import co.hisabsoftware.polling.webback.models.Poll;
import io.swagger.annotations.ApiResponse;

import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@RestController
@RequestMapping("/api/polls")
public class PollsController {

	@Autowired
	private PollService service;

    /**
     * GET /api/polls/1
     * @param id
     * @return
     */
	@GetMapping("{id}")
	public Poll getOne(@PathVariable int id) {
        return service.getPoll(id).orElse(new Poll(0, "None"));
	}

    /**
     * GET /api/polls?limit=20&page=1
     * @param limit
     * @param page
     * @return
     */
	@GetMapping
    public List<Poll> getAll(@RequestParam int limit, @RequestParam int page) {
	    return service.getPolls(limit, page);
    }

    /**
     * POST /api/polls
     * BODY { id: 1, text: "ABC" }
     * @param poll
     */
    @PostMapping
    public void post(@RequestBody Poll poll) {
	    if (nonNull(poll)) {
            service.createPoll(poll);
        }
    }

    @PutMapping("{id}")
    public void put(@PathVariable int id, @RequestBody Poll poll) {
        if (nonNull(poll)) {
            service.updatePoll(id, poll);
        }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        service.deletePoll(id);
    }

}
