package trackia.app.example.calc.division.dao;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import trackia.app.Trackia;
import trackia.app.annotations.R;
import trackia.app.example.calc.division.to.CalcResponse;
import trackia.app.exception.BussinesException;
import trackia.app.to.Journal;

@Repository
@AllArgsConstructor
@Log4j2
public class DivisionDao {
	private final CalcDao calcDao;
	@Trackia(value = "DAO_CALC", description = "Division calc")
	public CalcResponse calc(@R Object left, @R Object right, Journal journal) {
		log.info("calc start");
		
		try {
			Integer response = calcDao.value(left, "left", journal) / 
	                calcDao.value(right, "right", journal);
			return new CalcResponse(response, journal.getTransactionId());
		}catch(BussinesException e) {
			throw e;
		}catch(Exception e) {
			throw new BussinesException(HttpStatus.BAD_REQUEST, e.getMessage(), "0012", e);
		}
		
	}
	

}
