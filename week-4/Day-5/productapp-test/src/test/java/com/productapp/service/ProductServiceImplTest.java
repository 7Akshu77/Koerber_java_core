package com.productapp.service;

import com.productapp.exceptions.ProductNotFoundException;
import com.productapp.repo.Product;
import com.productapp.repo.ProductRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private ProductRepo productRepo;

    @InjectMocks
    private ProductServiceImpl productService;

    private Product product;

    @BeforeEach
    void setUp() {
        product=new Product("laptop", 120000);
    }

    @DisplayName("JUnit test for save Product method")
    @Test
    public void givenProductObject_whenSaveProduct_thenReturnProductObject(){
        // given - precondition or setup
        given(productRepo.save(product)).willReturn(product);
        Product savedProduct = productService.addProduct(product);
        assertThat(savedProduct).isNotNull();
    }


    @DisplayName("JUnit test for getAll Product method")
    @Test
    public void givenProductList_whenGetAllProduct_thenReturnProductList(){
        // given - precondition or setup
        Product  product2=new Product("laptop cover", 1200);

        given(productRepo.findAll()).willReturn(List.of(product,product2));

        // when -  action or the behaviour that we are going test
        List<Product> productList = productService.getAll();

        // then - verify the output
        Assertions.assertThat(productList).isNotNull();
        Assertions.assertThat(productList.size()).isEqualTo(2);
    }


    @DisplayName("JUnit test for getAll Product method (negative scenario)")
    @Test
    public void givenEmptyEmployeesList_whenGetAllEmployees_thenReturnEmptyEmployeesList(){
        // given - precondition or setup
        given(productRepo.findAll()).willReturn(Collections.emptyList());

        // when -  action or the behaviour that we are going test
        List<Product> employeeList = productService.getAll();
        // then - verify the output
        Assertions.assertThat(employeeList).isEmpty();
        Assertions.assertThat(employeeList.size()).isEqualTo(0);
    }

    @DisplayName("JUnit test for delete Product method")
    @Test
    public void givenProductId_whenDeleteProduct_thenReturnProductObject(){
        // given - precondition or setup
        int productId = 1;
        Product product2 = new Product("laptop cover", 1200);
        product2.setId(productId);
        given(productRepo.findById(productId)).willReturn(Optional.of(product2));

        // when -  action or the behaviour that we are going test
        Product deletedProduct = productService.deleteProduct(productId);
        // then - verify the output
        verify(productRepo, times(1)).delete(product2);
        assertThat(deletedProduct).isNotNull();
        assertThat(deletedProduct.getId()).isEqualTo(productId);
    }

    @DisplayName("when the product does not exsist to delete(negative scenario)")
    @Test
    public void givenInvalidProductId_whenDeleteProduct_thenReturnProductObject() {
        // given - precondition or setup
        given(productRepo.findById(1)).willReturn(Optional.empty());
        int productId = 1;
        // when -  action or the behaviour that we are going test
        assertThatThrownBy(() -> productService.deleteProduct(productId))
                .isInstanceOf(ProductNotFoundException.class)
                .hasMessageContaining("product with id " + productId + " is not found");
    }

    @AfterEach
    void tearDown() {
    }
}