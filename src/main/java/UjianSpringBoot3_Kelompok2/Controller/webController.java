package UjianSpringBoot3_Kelompok2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import UjianSpringBoot3_Kelompok2.Repository.KeberangkatanRepository;
import UjianSpringBoot3_Kelompok2.model.BookingCustomeGetNameModel;

@Controller
public class WebController {

	@Autowired
	KeberangkatanRepository keberangkatanRepo;

	@GetMapping("/")
	private String index(Model model) {
		return "index";
	}
	
	@GetMapping("/penumpang")
	private String about(Model model) {
		return "penumpang";
	}
	
	@GetMapping("/cariKeberangkatan")
	private String cariKeberangkatan(Model model) {
		return "cariKeberangkatan";
	}
	
	@GetMapping("/booking")
	private String booking(Model model) {
		return "booking";
	}
	
	@GetMapping("/contact")
	private String contact(Model model) {
		return "contact";
	}

//	@GetMapping("/cariKeberangkatan")
//	private List<BookingCustomeGetNameModel> getAllDataTerminalAwalTanggal(
//			@RequestParam(name = "terminal") String terminal, @RequestParam(name = "tanggal") String tanggal) {
//		return keberangkatanRepo.getAllDataTerminalTanggal(terminal, tanggal);
//	}

}
