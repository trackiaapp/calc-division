package trackia.app.example.calc.division.dao;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import trackia.app.Trackia;
import trackia.app.example.calc.division.to.CalcResponse;
import trackia.app.exception.BussinesException;
import trackia.app.util.TrackiaTransactionTrace;

@Repository
@AllArgsConstructor
@Log4j2
public class DivisionDao {
	private final CalcDao calcDao;
	@Trackia(value = "DAO_CALC", description = "Division calc")
	public CalcResponse calc(Object left, Object right) {
		log.info("calc start");
		
		try {
			Integer response = calcDao.value(left, "left") / 
	                calcDao.value(right, "right");
			return new CalcResponse(response, TrackiaTransactionTrace.getTransactionId());
		}catch(BussinesException e) {
			throw e;
		}catch(Exception e) {
			throw new BussinesException(HttpStatus.BAD_REQUEST, e.getMessage(), "0012", e);
		}
		
	}
	

}
