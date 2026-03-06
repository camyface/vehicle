package mil.army.moda.vehicle.operator;

import org.springframework.stereotype.Service;

@Service
public class OperatorService {
    private final OperatorRepository operatorRepository;

    public OperatorService(OperatorRepository operatorRepository) {
        this.operatorRepository = operatorRepository;
    }

    public Operator saveOperator(Operator operator) {
        return operatorRepository.save(operator);
    }
}
