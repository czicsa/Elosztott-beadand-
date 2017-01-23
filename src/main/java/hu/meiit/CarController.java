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
        mav.addObject("car", new Car());
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
}
