package UjianSpringBoot3_Kelompok2.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import UjianSpringBoot3_Kelompok2.model.BookingCustomeGetNameModel;
import UjianSpringBoot3_Kelompok2.model.KeberangkatanModel;


public interface KeberangkatanRepository extends JpaRepository<KeberangkatanModel, Long>{

	@Query(value="SELECT `keberangkatan`.`id`,`jurusan`.`deskripsi` ,`keberangkatan`.`tanggal`,`perusahaan`.`nama_perusahaan`,`keberangkatan`.`kelas`,`keberangkatan`.`harga` FROM `keberangkatan`\r\n"
			+ "INNER JOIN `bus` on `keberangkatan`.`no_Polisi`= `bus`.`no_Polisi`\r\n"
			+ "INNER JOIN `perusahaan` ON `bus`.`nama_perusahaan` = `perusahaan`.`nama_perusahaan`\r\n"
			+ "INNER JOIN `jurusan` ON `keberangkatan`.`jurusan_id` = `jurusan`.`jurusan_id`\r\n"
			+ "WHERE `jurusan`.`terminal_awal` = ?1 "
			+ "AND `tanggal` LIKE ?2% ", nativeQuery = true)
	
	List<BookingCustomeGetNameModel> getAllDataTerminalTanggal(String terminal, String tanggal);
	
}
