package Requirements;

import java.util.List;
import java.util.Optional;

public interface RequirementsDAO {
    List<MoreRequirements> selectMoreRequirements(User user);

    int insertRequirements(Requirements requirements);
    int deleteRequirements(int id);
    Optional<Requirements> selectRequirementsById(int id);
    void updateRequirements(Requirements requirements, Integer id);
}

