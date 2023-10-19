package capstone.project.entity;

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
public class AdminCredentials {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer iD;
	private String userId;
	private String userName;
	private String passWord;
	private String email;
	private String companyName;
	private String profile;
	private String twitter;
	private String facebook;
	private String instagram;
	private String linkedin;

}
