package UjianSpringBoot3_Kelompok2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import UjianSpringBoot3_Kelompok2.Repository.BookingRepository;
import UjianSpringBoot3_Kelompok2.Repository.KeberangkatanRepository;
import UjianSpringBoot3_Kelompok2.Repository.PenumpangRepository;
import UjianSpringBoot3_Kelompok2.model.BookingCustomeGetNameModel;
import UjianSpringBoot3_Kelompok2.model.BookingDetailModel;
import UjianSpringBoot3_Kelompok2.model.BookingModel;
import UjianSpringBoot3_Kelompok2.model.PenumpangModel;

@Controller
public class WebController {

	@Autowired
	KeberangkatanRepository keberangkatanRepo;
	
	@Autowired
	BookingRepository bookingRepo;

	@Autowired
	PenumpangRepository penumpangRepo;
	
	@GetMapping("/")
	private String index(Model model) {
		return "index";
	}
	
	@GetMapping("/penumpang")
	private String penumpang(Model model) {
		return "penumpang";
	}
	
	@GetMapping("/daftar")
	private String inputPenumpang(Model model) {
		model.addAttribute("penumpangModel", new PenumpangModel());
		return "formpenumpangbaru";

	}
	
	@PostMapping("/detailpenumpang")
	private String savePenumpang(@ModelAttribute PenumpangModel penumpang) {
		penumpangRepo.save(penumpang);
		return "detailpenumpang";
	}
	
	@GetMapping("/detailpenumpang")
	private String tampilPenumpang(Model model, String nik, String nama, String telepon) {

		model.addAttribute("findAll", new PenumpangModel());
		return "detailPenumpang";
	}
	
	@GetMapping("/cariKeberangkatan")
	private String  cariKeberangkatan(Model model, @RequestParam(value="terminal", defaultValue = "")String terminal,
			@RequestParam(value="tanggal", defaultValue = "")String tanggal) {
		if (terminal.isEmpty()&& tanggal.isEmpty()) {
			model.addAttribute("kenihilankeberangkatan");
			return "kenihilankeberangkatan";
		}else {
			model.addAttribute("ListContent",keberangkatanRepo.getAllDataTerminalTanggal(terminal, tanggal));
		}
		return "cariKeberangkatan";
	}
	
	@GetMapping("/kenihilankeberangkatan")
	private String kenihilankeberangkatan(Model model) {
		return "kenihilankeberangkatan";
	}
	
	@GetMapping("/booking")
	private String booking(Model model) {
		return "booking";
	}
	
	@GetMapping("/booking/formbooking")
	private String inputBooking(Model model){
		model.addAttribute("bookingModel", new BookingModel());
		return "formbooking";
	}
	
	@PostMapping("/bookingdetail")
	private String saveBooking(@ModelAttribute BookingModel data) {
		bookingRepo.save(data);
		return "redirect:/bookingdetail?id="+data.getId_keberangkatan().getId_keberangkatan()+"&nik"+data.getNik().getNik();
	}
	
	
	@GetMapping("/bookingdetail")
	private String detailbooking(Model model, @RequestParam(value="id", defaultValue = "")Long id_keberangkatan,
		@RequestParam(value="nik", defaultValue = "")String nik) {
		model.addAttribute("ListBooking", bookingRepo.getAllDataIdNik(id_keberangkatan, nik));
		return "bookingdetail";
	}

	@GetMapping("/booking/cancel")
	private String cancel(Model model) {
		return "formcancel";
	}

	
	@PostMapping("/formcancel/cancelmessage")
	private String deleteByBookingId(@RequestParam(name="id")long id) {
		bookingRepo.deleteById(id);
		return "cancelmessage";
	}
	
	@GetMapping("/contact")
	private String contact(Model model) {
		return "contact";
	}

//	@GetMapping("/cariKeberangkatan/formcarikeberangkatan")
//	private String formcarikeberangkatan(Model model){
//		model.addAttribute("bookingcustomnamemodel", new BookingCustomeGetNameModel());
//		return "formcarikeberangkatan";
//	}
	
//	@PostMapping("/cariKeberangkatan/formcarikeberangkatan")
//	private String getAllDataTerminalAwalTanggal(@RequestParam(name = "terminal") String terminal, @RequestParam(name = "tanggal") String tanggal) {
//		 keberangkatanRepo.getAllDataTerminalTanggal(terminal, tanggal);
//		 return "formcarikeberangkatan";
//	}
	
	package UjianSpringBoot3_Kelompok2.Controller;

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.RequestParam;

	import UjianSpringBoot3_Kelompok2.Repository.KeberangkatanRepository;
	import UjianSpringBoot3_Kelompok2.Repository.PenumpangRepository;
	import UjianSpringBoot3_Kelompok2.model.BookingCustomeGetNameModel;

	@Controller
	public class WebController {

		@Autowired
		KeberangkatanRepository keberangkatanRepo;
		
		@Autowired
		PenumpangRepository penumpangRepo;

		@GetMapping("/")
		private String index(Model model) {
			return "index";
		}
		
		@GetMapping("/penumpang")
		private String penumpang(Model model) {
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

//		@GetMapping("/cariKeberangkatan")
//		private List<BookingCustomeGetNameModel> getAllDataTerminalAwalTanggal(
//				@RequestParam(name = "terminal") String terminal, @RequestParam(name = "tanggal") String tanggal) {
//			return keberangkatanRepo.getAllDataTerminalTanggal(terminal, tanggal);
//		}
		
		@GetMapping("/blog")
		private String blog(Model model, @RequestParam(value = "huruf",defaultValue = "")String huruf
				,@RequestParam(value="tanggal",defaultValue = "")String tanggal) {
			model.addAttribute("listPenumpang", penumpangRepo.findByTanggalContainingAndNamaContaining(tanggal, nama));
			
	}


}
