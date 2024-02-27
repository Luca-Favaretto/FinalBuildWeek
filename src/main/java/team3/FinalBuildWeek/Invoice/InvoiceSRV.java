package team3.FinalBuildWeek.Invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import team3.FinalBuildWeek.customer.Customer;
import team3.FinalBuildWeek.customer.CustomerDAO;
import team3.FinalBuildWeek.customer.CustomerSRV;
import team3.FinalBuildWeek.exceptions.NotFoundException;

import java.util.List;
import java.util.UUID;

@Service
public class InvoiceSRV {
    @Autowired
    private InvoiceDAO invoiceDAO;
    @Autowired
    private CustomerSRV customerSRV;

    public Page<Invoice> getAll(int pageNumber, int size, String orderBy) {
        if (size > 100) size = 100;
        Pageable pageable = PageRequest.of(pageNumber, size, Sort.by(orderBy));
        return invoiceDAO.findAll(pageable);
    }

    public Invoice save(InvoiceDTO invoiceDTO) {
      Customer customer= customerSRV.findByEmail(invoiceDTO.email());
        return invoiceDAO.save(new Invoice(invoiceDTO.date(),invoiceDTO.amount(),invoiceDTO.invoiceNumber(),invoiceDTO.invoiceStatus(),customer));
    }
    public Invoice findById(UUID invoiceId) {
        return invoiceDAO.findById(invoiceId).orElseThrow(() -> new NotFoundException(invoiceId));
    }

    public Invoice findByIdAndUpdate(UUID invoiceId,InvoiceDTO invoiceDTO){
        Invoice found = this.findById(invoiceId);
        Customer customer=customerSRV.findByEmail(invoiceDTO.email());
        found.setDate(invoiceDTO.date());
        found.setAmount(invoiceDTO.amount());
        found.setInvoiceNumber(invoiceDTO.invoiceNumber());
        found.setInvoiceStatus(invoiceDTO.invoiceStatus());
        found.setCustomer(customer);
        return invoiceDAO.save(found);
    }

    public void findByIdAndDelete(UUID invoiceId){
        Invoice found = this.findById(invoiceId);
        invoiceDAO.delete(found);
    }
    public List<Invoice>findInvoiceByCustomer(String email){
        Customer customer= customerSRV.findByEmail(email);
       return invoiceDAO.findInvoiceByCustomer(customer);
    }
}
