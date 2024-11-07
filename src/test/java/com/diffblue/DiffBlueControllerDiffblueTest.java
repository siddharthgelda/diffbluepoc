package com.diffblue;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {DiffBlueController.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class DiffBlueControllerDiffblueTest {
    @Autowired
    private DiffBlueController diffBlueController;

    @MockBean
    private DiffBlueServcie diffBlueServcie;

    /**
     * Test {@link DiffBlueController#validateEmail(String)}.
     * <ul>
     *   <li>Given {@link DiffBlueServcie}
     * {@link DiffBlueServcie#validateEmailid(String)} return {@code true}.</li>
     *   <li>Then status {@link StatusResultMatchers#isOk()}.</li>
     * </ul>
     * <p>
     * Method under test: {@link DiffBlueController#validateEmail(String)}
     */
    @Test
    @DisplayName("Test validateEmail(String); given DiffBlueServcie validateEmailid(String) return 'true'; then status isOk()")
    void testValidateEmail_givenDiffBlueServcieValidateEmailidReturnTrue_thenStatusIsOk() throws Exception {
        // Arrange
        when(diffBlueServcie.validateEmailid(Mockito.<String>any())).thenReturn(true);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api").param("emailId", "foo");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(diffBlueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"status\":200,\"message\":\"valid EmailId\"}"));
    }

    /**
     * Test {@link DiffBlueController#validateEmail(String)}.
     * <ul>
     *   <li>Then status four hundred.</li>
     * </ul>
     * <p>
     * Method under test: {@link DiffBlueController#validateEmail(String)}
     */
    @Test
    @DisplayName("Test validateEmail(String); then status four hundred")
    void testValidateEmail_thenStatusFourHundred() throws Exception {
        // Arrange
        when(diffBlueServcie.validateEmailid(Mockito.<String>any())).thenReturn(false);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api").param("emailId", "foo");

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(diffBlueController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"status\":400,\"message\":\"EmailId not valid\"}"));
    }
}
