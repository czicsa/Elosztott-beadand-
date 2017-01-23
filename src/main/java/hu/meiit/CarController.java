package hu.meiit;

import hu.meiit.model.Car;
import hu.meiit.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CarController {

	@Autowired
	private CarRepository repo;

    @RequestMapping(value = "/list")
    public ModelAndView getCarList() {
        ModelAndView mav = new ModelAndView("list");
        mav.addObject("cars", repo.getCars());
        return mav;
    }

    @RequestMapping(value = "/newcar")
    public ModelAndView addNewCar() {
        ModelAndView mav = new ModelAndView("newcar");
        return mav;
    }

    @RequestMapping(value = "/insertcar", method = RequestMethod.POST)
    public String insertCar(@ModelAttribute Car car) {
        repo.addCar(car);
        return "redirect:/list";
    }

    @RequestMapping(value = "/modifycar", method = RequestMethod.GET)
    public ModelAndView modifyCar(@RequestParam(value = "carid") int carId) {
        ModelAndView mav = new ModelAndView("modifycar");
        mav.addObject("car", repo.getCarById(carId));
        return mav;
    }

    @RequestMapping(value = "/modifycar", method = RequestMethod.POST)
    public String modifyCar(@ModelAttribute Car car) {
        repo.editCar(car);
        return "redirect:/list";
    }



	/*@RequestMapping(value = "/get-balance")
	public ModelAndView generateBalancePage() {
		ModelAndView mav = new ModelAndView("balance");

		return mav;
	}

	@RequestMapping(value = "/newuser", method = { RequestMethod.GET })
	public ModelAndView generateNewUserPage() {
		ModelAndView mav = new ModelAndView("newuser");
		UserModelData data = new UserModelData();
		data.setUsername("");
		data.setCredit("");
		data.getSchool().add("HIGHSCHOOL");
		mav.addObject("pageData", data);
		mav.addObject("schools", availableSchools);
		mav.addObject("colors", availableColors);
		mav.addObject("genders", availableGenders);
		return mav;
	}

	@RequestMapping(value = "/newuser", method = { RequestMethod.POST })
	public ModelAndView generateCreateUserHandler(@ModelAttribute() @Valid CreateUserDTO dto, BindingResult result) {

		ModelAndView mav = new ModelAndView("newuser");
		System.out.println(dto);
		List<String> errors = new ArrayList<String>();
		if (result.hasErrors()) {
			manageErrors(errors, availableFields, result);

			UserModelData data = new UserModelData();
			data.setUsername(dto.getUsername());
			data.setCredit(dto.getCredit());
			if (dto.getSchool() != null) {
				data.getSchool().add(dto.getSchool().name());
			}

			if (dto.getFavcol() != null) {
				data.setFavcol(dto.getFavcol());
			}

			if (dto.getGend() != null) {
				data.setGend(dto.getGend().name());
			}

			mav.addObject("pageData", data);
			mav.addObject("schools", availableSchools);
			mav.addObject("colors", availableColors);
			mav.addObject("genders", availableGenders);
			mav.addObject("status", errors);
			return mav;
		}

		userManager.storeUser(dto);

		mav.setViewName("redirect:/admin/status");
		return mav;
	}

	private UserModelData generateDefaultModelData() {
		UserModelData data = new UserModelData();
		data.setUsername("");
		data.setCredit("");
		data.getSchool().add("HIGHSCHOOL");

		return data;
	}

	private void manageErrors(List<String> result, String[] fields, BindingResult validationResult) {
		int length = fields.length;
		List<FieldError> fieldErrors = null;
		for (int i = 0; i < length; i++) {
			fieldErrors = validationResult.getFieldErrors(fields[i]);
			for (FieldError fe : fieldErrors) {
				result.add(fields[i] + ": " + fe.getDefaultMessage());
			}
		}
	}*/
}
