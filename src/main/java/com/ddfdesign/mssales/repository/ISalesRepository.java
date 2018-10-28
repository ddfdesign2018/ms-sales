package com.ddfdesign.mssales.repository;

import com.ddfdesign.mssales.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISalesRepository extends JpaRepository<Sale, Long> {
}
