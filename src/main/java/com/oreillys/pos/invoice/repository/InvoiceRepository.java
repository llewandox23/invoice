package com.oreillys.pos.invoice.repository;

import com.oreillys.pos.invoice.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    List<Invoice> getInvoiceListByCustomerId(long id);
}
