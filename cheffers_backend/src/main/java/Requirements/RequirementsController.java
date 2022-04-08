package Requirements;

import cheffers.User.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/requirements")
public class RequirementsController {

    private RequirementsService requirementsService;

    public RequirementsController(RequirementsService requirementsService) {
        this.requirementsService = requirementsService;
    }

    @GetMapping
    public List<MoreRequirements> listMoreRequirements(@RequestParam(required = false) String allergen, @RequestParam (required = false) Integer cookingTime) {
        User user = new User();
        if (allergen != null) {
            user.setAllergy(allergen);
        } else {
            user.setAllergy("null");
        }

        if (cookingTime != null) {
            user.setCookingTime(cookingTime);
        } else {
            user.setCookingTime(300);
        }

        return requirementsService.getMoreRequirements(user);
    }

    @GetMapping("{id}")
    public Requirements getRequirementsId(@PathVariable("id") Integer id) {
        return requirementsService.getRequirements(id);
    }

    @PostMapping
    public void addRequirements(@RequestBody Requirements requirements) {
        requirementsService.addNewRequirements(requirements);
    }

    @DeleteMapping("{id}")
    public void deleteRequirements(@PathVariable("id") Integer id) {
        requirementsService.deleteRequirements(id);
    }

    @PutMapping("{id}")
    public void updateRequirements(@RequestBody Requirements requirements, @PathVariable("id") Integer id) { requirementsService.updateRequirements(requirements,id);}



}
