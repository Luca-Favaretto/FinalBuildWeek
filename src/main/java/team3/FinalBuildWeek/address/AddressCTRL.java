package team3.FinalBuildWeek.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressCTRL {

    @Autowired
    AddressSRV addressSRV;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Address save(@RequestBody  AddressDTO addressDTO) {
        return addressSRV.save(addressDTO);
    }

    @GetMapping
    public Page<Address> getAll(@RequestParam(defaultValue = "0") int pageNumber,
                                @RequestParam(defaultValue = "10") int pageSize,
                                @RequestParam(defaultValue = "date") String orderBy) {
        return addressSRV.getAll(pageNumber, pageSize, orderBy);
    }


}
