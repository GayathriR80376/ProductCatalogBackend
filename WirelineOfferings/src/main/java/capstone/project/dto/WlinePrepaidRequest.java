package capstone.project.dto;

import java.util.List;

import capstone.project.entity.Subscription;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WlinePrepaidRequest {
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
