package Requirements;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequirementsService {

    private final RequirementsDAO requirementsDAO;

    public RequirementsService(RequirementsDAO requirementsDAO) {
        this.requirementsDAO = requirementsDAO;
    }

    public List<MoreRequirements> getMoreRequirements(User user) {
        return requirementsDAO.selectMoreRequirements(user);
    }

    public Requirements getRequirements(int id) {
        return requirementsDAO.selectRequirementsById(id)
                .orElseThrow(() -> new Exceptions(String.format("Recipe with id not found", id)));
    }

    public void deleteRequirements(Integer id) {
        Optional<Requirements> requirements = requirementsDAO.selectRequirementsById(id);
        requirements.ifPresentOrElse(requirements -> {
            int result = requirementsDAO.deleteRequirements(id);
            if (result != 1) {
                throw new IllegalStateException("Could not delete the Recipe");
            }
        }, () -> {
            throw new Exceptions(String.format("Recipe with id not found", id));
        });
    }

    public void addNewRequirements(Requirements requirements) {
        int result = requirementsDAO.insertRequirements(requirements);
        if (result != 1) {
            throw new IllegalStateException("New requirement can not be added");
        }
    }

    public void updateRequirements(Requirements requirements, Integer id) {
        requirementsDAO.updateRequirements(requirements, id);
    }
}

