package com.gepardec.app.backend.common;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.Instant;

@Data
@NoArgsConstructor
@Embeddable
public class StatusItem implements Serializable {

    @Column(name = "CANCELED", nullable = false)
    private boolean canceled = false;

    @Column(name = "CANCEL_TIME")
    private Instant cancelTime;
}
