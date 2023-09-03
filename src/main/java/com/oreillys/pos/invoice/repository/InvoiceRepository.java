package com.oreillys.pos.invoice.repository;

import com.oreillys.pos.invoice.entity.Invoice;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    List<Invoice> getInvoiceListByCustomerId(long customerId);

    @Query("select inv from Invoice inv where inv.customerId in :ids")
    List<Invoice> getInvoiceListForListOfCustomers(@Param("ids") List<Long> ids);
}
