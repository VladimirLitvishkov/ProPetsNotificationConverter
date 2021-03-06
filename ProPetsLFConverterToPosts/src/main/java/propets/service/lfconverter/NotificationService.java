package propets.service.lfconverter;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

import propets.configuration.lfconverter.ConverterConfiguration;
import propets.dao.lfconverter.NotificationRepository;
import propets.dto.lfconverter.NotificationDTO;
import propets.model.lfconverter.Notification;

@EnableBinding(Processor.class)
public class NotificationService {

	@Autowired
	ConverterConfiguration configuration;

	@Autowired
	NotificationRepository notificationRepository;

	@Autowired
	LostFoundConverterService converterService;

	@StreamListener(Processor.INPUT)
	@SendTo(Processor.OUTPUT)
	public NotificationDTO searchResultNotification(Map<String, Set<String>> info) {
		if (info == null) {
			return null;
		}
		Notification notification = Notification.builder()
				.posts(converterService.findPostsByAllId(info.get(configuration.getKeyPosts())))
				.users(info.get(configuration.getKeyUsers())).build();
		notificationRepository.save(notification);
		return NotificationDTO.builder().id(notification.getId()).users(notification.getUsers()).build();
	}

}
