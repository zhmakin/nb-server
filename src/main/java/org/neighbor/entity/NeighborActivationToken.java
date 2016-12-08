package org.neighbor.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class NeighborActivationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long userId;
    private NeighborUser user;
    private String token;
    private TokenStatus tokenStatus;
    private Date createdOn;
    private Date validTo;

}
