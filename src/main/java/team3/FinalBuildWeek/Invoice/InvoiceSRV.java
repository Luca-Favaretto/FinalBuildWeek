package team3.FinalBuildWeek.Invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceSRV {
    @Autowired
    private InvoiceDAO invoiceDAO;

    public Invoice saveInvoice(Invoice newInvoice) {
        invoiceDAO.findById(newInvoice.getId()).ifPresent(invoiceDAO::save);
        return invoiceDAO.save(newInvoice);
    }
}
