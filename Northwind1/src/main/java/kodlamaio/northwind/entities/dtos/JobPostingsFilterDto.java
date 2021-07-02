package kodlamaio.northwind.entities.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPostingsFilterDto {
	List<Integer> cityId;
	List<Integer> workPlaceId;
	List<Integer> workTimeId;

	

}
