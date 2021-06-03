package kodlamaio.northwind.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExperiencesAddDto {
	private int id;
	private String experiences;
	private LocalDate startDate;
	private LocalDate endDate;
	private boolean isWorkingNow;

}
