package com.example.joseph.springmicroservicefornecedor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class ReservationDTO {

  public Integer idReserve;
  public Integer preparationTime;
}
