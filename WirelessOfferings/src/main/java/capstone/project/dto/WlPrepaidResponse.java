package capstone.project.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class WlPrepaidResponse {
	private Integer id;
	private String planValue;
	private String planvalidity;
	private String totaldata;
	private String dataperday;
	private String voice;
	private String sms;
	private List<String> subscriptions;
	private String adminName;
	private String status;

}
