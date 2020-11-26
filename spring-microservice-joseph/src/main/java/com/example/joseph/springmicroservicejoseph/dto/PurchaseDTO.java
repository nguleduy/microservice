package com.example.joseph.springmicroservicejoseph.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class PurchaseDTO {

  private List<PurchaseItemDTO> items;
  private AddressDTO address;
}
