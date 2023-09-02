package com.oreillys.pos.invoice.service.impl;

import com.oreillys.pos.invoice.entity.Invoice;
import com.oreillys.pos.invoice.exception.ResourceNotFoundException;
import com.oreillys.pos.invoice.payload.InvoiceData;
import com.oreillys.pos.invoice.payload.InvoiceDto;
import com.oreillys.pos.invoice.repository.InvoiceRepository;
import com.oreillys.pos.invoice.service.InvoiceService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private InvoiceRepository invoiceRepository;
    private ModelMapper mapper;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, ModelMapper modelMapper) {
        this.invoiceRepository = invoiceRepository;
        this.mapper = modelMapper;
    }

    @Override
    public InvoiceDto getInvoiceById(long id) {
        Invoice invoice = invoiceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invoice", "id", String.valueOf(id)));
        System.out.println("invoice " + invoice);
        InvoiceDto dto = mapToDTO(invoice);
        System.out.println("invoiceDto " + dto.getId());
        return dto;
    }

    @Override
    public Map<Long, String> getInvoiceMapByCustomerId(long customerId) {
        List<Invoice> invoiceList = invoiceRepository.getInvoiceListByCustomerId(customerId);
        Map<Long, String> invoiceMap = invoiceList.stream().collect(Collectors.toMap(Invoice::getId, Invoice::getInvoiceData));
        return invoiceMap;
    }

    @Override
    public List<Invoice> getInvoiceListByCustomerId(long id) {
        List<Invoice> invoiceList = invoiceRepository.getInvoiceListByCustomerId(id);
        System.out.println("invoice 0 " + invoiceList.get(0).getId());
        return invoiceList;
    }

    // convert entity to DTO
    private InvoiceDto mapToDTO(Invoice invoice) {
        return mapper.map(invoice, InvoiceDto.class);
    }

    // convert DTO to entity
    private Invoice mapToEntity(InvoiceDto invoiceDto) {
        return mapper.map(invoiceDto, Invoice.class);
    }
}
