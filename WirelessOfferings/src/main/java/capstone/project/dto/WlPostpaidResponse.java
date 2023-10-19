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
public class WlPostpaidResponse {

	private Integer id;
	private String planValue;
	private String planValidity;
	private String totalData;
	private String voice;
	private String sms;
	private String addOnFamilySims;
	private String familySimData;
	private List<String> subscriptions;
//	@OneToMany(cascade = CascadeType.ALL)
//	public List<Subcreption> subscriptions;
	private String adminName;
	private String status;
}
