package capstone.project.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class WlinePostpaid {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(unique = true)
	private String planValue;
	private String planValidity;
	private String speed;
	private String data;
	private String voice;
    @ManyToMany(cascade = CascadeType.ALL)
	private List<Subproducts> subscription;
	private List<String> otherFeatures;
	private String category;
	private String adminName;
	private String status;
	

}
