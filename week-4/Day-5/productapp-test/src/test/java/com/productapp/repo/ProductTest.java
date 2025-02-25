package com.productapp.repo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ProductTest {

    @Test
    void testEqualityAndHashcode() {
        Product p1=new Product("laptop", 120000);
        Product p2=new Product("laptop", 120000);
        Product p3=new Product("laptop cover", 1200);
        assertThat(p1).isEqualTo(p2);
        assertThat(p1.hashCode()).isEqualTo(p2.hashCode());

        assertThat(p1).isNotEqualTo(p3);
    }
}
