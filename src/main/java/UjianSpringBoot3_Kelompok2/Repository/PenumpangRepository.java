package UjianSpringBoot3_Kelompok2.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import UjianSpringBoot3_Kelompok2.model.PenumpangModel;

public interface PenumpangRepository extends JpaRepository<PenumpangModel, String>{

	@Query(value = "SELECT * FROM penumpang WHERE nik = ?1 && nama = ?2 && telepon = ?3", nativeQuery = true)
	List<PenumpangModel> findByNikNamaTelepon (String nik, String nama, String telepon);
	
	
}
