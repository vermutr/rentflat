package com.pk.rentflat.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "offers")
public class Offers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "city")
    private String city;

    @Column(name = "street_address")
    private String streetAddress;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "price")
    private Float price;

    @Column(name = "area")
    private Integer area;

    @Column(name = "room_count")
    private Integer roomCount;

    @Column(name = "market_type")
    private String marketType;

    @Column(name = "description")
    private String description;

    @Column(name = "district")
    private String district;

    @Column(name = "main_picture")
    private byte[] mainPicture;

    @OneToOne
    @JoinColumn(name = "owner", referencedColumnName = "id")
    private CustomerDetails customerDetails;

    @Column(name = "building_details")
    private Integer buildingDetails;

    @Column(name = "available_from")
    private LocalDate availableFrom;

    @Column(name = "available_until")
    private LocalDate availableUntil;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Offers offers = (Offers) o;
        return id != null && Objects.equals(id, offers.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}

