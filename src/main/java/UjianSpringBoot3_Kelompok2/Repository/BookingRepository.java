package UjianSpringBoot3_Kelompok2.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import UjianSpringBoot3_Kelompok2.model.BookingDetailModel;
import UjianSpringBoot3_Kelompok2.model.BookingModel;

public interface BookingRepository extends JpaRepository<BookingModel, Long>{

	@Query(value="select * from booking "
		    + "left join penumpang on booking.nik = penumpang.nik "
			+ "left join keberangkatan on booking.id_keberangkatan = keberangkatan.id_keberangkatan "
			+ "left join bus on booking.no_polisi = bus.no_polisi "
			+ "where booking.id_keberangkatan = ?1 and booking.nik = ?2 " , nativeQuery = true)
	
	List<BookingModel> getAllDataIdNik(long id_keberangkatan , String nik);

//	List<BookingDetailModel> getByIdAndNik(long id, String nik);
}
