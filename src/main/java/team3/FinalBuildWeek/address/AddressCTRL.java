package team3.FinalBuildWeek.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import team3.FinalBuildWeek.exceptions.BadRequestException;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/address")
public class AddressCTRL {

    @Autowired
    AddressSRV addressSRV;

    @GetMapping
    public Page<Address> getAll(@RequestParam(defaultValue = "0") int pageNumber,
                                @RequestParam(defaultValue = "10") int pageSize,
                                @RequestParam(defaultValue = "date") String orderBy) {
        return addressSRV.getAll(pageNumber, pageSize, orderBy);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Address save(@RequestBody @Validated AddressDTO addressDTO, BindingResult validation) throws IOException {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        }
        return addressSRV.save(addressDTO);
    }

    @GetMapping("/{id}")
    public Address findById(@PathVariable UUID id){
        return this.addressSRV.findById(id);
    }

    @PutMapping("/{id}")
    public Address findByIdAndUpdate(@PathVariable UUID id, @RequestBody Address updatedAddress) {
        return this.addressSRV.findByIdAndUpdate(id, updatedAddress);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable UUID id){
        this.addressSRV.deleteById(id);
    }


}
