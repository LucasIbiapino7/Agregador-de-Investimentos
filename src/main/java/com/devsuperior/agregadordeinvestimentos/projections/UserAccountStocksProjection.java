package com.devsuperior.agregadordeinvestimentos.projections;

public interface UserAccountStocksProjection {

    String getUsername();
    String getDescription();
    String getStockId();
    String getDescriptionStock();
    Integer getQuantity();
    Long getAccountId();

}
