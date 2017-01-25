package hu.meiit;

import hu.meiit.model.Car;
import hu.meiit.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CarController {

	@Autowired
	private CarRepository repo;

    @RequestMapping(value = "/list")
    public ModelAndView getCarListPage() {
        ModelAndView mav = new ModelAndView("list");
        return mav;
    }

    @RequestMapping(value = "/getCars", produces = "application/json")
    @ResponseBody
    public List<Car> getCars() {
        return repo.getCars();
    }

    @RequestMapping(value = "/newcar", method = RequestMethod.GET)
    public ModelAndView addNewCar() {
        ModelAndView mav = new ModelAndView("newcar");
        mav.addObject("car", new Car());
        return mav;
    }

    @RequestMapping(value = "/newcar", method = RequestMethod.POST)
    public void insertCar(@RequestBody Car car) {
        repo.addCar(car);
    }

    @RequestMapping(value = "/modifycar", method = RequestMethod.GET)
    public ModelAndView modifyCarPage() {
        ModelAndView mav = new ModelAndView("modifycar");
        return mav;
    }

    @RequestMapping(value = "/getCarById/{carId}", method = RequestMethod.GET)
    @ResponseBody
    public Car getCarById(@PathVariable int carId) {
        return repo.getCarById(carId);
    }

    @RequestMapping(value = "/modifycar", method = RequestMethod.POST)
    public void modifyCar(@RequestBody Car car) {
        repo.editCar(car);
    }
}
