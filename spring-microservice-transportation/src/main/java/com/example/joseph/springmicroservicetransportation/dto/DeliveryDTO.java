package com.example.joseph.springmicroservicetransportation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class DeliveryDTO {

  private Long orderId;
  private LocalDate deliveryDate;
  private String originAddress;
  private String destinationAddress;
}
