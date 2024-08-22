package com.sac.multiple_datasource.exception;

import lombok.Builder;
import lombok.Data;

/**
 * @author Sachith Harshamal
 */
@Data
@Builder
public class Response {

    private String responseCode;
    private String responseDescription;
}
