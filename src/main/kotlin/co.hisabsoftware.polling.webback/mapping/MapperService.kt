package co.hisabsoftware.polling.webback.mapping

import co.hisabsoftware.common.utils.StringUtils
import co.hisabsoftware.polling.webback.entities.Poll
import co.hisabsoftware.polling.webback.models.PollDto
import org.springframework.stereotype.Service

@Service
class MapperService {
    fun toDto(poll: Poll): PollDto {
        return PollDto(poll.id, poll.title)
    }

    fun toNewEntity(pollDto: PollDto): Poll {
        // TODO : Change DTO to reflect Poll
        return Poll(pollDto.id, pollDto.title, StringUtils.EMPTY, true, true)
    }

    fun toUpdatedEntity(poll: Poll, pollDto: PollDto): Poll {
        poll.id = pollDto.id
        poll.title = pollDto.title
        // TODO : Set all properties
        return poll
    }
}
