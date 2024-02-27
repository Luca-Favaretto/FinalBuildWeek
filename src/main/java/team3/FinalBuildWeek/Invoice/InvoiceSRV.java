package team3.FinalBuildWeek.Invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import team3.FinalBuildWeek.customer.CustomerDAO;
import team3.FinalBuildWeek.exceptions.NotFoundException;

import java.util.UUID;

@Service
public class InvoiceSRV {
    @Autowired
    private InvoiceDAO invoiceDAO;
    @Autowired
    private CustomerDAO customerDAO;

    public Page<Invoice> getInvoice(int pageNumber, int size, String orderBy) {
        if (size > 100) size = 100;
        Pageable pageable = PageRequest.of(pageNumber, size, Sort.by(orderBy));
        return invoiceDAO.findAll(pageable);
    }

    /*public Invoice saveInvoice(InvoiceDTO newInvoice) {
        invoiceDAO.findById(newInvoice.getId()).ifPresent(invoiceDAO::save);
        return invoiceDAO.save(newInvoice);
    }*/

    public Invoice findById(UUID invoiceId) {
        return invoiceDAO.findById(invoiceId).orElseThrow(() -> new NotFoundException(invoiceId));
    }

    public Invoice findByIdAndUpdate(UUID invoiceId, Invoice modifiedInvoice){
        Invoice found = this.findById(invoiceId);
        found.setDate(modifiedInvoice.getDate());
        found.setAmount(modifiedInvoice.getAmount());
        found.setInvoiceNumber(modifiedInvoice.getInvoiceNumber());
        found.setInvoiceStatus(modifiedInvoice.getInvoiceStatus());
        found.setCustomer(modifiedInvoice.getCustomer());
        return invoiceDAO.save(found);
    }

    public void findByIdAndDelete(UUID invoiceId){
        Invoice found = this.findById(invoiceId);
        invoiceDAO.delete(found);
    }
}
