package co.hisabsoftware.polling.webback.services.mapping;

import co.hisabsoftware.common.utils.StringUtils;
import co.hisabsoftware.polling.webback.Entities.Poll;
import co.hisabsoftware.polling.webback.models.PollDto;
import org.springframework.stereotype.Service;

@Service
public class MapperService {
    public PollDto toDto(Poll poll) {
        return new PollDto(poll.getId(), poll.getTitle());
   }

   public Poll toNewEntity(PollDto pollDto) {
        // TODO : Change DTO to reflect Poll
        return new Poll(pollDto.getId(), pollDto.getText(), StringUtils.EMPTY, true, true);
   }

   public Poll toUpdatedEntity(Poll poll, PollDto pollDto) {
        poll.setId(pollDto.getId());
        poll.setTitle(pollDto.getText());
        // TODO : Set all properties
        return poll;
   }
}
