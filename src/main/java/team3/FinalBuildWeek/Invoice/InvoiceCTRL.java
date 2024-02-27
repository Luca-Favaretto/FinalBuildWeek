package team3.FinalBuildWeek.Invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/invoices")
public class InvoiceCTRL {
    @Autowired
    private InvoiceSRV invoiceSRV;

    @GetMapping
    public Page<Invoice> getAll(@RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "10") int size,
                                       @RequestParam(defaultValue = "id") String orderBy
                                       ) {
        return this.invoiceSRV.getAll(page, size, orderBy);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Invoice save(@RequestBody InvoiceDTO invoiceDTO){
       return invoiceSRV.save(invoiceDTO);
    }


    @GetMapping("/{id}")
    public Invoice findById(@PathVariable UUID id) {
        return this.invoiceSRV.findById(id);
    }

    @PutMapping("/{id}")
    public Invoice findByIdAndUpdate(@PathVariable UUID id, @RequestBody InvoiceDTO updateInvoice){
        return this.invoiceSRV.findByIdAndUpdate(id, updateInvoice);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable UUID id){
        this.invoiceSRV.findByIdAndDelete(id);
    }

    @GetMapping("/emailCustomer")
    public List<Invoice> findInvoiceByCustomer(@PathVariable String email){
        return this.findInvoiceByCustomer(email);
    }
}
