package mil.army.moda.vehicle.operator;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OperatorController {

    private final OperatorService operatorService;
    public OperatorController(OperatorService operatorService) {
        this.operatorService = operatorService;
    }

    @PostMapping("/operator")
    public Operator saveOperator(@RequestBody Operator operator) {
        return operatorService.saveOperator(operator);
    }
}
