package propets.service.lfconverter;

import java.util.Set;

import propets.dto.lfconverter.LostFoundDTO;


public interface LostFoundConverterService {
	
	Set<LostFoundDTO> findPostsByAllId(Set<String> allId);
	
	Set<LostFoundDTO> findPostsFromNotificationID(String id);

}
