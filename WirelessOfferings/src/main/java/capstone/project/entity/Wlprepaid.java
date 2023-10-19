package capstone.project.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Builder
public class Wlprepaid {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String planValue;
	private String planvalidity;
	private String totaldata;
	private String dataperday;
	private String voice;
	private String sms;
	private List<String> subscriptions;
//	@OneToMany(cascade = CascadeType.ALL)
//	public List<Subcreption> subscriptions;
	private String adminName;
	private String status;

}
