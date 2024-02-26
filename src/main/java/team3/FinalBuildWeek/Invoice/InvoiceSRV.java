package team3.FinalBuildWeek.Invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team3.FinalBuildWeek.exceptions.NotFoundException;

import java.util.UUID;

@Service
public class InvoiceSRV {
    @Autowired
    private InvoiceDAO invoiceDAO;

    public Invoice saveInvoice(Invoice newInvoice) {
        invoiceDAO.findById(newInvoice.getId()).ifPresent(invoiceDAO::save);
        return invoiceDAO.save(newInvoice);
    }

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
