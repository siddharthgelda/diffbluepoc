package com.diffblue;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {DiffBlueServcie.class})
@ExtendWith(SpringExtension.class)
class DiffBlueServcieDiffblueTest {
    @Autowired
    private DiffBlueServcie diffBlueServcie;

    /**
     * Test {@link DiffBlueServcie#validateEmailid(String)}.
     * <ul>
     *   <li>When {@code 42 Main St}.</li>
     *   <li>Then return {@code false}.</li>
     * </ul>
     * <p>
     * Method under test: {@link DiffBlueServcie#validateEmailid(String)}
     */
    @Test
    @DisplayName("Test validateEmailid(String); when '42 Main St'; then return 'false'")
    void testValidateEmailid_when42MainSt_thenReturnFalse() {
        // Arrange, Act and Assert
        assertFalse(diffBlueServcie.validateEmailid("42 Main St"));
    }

    /**
     * Test {@link DiffBlueServcie#validateEmailid(String)}.
     * <ul>
     *   <li>When {@code jane.doe@example.org}.</li>
     *   <li>Then return {@code true}.</li>
     * </ul>
     * <p>
     * Method under test: {@link DiffBlueServcie#validateEmailid(String)}
     */
    @Test
    @DisplayName("Test validateEmailid(String); when 'jane.doe@example.org'; then return 'true'")
    void testValidateEmailid_whenJaneDoeExampleOrg_thenReturnTrue() {
        // Arrange, Act and Assert
        assertTrue(diffBlueServcie.validateEmailid("jane.doe@example.org"));
    }
}
