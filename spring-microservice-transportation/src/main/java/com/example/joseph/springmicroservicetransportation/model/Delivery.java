package com.example.joseph.springmicroservicetransportation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity(name = "DeliveryEntity")
@Table(name = "tbl_delivery")
public class Delivery {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long orderId;

  private LocalDate searchDate;

  private LocalDate deliveryForecast;

  private String originAddress;

  private String destinationAddress;
}
