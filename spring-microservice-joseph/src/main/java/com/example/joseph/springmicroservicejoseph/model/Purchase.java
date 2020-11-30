package com.example.joseph.springmicroservicejoseph.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity(name = "PurchaseEntity")
@Table(name = "tbl_purchase")
public class Purchase {

  @Id
  private Long orderId;
  private Integer preparationTime;
  private String destinationAddress;
  private LocalDate deliveryDate;
  private Long voucher;
}
