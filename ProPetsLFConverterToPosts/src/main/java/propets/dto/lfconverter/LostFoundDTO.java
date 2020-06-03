package propets.dto.lfconverter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Singular;
import propets.model.lfconverter.Location;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@EqualsAndHashCode(of = { "id" })
public class LostFoundDTO {
	
	String id;

	Boolean typePost;

	String type;
	String breed;
	String sex;
	Location location;
	@Singular("photos")
	List<String> photos;
	@Singular("tags")
	Set<String> tags;
	String userLogin;
	String userName;
	String avatar;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	LocalDateTime datePost;

}
