package team3.FinalBuildWeek.Invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/invoices")
public class InvoiceCTRL {
    @Autowired
    private InvoiceSRV invoiceSRV;

    @GetMapping
    public Page<Invoice> getAllInvoice(@RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "10") int size,
                                       @RequestParam(defaultValue = "id") String orderBy
                                       ) {
        return this.invoiceSRV.getInvoice(page, size, orderBy);
    }

    /*@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Invoice saveInvoice(@RequestBody @Validated InvoiceDTO newInvoice, BindingResult validation) {

        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        }

        return this.invoiceSRV.saveInvoice(newInvoice);
    }*/

    @GetMapping("/{id}")
    public Invoice findById(@PathVariable UUID id) {
        return this.invoiceSRV.findById(id);
    }

    @PutMapping("/{id}")
    public Invoice findByIdAndUpdate(@PathVariable UUID id, @RequestBody Invoice updateInvoice){
        return this.invoiceSRV.findByIdAndUpdate(id, updateInvoice);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable UUID id){
        this.invoiceSRV.findByIdAndDelete(id);
    }

}
