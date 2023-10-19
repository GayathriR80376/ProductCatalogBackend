package capstone.project.dto;

import java.util.List;

import capstone.project.entity.Subscription;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WlinePrepaidResponse {
	private Integer id;
	private String planValue;
	private String planValidity;
	private String speed;
	private String data;
	private String voice;
	private List<Subscription> subscription;
	private List<String> otherFeatures;
	private String category;
	private String adminName;
	private String status;

}
