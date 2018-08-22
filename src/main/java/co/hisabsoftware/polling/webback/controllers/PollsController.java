package co.hisabsoftware.polling.webback.controllers;

import co.hisabsoftware.polling.webback.services.PollService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.hisabsoftware.polling.webback.models.PollDto;

import java.util.List;
import java.util.Optional;

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
	public ResponseEntity<PollDto> getOne(@PathVariable("id") int id) {
        Optional<PollDto> dto = service.get(id);
        if(((Optional) dto).isPresent()) {
            return new ResponseEntity<>(dto.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
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
    public ResponseEntity post(@RequestBody PollDto pollDto) {
	    if (nonNull(pollDto)) {
            service.create(pollDto);
            return new ResponseEntity(HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("{id}")
    public ResponseEntity put(@PathVariable int id, @RequestBody PollDto pollDto) {
        if (nonNull(pollDto)) {
            service.update(id, pollDto);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
        // Responses as per : https://stackoverflow.com/questions/797834/should-a-restful-put-operation-return-something
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
