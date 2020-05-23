package edu.soham.vr.app.backend.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

/**
 * @author sohamc.
 */

@Data
@NoArgsConstructor
@Entity
@Table(name = "password")
public class Password {

    @Id
    @Column(name = "password_id")
    private String passwordId = UUID.randomUUID().toString();

    private String passwordHash;

    public String getPasswordId() {
        return passwordId;
    }

    public void setPasswordId(String passwordId) {
        this.passwordId = passwordId;
    }


    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
