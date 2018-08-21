package co.hisabsoftware.polling.webback.controllers;

import co.hisabsoftware.polling.webback.services.InMemoryPollService;
import co.hisabsoftware.polling.webback.services.PollService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	@GetMapping("/polls/{id}")
	public ResponseEntity<PollDto> getPollByid(@PathVariable("id") int id) {
		
		String text = "test";
		PollDto pdt =new PollDto(id, text);
		BeanUtils.copyProperties(service.get(id), pdt);
       // return service.get(id).orElse(new PollDto(0, "None"));
        return new ResponseEntity<PollDto>(pdt,HttpStatus.OK);
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
