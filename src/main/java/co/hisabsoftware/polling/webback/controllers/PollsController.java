package co.hisabsoftware.polling.webback.controllers;

import co.hisabsoftware.polling.webback.services.InMemoryPollService;
import co.hisabsoftware.polling.webback.services.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import co.hisabsoftware.polling.webback.models.PollDto;

import java.util.List;

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
	public PollDto getOne(@PathVariable int id) {
        return service.get(id).orElse(new PollDto(0, "None"));
	}

    /**
     * GET /api/polls?limit=20&page=1
     * @param limit
     * @param page
     * @return
     */
	@GetMapping
    public List<PollDto> getAll(@RequestParam int limit, @RequestParam int page) {
	    return service.get(limit, page);
    }

    /**
     * POST /api/polls
     * BODY { id: 1, text: "ABC" }
     * @param pollDto
     */
    @PostMapping
    public void post(@RequestBody PollDto pollDto) {
	    if (nonNull(pollDto)) {
            service.create(pollDto);
        }
    }

    @PutMapping("{id}")
    public void put(@PathVariable int id, @RequestBody PollDto pollDto) {
        if (nonNull(pollDto)) {
            service.update(id, pollDto);
        }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

}
