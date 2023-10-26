package trackia.app.example.calc.division.service;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import trackia.app.Trackia;
import trackia.app.example.calc.division.dao.DivisionDao;
import trackia.app.example.calc.division.to.CalcRequest;
import trackia.app.example.calc.division.to.CalcResponse;

@Service
@AllArgsConstructor
@Log4j2
public class DivisionService {
	private final DivisionDao dao;
	
	@Trackia(value = "DIVISION_SERVICE", description = "Division logic")
	public CalcResponse calc(CalcRequest request){
		log.info("calc start");
		
		return dao.calc(request.getLeft(), request.getRight());
	}
}
