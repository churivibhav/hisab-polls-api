package co.hisabsoftware.polling.webback.Repositories;

import co.hisabsoftware.polling.webback.Entities.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface PollRepository extends JpaRepository<Poll, Integer> {

}
