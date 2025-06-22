package com.example.UberReviewService.repositoiries;

import com.example.UberReviewService.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Long> {
    Optional<Driver> findByIdAndLicenseNumber(Long id, String licenseNumber);

    @Query(nativeQuery = true, value = "SELECT * FROM driver WHERE id = :id AND license_number = :licenseNumber")
    Optional<Driver> rawfindByIdAndLicenseNumber(Long id, String licenseNumber); //raq, Mysql query error is thrown at run time

    @Query("From Driver as d WHERE d.id = :id AND d.licenseNumber = :ln") //JPQL query
    Optional<Driver> hqlFindByIdAndLicense(Long id, String ln); //JPQL query error is thrown at compile time
}
