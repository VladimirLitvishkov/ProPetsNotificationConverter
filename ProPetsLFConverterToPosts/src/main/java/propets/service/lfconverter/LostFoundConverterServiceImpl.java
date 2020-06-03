package propets.service.lfconverter;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import propets.dao.lfconverter.LostAndFoundRepository;
import propets.dao.lfconverter.NotificationRepository;
import propets.dto.lfconverter.LostFoundDTO;
import propets.exceptions.lfconverter.PostIDNotFoundException;
import propets.model.lfconverter.LostFound;

@Service
public class LostFoundConverterServiceImpl implements LostFoundConverterService {
	
	@Autowired
	LostAndFoundRepository lostFoundRepository;
	
	@Autowired
	NotificationRepository notificationRepository;

	@Override
	public Set<LostFoundDTO> findPostsByAllId(Set<String> allId) {
		return allId.stream()
				.map((id) -> buildLostFoundDto(
						lostFoundRepository.findById(id).orElseThrow(() -> new PostIDNotFoundException())))
				.collect(Collectors.toSet());
	}

	private LostFoundDTO buildLostFoundDto(LostFound model) {
		return LostFoundDTO.builder().id(model.getId()).userLogin(model.getUserLogin())
				.userName(model.getUserName()).avatar(model.getAvatar()).datePost(model.getDatePost())
				.type(model.getType()).typePost(model.getTypePost()).tags(model.getTags()).photos(model.getPhotos())
				.breed(model.getBreed()).sex(model.getSex()).location(model.getLocation()).build();
	}

	@Override
	public Set<LostFoundDTO> findPostsFromNotificationID(String id) {
		return notificationRepository.findById(id).orElseThrow(() -> new PostIDNotFoundException()).getPosts();
	}

}
