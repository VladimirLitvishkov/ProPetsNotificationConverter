package propets.controller.lfconverter;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import propets.dto.lfconverter.LostFoundDTO;
import propets.service.lfconverter.LostFoundConverterService;

@CrossOrigin(origins = "*", exposedHeaders = "X-token")
@RestController
@RequestMapping("/{lang}/v1")
public class LFConverterToPostsController {
	
	@Autowired
	LostFoundConverterService converterService;
	
	@PostMapping("/posts/allid")
	public Set<LostFoundDTO> findPostsByAllId(@RequestBody Set<String> allId) {
		return converterService.findPostsByAllId(allId);
	}
	
	@GetMapping("/{id}")
	public Set<LostFoundDTO> findPostsFromNotificationID(@PathVariable String id) {
		return converterService.findPostsFromNotificationID(id);
	}

}
