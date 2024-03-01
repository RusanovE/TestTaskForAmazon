package com.example.testtaskforamazon.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "ReportSpecifications")
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReportSpecificationEntity {

    @Id
    private String id;

    private ReportSpecification reportSpecification;

    @Data
    public static class ReportSpecification {

        private String reportType;

        private ReportOptions reportOptions;

        private String dataStartTime;

        private String dataEndTime;

        private List<String> marketplaceIds;

        @Data
        public static class ReportOptions {
            @JsonProperty("dateGranularity")
            private String dateGranularity;

            @JsonProperty("asinGranularity")
            private String asinGranularity;
        }
    }


}
