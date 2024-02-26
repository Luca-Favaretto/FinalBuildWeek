package team3.FinalBuildWeek.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import team3.FinalBuildWeek.exceptions.NotFoundException;

import java.util.UUID;

@Service
public class AddressSRV {

    @Autowired
    AddressDAO addressDAO;

    public Page<Address> getAll(int pageNumber, int pageSize, String orderBy) {
        if (pageNumber > 20) pageSize = 20;
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(orderBy));
        return addressDAO.findAll(pageable);
    }

    public Address save(AddressDTO addressDTO) {
        Address address = new Address(addressDTO.address(), addressDTO.number(), addressDTO.Location(), addressDTO.PostCode(), addressDTO.cityHall());

        return addressDAO.save(address);
    }

    public Address findById(UUID id) {

        return addressDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }


    public void deleteById(UUID id) {
        Address found = findById(id);
        addressDAO.delete(found);
    }

}
