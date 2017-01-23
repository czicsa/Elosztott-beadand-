package hu.meiit;

import hu.meiit.model.Car;
import hu.meiit.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

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

    @RequestMapping(value = "/newcar", method = RequestMethod.GET)
    public ModelAndView addNewCar() {
        ModelAndView mav = new ModelAndView("newcar");
        mav.addObject("car", new Car());
        return mav;
    }

    @RequestMapping(value = "/newcar", method = RequestMethod.POST)
    public String insertCar(@ModelAttribute("car") @Valid Car car, BindingResult errors) {
        if(errors.hasErrors()){
            return "redirect:/newcar";
        }
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
    public String modifyCar(@ModelAttribute("car") @Valid Car car, BindingResult errors) {
        if(errors.hasErrors()){
            return "redirect:/modifycar?carid=" + car.getId();
        }
        repo.editCar(car);
        return "redirect:/list";
    }
}
