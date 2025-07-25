package core.api.prime_max.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.net.InetAddress;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class TestFlow implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String owner;

    private InetAddress address;

    private String hash;

    private String date;
}
