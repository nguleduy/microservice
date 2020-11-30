package com.example.joseph.springmicroservicejoseph.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

  @JsonIgnore
  private Long purchaseId;
  private List<PurchaseItemDTO> items;
  private AddressDTO address;
}
