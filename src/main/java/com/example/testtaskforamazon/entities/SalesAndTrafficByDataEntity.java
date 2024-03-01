package com.example.testtaskforamazon.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "SalesAndTrafficByData")
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SalesAndTrafficByDataEntity {

    @Id
    String id;

    @Indexed
    List<SalesAndTrafficByDate> salesAndTrafficByDate;

    @Data
    public static class SalesAndTrafficByDate {
        @Indexed
        String date;

        private SalesByDate salesByDate;

        private TrafficByDate trafficByDate;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SalesByDate {
        @JsonProperty("orderedProductSales")
        private ProductSales orderedProductSales;

        @JsonProperty("orderedProductSalesB2B")
        private ProductSales orderedProductSalesB2B;

        @JsonProperty("unitsOrdered")
        private int unitsOrdered;

        @JsonProperty("unitsOrderedB2B")
        private int unitsOrderedB2B;

        @JsonProperty("totalOrderItems")
        private int totalOrderItems;

        @JsonProperty("totalOrderItemsB2B")
        private int totalOrderItemsB2B;

        @JsonProperty("averageSalesPerOrderItem")
        private AverageSalesPerOrderItem averageSalesPerOrderItem;

        @JsonProperty("averageSalesPerOrderItemB2B")
        private AverageSalesPerOrderItemB2B averageSalesPerOrderItemB2B;

        @JsonProperty("averageUnitsPerOrderItem")
        private float averageUnitsPerOrderItem;

        @JsonProperty("averageUnitsPerOrderItemB2B")
        private float averageUnitsPerOrderItemB2B;

        @JsonProperty("averageSellingPrice")
        private AverageSellingPrice averageSellingPrice;

        @JsonProperty("averageSellingPriceB2B")
        private AverageSellingPriceB2B averageSellingPriceB2B;

        @JsonProperty("unitsRefunded")
        private int unitsRefunded;

        @JsonProperty("refundRate")
        private float refundRate;

        @JsonProperty("claimsGranted")
        private int claimsGranted;
        @JsonProperty("claimsAmount")
        private ClaimsAmount claimsAmount;

        @JsonProperty("shippedProductSales")
        private ShippedProductSales shippedProductSales;

        @JsonProperty("unitsShipped")
        private int unitsShipped;

        @JsonProperty("ordersShipped")
        private int ordersShipped;

        @Data
        private static class AverageSalesPerOrderItem {
            private float amount;

            private String currencyCode;
        }
        @Data
        private static class AverageSalesPerOrderItemB2B {
            private float amount;

            private String currencyCode;
        }
        @Data
        private static class AverageSellingPrice {
            private float amount;

            private String currencyCode;
        }
        @Data
        private static class AverageSellingPriceB2B {
            private float amount;

            private String currencyCode;
        }
        @Data
        private static class ClaimsAmount {
            private float amount;

            private String currencyCode;
        }
        @Data
        private static class ShippedProductSales {
            private float amount;

            private String currencyCode;
        }
        @Data
        public static class ProductSales {
            @JsonProperty("amount")
            private double amount;

            @JsonProperty("currencyCode")
            private String currencyCode;
        }
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TrafficByDate {
        @JsonProperty("browserPageViews")
        private int browserPageViews;

        @JsonProperty("browserPageViewsB2B")
        private int browserPageViewsB2B;

        @JsonProperty("mobileAppPageViews")
        private int mobileAppPageViews;

        @JsonProperty("mobileAppPageViewsB2B")
        private int mobileAppPageViewsB2B;

        // ... остальные поля
    }


}
