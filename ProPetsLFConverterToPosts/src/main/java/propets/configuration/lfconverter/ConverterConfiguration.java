package propets.configuration.lfconverter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;

@Configuration
@RefreshScope
@Getter
public class ConverterConfiguration {
	
	@Value("${keyUsers}")
	String keyUsers;

	@Value("${keyPosts}")
	String keyPosts;
	
	@Value("${urlCheckToken}")
	String urlCheckToken;

}
