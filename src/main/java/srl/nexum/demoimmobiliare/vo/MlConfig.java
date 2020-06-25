package srl.nexum.demoimmobiliare.vo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("quoteml")
@Data
public class MlConfig {
	private String srvUrl;

	public String getSrvUrl() {
		return srvUrl;
	}

	public void setSrvUrl(String srvUrl) {
		this.srvUrl = srvUrl;
	}
}
