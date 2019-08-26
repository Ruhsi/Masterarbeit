package at.fh.se.master.backend.rest.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressDto {
    private String street;
    private int streetNumber;
    private String city;
    private String postalCode;
    private String country;
}
