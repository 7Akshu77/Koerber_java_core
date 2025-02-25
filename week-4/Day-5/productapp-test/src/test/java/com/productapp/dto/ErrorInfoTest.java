package com.productapp.dto;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ErrorInfoTest {

    @Test
    void testEqualityAndHashcode() {
        ErrorInfo e1=new ErrorInfo("error", "description", "admin@gmail.com");
        ErrorInfo e2=new ErrorInfo("error", "description","admin@gmail.com");
        assertThat(e1).isEqualTo(e2);
        assertThat(e1.hashCode()).isEqualTo(e2.hashCode());
    }
}
