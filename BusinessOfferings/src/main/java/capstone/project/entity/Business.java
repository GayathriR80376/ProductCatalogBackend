package capstone.project.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Business {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	 private String plan;
     private List<String> highSpeedInt;
    private List<String> voice;
    private List<String> productivity;
    private List<String> conferencing;
    private List<String> devices;
    private List<String> data;
    private List<String> payType;
    private String offer;
    private String adminName;
    private String Status;

}
