package at.fh.se.master.backend.rest.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PhoneNumberDto {
    private String phoneNumber;
    private boolean isPrivate;
}
