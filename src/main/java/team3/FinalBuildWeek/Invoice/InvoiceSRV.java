package team3.FinalBuildWeek.Invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Invoice findByIdAndUdate(UUID invoiceId, Invoice modifiedInvoice){
        Invoice found = this.findById(invoiceId);
    }
}
