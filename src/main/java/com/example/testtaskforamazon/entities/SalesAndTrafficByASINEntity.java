package com.example.testtaskforamazon.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "SalesAndTrafficByAsin")
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SalesAndTrafficByASINEntity {

    @Id
    String id;

    @Indexed
    List<SalesAndTrafficByAsin> salesAndTrafficByAsin;

    @Data
    public static class SalesAndTrafficByAsin {
        @Indexed
        String parentAsin;

        private SalesByASIN salesByAsin;

        private TrafficByASIN trafficByAsin;

        @Data
        public static class SalesByASIN {

            @JsonProperty("unitsOrdered")
            private int unitsOrdered;

            @JsonProperty("unitsOrderedB2B")
            private int unitsOrderedB2B;

            @JsonProperty("orderedProductSales")
            private OrderedProductSales orderedProductSales;

            @JsonProperty("orderedProductSalesB2B")
            private OrderedProductSalesB2B orderedProductSalesB2B;

            @JsonProperty("totalOrderItems")
            private int totalOrderItems;

            @JsonProperty("totalOrderItemsB2B")
            private int totalOrderItemsB2B;

            @Data
            private static class OrderedProductSales {
                private float amount;

                private String currencyCode;
            }

            @Data
            private static class OrderedProductSalesB2B {
                private float amount;

                private String currencyCode;
            }
        }

        @Data
        public static class TrafficByASIN {

            @JsonProperty("browserSessions")
            private int browserSessions;

            @JsonProperty("browserSessionsB2B")
            private int browserSessionsB2B;

            @JsonProperty("mobileAppSessions")
            private int mobileAppSessions;

            @JsonProperty("mobileAppSessionsB2B")
            private int mobileAppSessionsB2B;

            @JsonProperty("sessions")
            private int sessions;

            @JsonProperty("sessionsB2B")
            private int sessionsB2B;

            @JsonProperty("browserSessionPercentage")
            private float browserSessionPercentage;

            @JsonProperty("browserSessionPercentageB2B")
            private int browserSessionPercentageB2B;

            @JsonProperty("mobileAppSessionPercentage")
            private float mobileAppSessionPercentage;

            @JsonProperty("mobileAppSessionPercentageB2B")
            private int mobileAppSessionPercentageB2B;

            @JsonProperty("sessionPercentage")
            private float sessionPercentage;

            @JsonProperty("sessionPercentageB2B")
            private int sessionPercentageB2B;

            @JsonProperty("browserPageViews")
            private int browserPageViews;

            @JsonProperty("browserPageViewsB2B")
            private int browserPageViewsB2B;

            @JsonProperty("mobileAppPageViews")
            private int mobileAppPageViews;

            @JsonProperty("mobileAppPageViewsB2B")
            private int mobileAppPageViewsB2B;

            @JsonProperty("pageViews")
            private int pageViews;

            @JsonProperty("pageViewsB2B")
            private int pageViewsB2B;

            @JsonProperty("browserPageViewsPercentage")
            private float browserPageViewsPercentage;

            @JsonProperty("browserPageViewsPercentageB2B")
            private int browserPageViewsPercentageB2B;

            @JsonProperty("mobileAppPageViewsPercentage")
            private float mobileAppPageViewsPercentage;

            @JsonProperty("mobileAppPageViewsPercentageB2B")
            private int mobileAppPageViewsPercentageB2B;

            @JsonProperty("pageViewsPercentage")
            private float pageViewsPercentage;

            @JsonProperty("pageViewsPercentageB2B")
            private int pageViewsPercentageB2B;

            @JsonProperty("buyBoxPercentage")
            private int buyBoxPercentage;

            @JsonProperty("buyBoxPercentageB2B")
            private int buyBoxPercentageB2B;

            @JsonProperty("unitSessionPercentage")
            private float unitSessionPercentage;

            @JsonProperty("unitSessionPercentageB2B")
            private int unitSessionPercentageB2B;

        }
    }
}
