package capstone.project.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class WlPostpaid {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
