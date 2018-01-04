package xmu.crms.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import xmu.crms.entity.Event;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Mapper
@Component
/**
 * @author zzj
 * */
public interface TimerMapper {

	/**
	 * 接口
	 * @param event
	 * @return
	 */
    Integer insertEvent(Event event);

    /**
     *  接口
     * @param eventId
     */
    void deleteEvent(BigInteger eventId);

    /**
     *  接口 
     * @param event
     */
    void  updateEvent(Event event);
/**
 *  接口
 * @return
 */
    List<Event> listExecutableEvents();

    /**
     *  接口
     * @param eventId
     * @return
     */
    Event getEventByEventId(BigInteger eventId);
}
