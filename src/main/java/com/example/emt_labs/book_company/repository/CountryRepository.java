package com.example.emt_labs.book_company.repository;

import com.example.emt_labs.book_company.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
