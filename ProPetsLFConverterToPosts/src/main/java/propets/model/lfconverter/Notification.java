package propets.model.lfconverter;

import java.util.Set;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;
import propets.dto.lfconverter.LostFoundDTO;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Notification {
	
	@Id
	String id;
	@Singular("users")
	Set<String> users;
	@Singular("posts")
	Set<LostFoundDTO> posts;

}
