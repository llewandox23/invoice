package com.oreillys.pos.invoice.repository;

import com.oreillys.pos.invoice.entity.Invoice;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class InvoiceInsertRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public long insertInvoice(Invoice invoice) {
        entityManager.persist(invoice);
        entityManager.flush();
        return invoice.getId();
    }

}
