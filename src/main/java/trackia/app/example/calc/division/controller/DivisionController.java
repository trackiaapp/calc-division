package trackia.app.example.calc.division.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import trackia.app.Trackia;
import trackia.app.annotations.R;
import trackia.app.example.calc.division.service.DivisionService;
import trackia.app.example.calc.division.to.CalcRequest;
import trackia.app.example.calc.division.to.CalcResponse;
import trackia.app.module.sla.Slable;
import trackia.app.module.sysinfo.Infoable;
import trackia.app.to.Journal;

@RestController
@AllArgsConstructor
@Log4j2
public class DivisionController {
	
	private final DivisionService service;
	
	@Trackia(
          	value = "CONTROLLER_DIVISION",
      description = "Calc Division TrackIA example",
        collector = true, 
  autoTransaction = true,
  		  	write = true
	)
	@Slable(3000)
	@Infoable
	
	@PostMapping("division")
	public ResponseEntity<CalcResponse> division(@R @Validated @RequestBody CalcRequest request, Journal journal) {
		log.info("division start");
		return new ResponseEntity<>(service.calc(request, journal), HttpStatus.OK);
	}
}
