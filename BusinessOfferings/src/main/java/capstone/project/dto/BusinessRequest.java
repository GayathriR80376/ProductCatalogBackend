package capstone.project.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BusinessRequest {
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
