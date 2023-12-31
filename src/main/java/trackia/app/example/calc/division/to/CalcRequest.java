package trackia.app.example.calc.division.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CalcRequest {
	private String operation;

	@NotNull(message = "Left valor es requerido")
	private Object left;
	
	@NotNull(message = "Right valor es requerido")
	private Object right;
}
